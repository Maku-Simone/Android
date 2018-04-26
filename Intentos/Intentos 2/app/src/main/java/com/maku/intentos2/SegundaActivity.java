package com.maku.intentos2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends Activity{
    TextView jet;
    Bundle bdl;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        jet = findViewById(R.id.xtv1);
        bdl = getIntent().getExtras();
        int a, bx, c, d;
        double raiz1 = 0, raiz2 = 0;
        String cadena = "";
        a = Integer.parseInt(bdl.getString("AX"));
        bx = Integer.parseInt(bdl.getString("BX"));
        c = Integer.parseInt(bdl.getString("CX"));



        d = bx * bx - 4 * a * c;
        cadena += "\nCalculando raices de: " + a + "x^2 + " + bx + "x +" + c;
        cadena += "\n\n Discriminante = b^2 - 4ac";
        cadena += "\n d = (" + bx + ")^2  -4(" + a + "*" + c +")";
        cadena += "\n d = " + (bx * bx)  + "-4(" + a * c +")";
        cadena += "\n d = " + (bx * bx)  + "-" + 4*(a * c);
        cadena += "\n d = " + d;
        if(d > 0)
            {
                cadena += "\nRaices únicas y reales";
                raiz1 = (-bx + Math.sqrt(d))/(2*a);
                raiz2 = (-bx - Math.sqrt(d))/(2*a);
                cadena += "\nRaiz #1: [-" + bx + " + raiz(" + d + ")] / (2 * " + a + ")  = " + raiz1;
                cadena += "\nRaiz #2: [-" + bx + " - raiz(" + d + ")] / (2 * " + a + ")  = " + raiz2;
            }
        else if(d == 0)
            {
                cadena += "\nRaices reales e iguales";
                raiz1 = (-bx+Math.sqrt(d))/(2*a);
                raiz2 = raiz1;
                cadena += "\nRaiz #1: [-" + bx + " + raiz(" + d + ")] / (2 * " + a + ")  = " + raiz1;
                cadena += "\nRaiz #2: [-" + bx + " + raiz(" + d + ")] / (2 * " + a + ")  = " + raiz2;
            }
        else
            {
                cadena += "\nRaices Imaginarias";
            }
        jet.setText(cadena);

    }
}