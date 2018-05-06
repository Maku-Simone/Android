package com.maku.examen;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static android.content.ContentValues.TAG;
import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class Fragmento extends Fragment
    {
        TextView size, t1, t2, t3;
        Button otroBtn, salirBtn;
        TableLayout tablaSensual;
        String numerito = "";



        @Override
        public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b)
            {
                int suma = 0, contador = 0;
                int cadena[] = getArguments().getIntArray("cadena");
                int num = getArguments().getInt("numero");
                View vista =  li.inflate(R.layout.fragmento, vg, false);
                size = vista.findViewById(R.id.sizeTabla);
                otroBtn = (Button) vista.findViewById(R.id.otro);
                salirBtn = (Button) vista.findViewById(R.id.Salir);

                otroBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
                });

                salirBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                });

                //t1 = vista.findViewById(R.id.t1);
                tablaSensual = (TableLayout) vista.findViewById(R.id.tablita);
                tablaSensual.setBackgroundColor(Color.BLACK);
                size.setText("Tamaño: " + num);

                for(int i = 0; i < num; i++)
                    {
                        suma += cadena[i];
                    }

                for(int i = 0; i < num + 1; i++)
                    {
                       TableRow tableRow = new TableRow(getActivity());
                       tableRow.setPadding(2,1,1,1);
                        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
                        tableRowParams.setMargins(1, 1, 1, 1);
                        tableRowParams.weight = 1;


                        if(i == num)
                            {
                                for(int j = 0; j < num + 1; j++)
                                {
                                    TextView t = new TextView(getActivity());
                                    t.setPadding(10,2,2,2);
                                    t.setTextSize(15);
                                    t.setGravity(Gravity.CENTER);
                                    t.setBackgroundColor(Color.BLACK);
                                    t.setTextColor(Color.WHITE);
                                    t.setText(String.valueOf(suma));
                                    tableRow.addView(t, tableRowParams);
                                }
                            }
                        else
                            {
                                for(int j = 0; j < num + 1; j++)
                                {
                                    TextView t = new TextView(getActivity());
                                    t.setPadding(10,2,2,2);
                                    t.setGravity(Gravity.CENTER);
                                    t.setTextSize(15);
                                    if(j == num)
                                    {
                                        t.setText(String.valueOf(suma));
                                        t.setBackgroundColor(Color.BLACK);
                                        t.setTextColor(Color.WHITE);
                                    }
                                    else
                                    {
                                        t.setText(String.valueOf(cadena[contador]));
                                        t.setBackgroundColor(Color.WHITE);
                                        t.setTextColor(Color.BLACK);
                                        contador++;
                                    }
                                    tableRow.addView(t, tableRowParams);
                                }
                            }
                         tablaSensual.addView(tableRow);
                    }

                return vista;
            }

        public void pintaTabla(String t)
            {

            }
    }
