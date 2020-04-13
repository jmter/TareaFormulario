package com.jmt.tareaformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button guardar;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private DatePicker et5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarBoton1();
        textos();

    }
  //Creo metodo para agregar Boton
    public void agregarBoton1(){
        guardar = (Button)findViewById(R.id.guardarDatos);
        et1 = (EditText)findViewById(R.id.nombre);
        et2 = (EditText)findViewById(R.id.telefono);
        et3 = (EditText)findViewById(R.id.email);
        et4 = (EditText)findViewById(R.id.descripcion);
        et5 = (DatePicker)findViewById(R.id.fecha);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent guardar = new Intent(getBaseContext(), EditarDatos.class);
                guardar.putExtra("name",et1.getText().toString());
                guardar.putExtra("phone",et2.getText().toString());
                guardar.putExtra("email",et3.getText().toString());
                guardar.putExtra("description",et4.getText().toString());
                guardar.putExtra("dia",et5.getDayOfMonth());
                guardar.putExtra("mes",et5.getMonth());
                guardar.putExtra("year",et5.getYear());
                startActivity(guardar);
            }
        });
    }
    //Creo metodo para llenar los edit text
    public void textos(){
        if (getIntent().getExtras() != null){

            Bundle inten = getIntent().getExtras();
            et1.setText(inten.getString("nombre"));
            et2.setText(inten.getString("tele"));
            et3.setText(inten.getString("emails"));
            et4.setText(inten.getString("desc"));
            et5.updateDate(Integer.parseInt(inten.getString("year")),Integer.parseInt(inten.getString("mes")),Integer.parseInt(inten.getString("dia")));

        }
    }
}
