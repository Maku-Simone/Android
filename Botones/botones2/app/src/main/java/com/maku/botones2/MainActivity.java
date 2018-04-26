package com.maku.botones2;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.Toast;
import android.support.design.widget.FloatingActionButton;
public class MainActivity extends Activity
    {
        FloatingActionButton jfab, jfab2;
        protected void onCreate(Bundle b)
            {
                super.onCreate(b);
                setContentView(R.layout.activity_main);
                jfab = (FloatingActionButton) findViewById(R.id.xfab);
                jfab2 = (FloatingActionButton) findViewById(R.id.xfab2);
                jfab.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View view)
                        {
                            Toast.makeText(MainActivity.this, "Soy un botón Flotante :3", Toast.LENGTH_LONG).show();
                        }
                });
                jfab2.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View view)
                        {
                            Toast.makeText(MainActivity.this, "Soy otro botón Flotante *3*", Toast.LENGTH_LONG).show();
                        }
                });
            }
    }