package org.ieee.umh.ddays15;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class A_NuevaPersona extends Activity
{
    @Override
    protected void onCreate(Bundle a_savedInstanceState)
    {
        super.onCreate(a_savedInstanceState);
        setContentView(R.layout.a_nueva_persona);
    }

    public void Terminar(View a_view)
    {
        Persona t_nuevaPersona = new Persona();

        EditText t_campoNombre = (EditText) findViewById(R.id.campo_nombre);
        t_nuevaPersona.Nombre = t_campoNombre.getText().toString();

        CheckBox t_caja = (CheckBox) findViewById(R.id.caja_hombre);
        t_nuevaPersona.EsHombre = t_caja.isChecked();

        DatePicker t_seleccionFecha = (DatePicker) findViewById(R.id.selector_fecha);
        t_nuevaPersona.Dia = t_seleccionFecha.getDayOfMonth();
        t_nuevaPersona.Mes = t_seleccionFecha.getMonth();
        t_nuevaPersona.Anyo = t_seleccionFecha.getYear();

        Persona.ListaPersonas.add(t_nuevaPersona);

        Toast.makeText(this, "Añadida nueva persona: "+t_nuevaPersona.Nombre, Toast.LENGTH_SHORT).show();

        finish();
    }

}
