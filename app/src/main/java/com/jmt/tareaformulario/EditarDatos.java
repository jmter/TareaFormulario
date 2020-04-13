package com.jmt.tareaformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditarDatos extends AppCompatActivity {
    private Button editar;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private EditText et1;
    private String name;
    private String email;
    private String phone;
    private String descr;
    private String fecha[] = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_datos);
        textos();
        agregarBoton1();


    }
    public void textos(){
        text1 = (TextView)findViewById(R.id.nombreComp);
        text2 = (TextView)findViewById(R.id.tele);
        text3 = (TextView)findViewById(R.id.emails);
        text4 = (TextView)findViewById(R.id.desc);
        text5 = (TextView)findViewById(R.id.fechaNac);
        et1 = (EditText)findViewById(R.id.nombre);

        Bundle datos = this.getIntent().getExtras();
        name  = datos.getString("name");
        phone = datos.getString("phone");
        email = datos.getString("email");
        descr = datos.getString("description");
        fecha[0] = String.valueOf(datos.getInt("dia"));
        fecha[1] = String.valueOf(datos.getInt("mes"));
        fecha[2] = String.valueOf(datos.getInt("year"));

        text1.setText(name);
        text2.setText("Tel: " + phone);
        text3.setText("Email: " + email);
        text4.setText("Descripcion: " + descr );
        text5.setText("Fecha de nacimiento: " + fecha[0]+"/"+fecha[1]+"/"+fecha[2]);
    }
    public void agregarBoton1(){
        editar = (Button) findViewById(R.id.edit);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editar = new Intent(getBaseContext(), MainActivity.class);
                editar.putExtra("nombre",name);
                editar.putExtra("tele",phone);
                editar.putExtra("emails",email);
                editar.putExtra("desc",descr);
                editar.putExtra("dia",fecha[0]);
                editar.putExtra("mes",fecha[1]);
                editar.putExtra("year",fecha[2]);
                startActivity(editar);

            }
        });
    }
}
