package org.ucb.margt.diploucb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
Button btnSeleccioneUbicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

btnSeleccioneUbicacion = (Button) findViewById(R.id.btnSeleccioneUbicacion);

btnSeleccioneUbicacion.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(Principal.this, MapsActivity.class);
        startActivity(i);
    }
});


    }
}
