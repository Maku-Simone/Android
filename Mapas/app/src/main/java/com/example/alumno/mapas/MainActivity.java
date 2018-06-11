    package com.example.alumno.mapas;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnDesactivar;
    TextView lblLatitud, lblLongitud, lblPrecision, lblEstado;
    LocationManager locManager = (LocationManager)getSystemService(LOCATION_SERVICE);
    List<String> listaProviders = locManager.getAllProviders();
    LocationProvider provider = locManager.getProvider(listaProviders.get(0));
    int precision = provider.getAccuracy();
    boolean obtieneAltitud = provider.supportsAltitude();
    int consumoRecursos = provider.getPowerRequirement();
    Criteria req = new Criteria();
    req.setAccuracy(Criteria.ACCURACY_FINE);
    req.setAltitudeRequired(true);
    String mejorProviderCrit = locManager.getBestProvider(req, false);//Mejor proveedor por criterio
    List<String> listaProvidersCrit = locManager.getProviders(req, false); //Lista por criterio

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblEstado = findViewById(R.id.tvProvider);
        lblLatitud = findViewById(R.id.tvLat);
        lblLongitud = findViewById(R.id.tvLong);
        lblPrecision = findViewById(R.id.tvPres);

        btnDesactivar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                locManager.removeUpdates(locListener);
            }
        });
    }

    LocationListener locListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            mostrarPosicion(location);
        }
        public void onProviderDisabled(String provider){
            lblEstado.setText("Proveedor en OFF");
        }
        public void onProviderEnabled(String provider){
            lblEstado.setText("Proveedor en ON");
        }
        public void onStatusChanged(String provider, int status, Bundle extras){
            lblEstado.setText("Status del Proveedor: " + status);
        }
    };

    private void comenzarLocalizacion(){
        if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){ //Si el GPS no está habilitado
            mostrarAvisoGpsDeshabilitado();
        }

        locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        mostrarPosicion(loc); //Obtenemos la última posición conocida y mostrarla
        locListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                mostrarPosicion(location);
            }
        };
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 0, locListener);
    }


    private void mostrarPosicion(Location loc) {
        if(loc != null)
            {
                lblLatitud.setText("Latitud: " + String.valueOf(loc.getLatitude()));
                lblLongitud.setText("Longitud: " + String.valueOf(loc.getLongitude()));
                lblPrecision.setText("Precision: " + String.valueOf(loc.getAccuracy()));
            }
        else
            {
                lblLatitud.setText("Latitud: (sin_datos)");
                lblLongitud.setText("Longitud: (sin_datos)");
                lblPrecision.setText("Precision: (sin_datos)");
            }
    }

    private void actualizarPosicion(){
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        mostrarPosicion(location);
        locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                mostrarPosicion(location);
            }
            public void onProviderDisabled(String provider){
                lblEstado.setText("Provider OFF");
            }
            public void onProviderEnabled(String provider){
                lblEstado.setText("Provider ON");
            }
            public void onStatusChanged(String provider, int status, Bundle extras){
                Log.i("LocAndroid", "Provider Status: " + status);
                lblEstado.setText("Provider Status: " + status);
            }
        };
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 15000, 0, locationListener);
    }

}