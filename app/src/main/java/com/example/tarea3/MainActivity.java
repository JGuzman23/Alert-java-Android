package com.example.tarea3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    RelativeLayout rly;
    SwipeListener swipe;
    CheckBox chb1,chb2,chb3,chb4;
     View vista ;

     Button info, edit_Inf;
    String Nombre = "Juan Guzman";
    String Instituto ="ITLA";
    String Materia="DESSARROLLO MOVIL";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rly = findViewById(R.id.Rl);
        swipe = new SwipeListener(rly);

        chb1 = findViewById(R.id.cb1);
        chb2 = findViewById(R.id.cb2);
        chb3 = findViewById(R.id.cb3);
        chb4 = findViewById(R.id.cb4);
        info = findViewById(R.id.info);
        edit_Inf = findViewById(R.id.edit);



    }



    public void aceptar(View view) {

        if(chb1.isChecked() && !chb2.isChecked() && !chb3.isChecked() && !chb4.isChecked() )  {

            LayoutInflater imagenGato = LayoutInflater.from(MainActivity.this);
            vista= imagenGato.inflate(R.layout.gato,null);
            Alert(view);

        }
        if(chb2.isChecked() && !chb1.isChecked() && !chb3.isChecked() && !chb4.isChecked() ){

            LayoutInflater imagenPerro = LayoutInflater.from(MainActivity.this);
            vista= imagenPerro.inflate(R.layout.perro,null);
            Alert(view);
        }
        if(chb3.isChecked() && !chb2.isChecked() && !chb1.isChecked() && !chb4.isChecked() ){

            LayoutInflater imagenConejo = LayoutInflater.from(MainActivity.this);
            vista= imagenConejo.inflate(R.layout.conejo,null);
            Alert(view);
        }
        if(chb4.isChecked() && !chb2.isChecked() && !chb3.isChecked() && !chb1.isChecked() ){

            LayoutInflater imagenLoro = LayoutInflater.from(MainActivity.this);
            vista= imagenLoro.inflate(R.layout.loro,null);
            Alert(view);

        }

        if(chb1.isChecked() && chb2.isChecked() && !chb3.isChecked() && !chb4.isChecked() )  {

            LayoutInflater gatoPerro = LayoutInflater.from(MainActivity.this);
            vista= gatoPerro.inflate(R.layout.gato_perro,null);
            Alert(view);

        }
        if(!chb2.isChecked() && chb1.isChecked() && chb3.isChecked() && !chb4.isChecked() ){

            LayoutInflater GatoConejo = LayoutInflater.from(MainActivity.this);
            vista= GatoConejo.inflate(R.layout.gato_conejo,null);
            Alert(view);
        }
        if(!chb3.isChecked() && !chb2.isChecked() && chb1.isChecked() && chb4.isChecked() ){

            LayoutInflater GatoLoro = LayoutInflater.from(MainActivity.this);
            vista= GatoLoro.inflate(R.layout.gato_loro,null);
            Alert(view);
        }
        if(!chb4.isChecked() && chb2.isChecked() && chb3.isChecked() && !chb1.isChecked() ){

            LayoutInflater PerroCOnejo = LayoutInflater.from(MainActivity.this);
            vista= PerroCOnejo.inflate(R.layout.perro_conejo,null);
            Alert(view);

        }
        if(!chb1.isChecked() && chb2.isChecked() && !chb3.isChecked() && chb4.isChecked() )  {

            LayoutInflater PerroLoro = LayoutInflater.from(MainActivity.this);
            vista= PerroLoro.inflate(R.layout.perro_loro,null);
            Alert(view);

        }
        if(!chb2.isChecked() && !chb1.isChecked() && chb3.isChecked() && chb4.isChecked() ){

            LayoutInflater conejoLoro = LayoutInflater.from(MainActivity.this);
            vista= conejoLoro.inflate(R.layout.conejo_loro,null);
            Alert(view);
        }
        if(chb3.isChecked() && chb2.isChecked() && chb1.isChecked() && chb4.isChecked() ){

            LayoutInflater Todos = LayoutInflater.from(MainActivity.this);
            vista= Todos.inflate(R.layout.todos,null);
            Alert(view);
        }











        if(!chb4.isChecked() && chb2.isChecked() && chb3.isChecked() && chb1.isChecked() ){

            LayoutInflater GaPerCo = LayoutInflater.from(MainActivity.this);
            vista= GaPerCo.inflate(R.layout.perro_gato_conejo,null);
            Alert(view);

        }
        if(chb1.isChecked() && chb2.isChecked() && !chb3.isChecked() && chb4.isChecked() )  {

            LayoutInflater GaPeLo = LayoutInflater.from(MainActivity.this);
            vista= GaPeLo.inflate(R.layout.gato_perro_loro,null);
            Alert(view);

        }
        if(!chb2.isChecked() && chb1.isChecked() && chb3.isChecked() && chb4.isChecked() ){

            LayoutInflater GaCoLo = LayoutInflater.from(MainActivity.this);
            vista= GaCoLo.inflate(R.layout.gato_conejo_loro,null);
            Alert(view);
        }
        if(chb3.isChecked() && chb2.isChecked() && !chb1.isChecked() && chb4.isChecked() ){

            LayoutInflater PeCoLo= LayoutInflater.from(MainActivity.this);
            vista= PeCoLo.inflate(R.layout.perro_conejo_loro,null);
            Alert(view);
        }








    }

    public void info(View view) {

        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View vista = layoutInflater.inflate(R.layout.info,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Informacion");
        builder.setMessage(Nombre+"\n"+Materia+"\n"+Instituto);
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        dialog.setView(vista);
        dialog.show();

    }

    public void edit(View view) {

        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"Editar info");
    }

    @Override
    public void applyTexts(String nombre, String instituto, String materia) {

      Nombre=nombre;
      Materia = materia;
      Instituto = instituto;
    }

    public void Alert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Animals");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              }
        });

        AlertDialog dialog = builder.create();
        dialog.setView(vista);
        dialog.show();
    }

    public void Alert_Info(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Informacion");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // The user clicked OK


            }
        });


// Create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.setView(vista);
        dialog.show();

    }


    private class SwipeListener implements View.OnTouchListener {

        GestureDetector gestureDetector;

        SwipeListener(View view){
            int threshold =100;
            int velocity_threshold = 100;

            GestureDetector.SimpleOnGestureListener listener =
                    new GestureDetector.SimpleOnGestureListener(){
                        @Override
                        public boolean onDown(MotionEvent e){
                            return true;
                        }
                        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
                            float xDiff = e2.getX() - e1.getX();
                            float yDiff = e2.getY() - e1.getY();
                            try{
                                if(Math.abs(xDiff) > Math.abs(yDiff)){
                                    if(Math.abs(xDiff)> threshold && Math.abs(velocityX) > velocity_threshold){

                                        if(xDiff > 0){
                                            System.exit(1);
                                        }else{
                                            System.exit(1);
                                        }
                                        return true;
                                    }
                                }else{
                                    if(Math.abs(yDiff) > threshold && Math.abs(velocityY) > velocity_threshold ){
                                        if(yDiff > 0 ){

                                        }else{

                                        }
                                        return  true;
                                    }
                                }

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            return  false;

                        }
                    };
            gestureDetector = new GestureDetector(listener);

            view.setOnTouchListener(this);

        }
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }





}