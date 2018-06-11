package com.example.alumno.nfc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.tech.NfcA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private static final int DIALOG_WRITE_URL = 1;
private EditText url;
private Button writebtn;
private boolean mWriteUrl = false;
private static final int PENDING_INTENT_TECH_DISCOVERED = 1;
private NfcAdapter mnfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = findViewById(R.id.texto);
        writebtn = findViewById(R.id.escribitr);

        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWriteUrl = true;
                MainActivity.this.showDialog(DIALOG_WRITE_URL);
            }
        });
    }


    @Override
    protected android.app.Dialog onCreateDialog(int id, Bundle args) {
        switch (id)
            {
                case DIALOG_WRITE_URL:
                    return new AlertDialog.Builder(this)
                            .setTitle("Escribiendo en el NFC :3")
                            .setMessage("Picame para empezar a escribirle")
                            .setCancelable(true)
                            .setNeutralButton(android.R.string.cancel,
                                new DialogInterface.OnClickListener()
                                {
                                  public void onClick(DialogInterface d, int arg)
                                  {
                                      d.cancel();
                                  }
                                })
                            .setOnCancelListener(new DialogInterface.OnCancelListener() {
                                @Override
                                public void onCancel(DialogInterface dialog) {
                                    mWriteUrl = false;
                                }
                            }).create();
            }
            return null;
    }

    @Override
    public void onResume()
        {
            super.onResume();
            NfcManager nfcManager = (NfcManager) this.getSystemService(Context.NFC_SERVICE);
            mnfcAdapter = nfcManager.getDefaultAdapter();

            PendingIntent pi = createPendingResult(PENDING_INTENT_TECH_DISCOVERED, new Intent(), 0);

            mnfcAdapter.enableForegroundDispatch(
                    this, pi,
                    new IntentFilter[]{new IntentFilter(NfcAdapter. ACTION_TECH_DISCOVERED)},
                    new String[][]{
                            new String[]{"android.nfc.tech.NdefFormatable"},
                            new String[]{"android.nfx.tech.Ndef"}

                    });

        }

    @Override
    public void onPause()
    {
        super.onPause();
        mnfcAdapter.disableForegroundDispatch(this);
    }
}
