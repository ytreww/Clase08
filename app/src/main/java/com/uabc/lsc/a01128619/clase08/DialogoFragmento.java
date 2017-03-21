package com.uabc.lsc.a01128619.clase08;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by comp03A on 3/21/17.
 */

public class DialogoFragmento extends DialogFragment{

    InicioSesion interfaceInicioSesion;
    private EditText usuario;
    private EditText passw;

    public interface InicioSesion {

        public void onDialogPositiveClick(String user, String password);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflador = getActivity().getLayoutInflater();
       

        builder.setMessage(R.string.mensaje).setTitle(R.string.titulo).setView(inflador.inflate(R.layout.layout_dialog,null))
        .setPositiveButton("Entrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    interfaceInicioSesion.onDialogPositiveClick(DialogoFragmento.this);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                interfaceInicioSesion.onDialogNegativeClick(DialogoFragmento.this);
            }
        });

        b

        return builder.create();
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {

            interfaceInicioSesion = (InicioSesion) context;
        } catch (ClassCastException e) {

            throw new ClassCastException(context.toString()
                    + " debe implementar InicioSesion");
        }
    }

}
