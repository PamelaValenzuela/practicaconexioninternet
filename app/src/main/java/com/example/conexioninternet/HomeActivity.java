package com.example.conexioninternet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //no estoy segura si se debe llamar al metodo o solo basta con el onclick en el layout
    }
    public void openActivityCheckConnection(View v){
        Intent intent = new Intent(this, HomeDetailActivity.class);
        startActivity(intent);
    }
}
