package com.maku.numeros;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity   {

    Button btnCalc;
    EditText num1;
    TextView txtv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalc = (Button) findViewById(R.id.boton);
        num1 = (EditText) findViewById(R.id.edtxtNum);
        txtv = (TextView) findViewById(R.id.tvResult);

        btnCalc.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v)
                {
                    // TODO Auto-generated method stub
                    String cadena = "";
                    int num;
                    num = Integer.parseInt(num1.getText().toString());
                    cadena += "\nEl factorial de " + num +  " es " + factorial(num);
                    if(primo(num))
                        {
                            cadena += "\n" + num + " es primo";
                        }
                    else
                        {
                            cadena += "\n" + num + "no es primo";
                        }
                    if(Fibo(num))
                    {
                        cadena += "\n" + num + " está en la serie de fibonacci";
                    }
                    else
                    {
                        cadena += "\n" + num + "no está en la serie de fibonacci";
                    }

                    cadena += "\n" + maravilloso(num);

                    txtv.setText(cadena);
                }
        });
    }





    private int factorial(int f)
    {
        int contador = f - 1;
        while(contador > 0)
        {
            f *= contador;
            contador--;
        }
        return f;
    }

    private boolean primo(int p)
    {
        for(int i = 2; i < p; i++)
        {
            if(p%i == 0)
            {
                return false;
            }
        }
        return true;
    }
    private boolean Fibo(int n)
    {
        int f[] = new int[101]; //+1 por el mes 0
        for(int i = 0; i <= 100; i++)
        {
            if(i == 0)
            {
                f[0] = 0;
            }
            else
            {
                if(i == 1)
                {
                    f[1] = 1;
                }
                else
                {
                    f[i] = f[i-1] + f[i-2];
                    System.out.println(f[i]);
                }
            }//else
            if(n == f[i])
            {
                return true;
            }
        }//for
        return false;
    }

    private String maravilloso(int m)
    {
        String ruta;
        ruta = "Numero: " + m + "\n";
        while(m > 1)
        {
            if(m%2 == 0)
            {
                ruta += m+"/2 = ";
                m /= 2;
            }
            else
            {
                ruta += "3(" + m + ") + 1 = ";
                m = 3*m + 1;
            }
            ruta += m + "\n";
            if(m == 1)
            {
                return ruta;
            }
        }
        return "";
    }


}
