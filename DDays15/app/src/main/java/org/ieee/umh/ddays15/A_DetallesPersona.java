package org.ieee.umh.ddays15;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class A_DetallesPersona extends Activity
{
    int posicion;

    protected void onCreate(Bundle a_savedInstanceState)
    {
        super.onCreate(a_savedInstanceState);
        Intent t_intentoArranque = getIntent();
        posicion = t_intentoArranque.getIntExtra("posicion", -1);

        if (posicion < 0) Log.e("A_DetallesPersona", "Activity iniciada de forma errónea");

        setContentView(R.layout.a_detalles_persona);

        Persona t_elegido = Persona.ListaPersonas.get(posicion);
        if (getActionBar() != null) getActionBar().setTitle(t_elegido.Nombre);

        TextView t_sexoTextView = (TextView) findViewById(R.id.texto_sexo);
        t_sexoTextView.setText(t_elegido.EsHombre ? "Hombre" : "Mujer");
        t_sexoTextView.setTextColor(t_elegido.EsHombre ? Color.BLUE : Color.MAGENTA);

        TextView t_cumpleTextView = (TextView) findViewById(R.id.texto_cumple);
        t_cumpleTextView.setText("Nació el día " + t_elegido.Dia + " del mes " + t_elegido.Mes + " del año " + t_elegido.Anyo);
    }

    public void Eliminar(View a_view)
    {
        AlertDialog.Builder t_constructor = new AlertDialog.Builder(this);
        t_constructor.setTitle("Cuidado");
        t_constructor.setMessage("¿De verdad quieres eliminar a esta persona? :(");
        t_constructor.setNegativeButton("Mejor no", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });

        t_constructor.setPositiveButton("ELIMÍNALO", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Persona.ListaPersonas.remove(posicion);
                dialog.dismiss();
                Toast.makeText(getBaseContext(), "Has eliminado a una persona", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }
        });

        t_constructor.show();
    }
}
