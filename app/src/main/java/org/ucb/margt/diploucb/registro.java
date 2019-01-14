package org.ucb.margt.diploucb;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class registro extends AppCompatActivity {

    Button btnGrabarUsu;
    EditText txtNomUsu,txtCiuUsu,txtCorUsu,txtPasUsu;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        btnGrabarUsu=(Button)findViewById(R.id.btnRegistrarUsu);
        txtNomUsu=(EditText)findViewById(R.id.txtNomUsu);
        txtCiuUsu=(EditText)findViewById(R.id.txtCiuUsu);
        txtCorUsu=(EditText)findViewById(R.id.txtCorUsu);
        txtPasUsu=(EditText)findViewById(R.id.txtPasUsu);

        btnGrabarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertarReg(String.valueOf(txtNomUsu.getText()),
                        String.valueOf(txtCiuUsu.getText()),
                        String.valueOf(txtCorUsu.getText()),
                        String.valueOf(txtPasUsu.getText()));

                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro Satisfactorio",
                        Toast.LENGTH_LONG).show();


                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });



    }




}
