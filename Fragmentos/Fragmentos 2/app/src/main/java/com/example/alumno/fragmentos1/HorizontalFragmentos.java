package com.example.alumno.fragmentos1;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class HorizontalFragmentos extends Fragment
{
    @Override public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b)
    {
        return li.inflate(R.layout.horizontal_fragmento, vg, false);
    }
}