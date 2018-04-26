package com.maku.intentos2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText a, bx, c;
    Button jbn;
    Bundle bdl;
    Intent itn;
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        a = (EditText) findViewById(R.id.eta);
        bx = (EditText) findViewById(R.id.etb);
        c = (EditText) findViewById(R.id.etc);
        jbn = findViewById(R.id.acep);

        jbn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("AX", a.getText().toString());
                bdl.putString("BX", bx.getText().toString());
                bdl.putString("CX", c.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
}}
