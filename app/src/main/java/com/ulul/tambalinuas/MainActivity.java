package com.ulul.tambalinuas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.cariposisi);
        Button btn2 = (Button) findViewById(R.id.caritambalban);
        Button btn3 = (Button) findViewById(R.id.btn_search);

    }

    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    public void Pindah2(View view) {
        Intent intent = new Intent(MainActivity.this, MapsActivity2.class);
        startActivity(intent);
    }

    public void Pindah3(View view) {
        Intent intent = new Intent(MainActivity.this, MapsActivity3.class);
        startActivity(intent);
    }
}
