package com.example.tarea3;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {

    EditText et_nombre;
    EditText et_instituto;
    EditText et_materia;




    String nombre;
    String instituto;
    String materia;

    private ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.edit_info,null);
        et_nombre = view.findViewById(R.id.et_nombre);



        builder.setView(view)
                .setTitle("Editar Info")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        nombre = et_nombre.getText().toString();
                        instituto = et_instituto.getText().toString();
                        materia = et_materia.getText().toString();



                        listener.applyTexts(nombre,instituto,materia);
                    }
                });



        et_nombre = view.findViewById(R.id.et_nombre);
        et_instituto = view.findViewById(R.id.et_institucion);
        et_materia= view.findViewById(R.id.et_materia);


       return builder.create();
    }

    @Override
    public void onAttach( Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString()+"implementacion");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String nombre,String instituto, String materia );

    }

}
