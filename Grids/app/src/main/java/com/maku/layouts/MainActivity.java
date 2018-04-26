package com.maku.layouts;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

        Button a,b,c,d,e,f,g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // cape = (LinearLayout) findViewById(R.id.capa);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = (Button) findViewById(R.id.frameb);
        b = (Button) findViewById(R.id.grid);
        c = (Button) findViewById(R.id.lineal);
        d = (Button) findViewById(R.id.relativo);
        e = (Button) findViewById(R.id.reng);
        f = (Button) findViewById(R.id.scroll);
        g = (Button) findViewById(R.id.table);


        a.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setContentView(R.layout.frame);
            }
        });
        b.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setContentView(R.layout.grid);
            }
        });
        c.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setContentView(R.layout.lineal);
            }
        });
        d.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setContentView(R.layout.relativo);
            }
        });
        e.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setContentView(R.layout.renglones);
            }
        });
        f.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setContentView(R.layout.scroll);
            }
        });
        g.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setContentView(R.layout.table);
            }
        });

    }
}
