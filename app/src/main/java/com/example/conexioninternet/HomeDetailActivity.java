package com.example.conexioninternet;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeDetailActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastNetworkReceiver;
    static TextView connectionStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
        connectionStatus= findViewById(R.id.connectionStatus);
        broadcastNetworkReceiver = new NetworkStatusReceiver();

        registerNetworkBroadcastForNougat();

    }
    public static void messageConnectionStatus(boolean value){
        if(value){
            connectionStatus.setText("¡Tenemos acceso a internet!");
            connectionStatus.setBackgroundColor(Color.GREEN);
            connectionStatus.setTextColor(Color.WHITE);
        }else {
            connectionStatus.setVisibility(View.VISIBLE);
            connectionStatus.setText("¡No podemos conectarnos!");
            connectionStatus.setBackgroundColor(Color.RED);
            connectionStatus.setTextColor(Color.WHITE);
        }
    }
    private void registerNetworkBroadcastForNougat() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(broadcastNetworkReceiver, new
                    IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }
    protected void unregisterNetworkChanges() {
        try {
            unregisterReceiver(broadcastNetworkReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterNetworkChanges();
    }
}
