package org.ucb.margt.diploucb;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;
import androidx.versionedparcelable.NonParcelField;

public class MainActivity extends AppCompatActivity {

    TextView tvRgistrese;
     Button btnIngresar;
     SQLite_OpenHelper helper=new SQLite_OpenHelper(this,"BD1",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRgistrese=(TextView)findViewById(R.id.tvRegistrese );
        tvRgistrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),registro.class);
                startActivity(i);

            }
        });

btnIngresar=(Button) findViewById(R.id.btnIngresar);
btnIngresar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        EditText txtusu=(EditText)findViewById(R.id.txtUsuario);
        EditText txtpas=(EditText)findViewById(R.id.txtPassword);
        Cursor cursor=helper.ConsultarUsuPas(txtusu.getText().toString(),txtpas.getText().toString());

        if(cursor.getCount()>0){
            Intent i=new Intent(getApplicationContext(),Principal.class);

            startActivity(i);

        }
        else{
            Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_LONG).show();
            openDialog();
            }

            txtusu.setText("");
            txtpas.setText("");
            txtusu.findFocus();

    }
});
    }

    public void openDialog() {
        Dialog.dialogIngresar dialogIngresar = new Dialog.dialogIngresar();
        dialogIngresar.show(getSupportFragmentManager(), "Ingresar dialog");
    }
}