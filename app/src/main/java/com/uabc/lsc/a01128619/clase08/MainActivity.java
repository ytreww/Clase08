package com.uabc.lsc.a01128619.clase08;

import android.app.Application;
import android.app.DialogFragment;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogoFragmento.InicioSesion{

    private Button btn;
    private DialogFragment dialogFragment;
    private TextView mensaje;
    private EditText usuario;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        mensaje=(TextView)findViewById(R.id.textView);
        dialogFragment= new DialogoFragmento();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFragment.show(getFragmentManager(), "ALOH");

            }
        });
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View vistaDialogo = inflater.inflate(R.layout.layout_dialog, null);
        usuario =(EditText)vistaDialogo.findViewById(R.id.username);
        password=(EditText)vistaDialogo.findViewById(R.id.password);
        mensaje.setText("Usuario: "+ usuario.getText().toString() + " Password: "+password.getText().toString());
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}
