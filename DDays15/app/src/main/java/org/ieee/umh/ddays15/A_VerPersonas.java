package org.ieee.umh.ddays15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class A_VerPersonas extends Activity
{
    protected void onCreate(Bundle a_savedInstanceState)
    {
        super.onCreate(a_savedInstanceState);
        setContentView(R.layout.a_ver_personas);
        iniciaLista();
    }

    private void iniciaLista()
    {
        ListView t_lista = (ListView) findViewById(R.id.lista);
        t_lista.setAdapter(new ArrayAdapter<Persona>(this, R.layout.entrada_lista, R.id.texto_entrada, Persona.ListaPersonas)
        {
            public View getView(int a_position, View a_convertView, ViewGroup a_parent)
            {
                View t_entrada = View.inflate(getBaseContext(), R.layout.entrada_lista, null);
                TextView t_textoEntrada = (TextView) t_entrada.findViewById(R.id.texto_entrada);
                t_textoEntrada.setText(Persona.ListaPersonas.get(a_position).Nombre);

                TextView t_textoSexo = (TextView) t_entrada.findViewById(R.id.texto_sexo);
                t_textoSexo.setText(Persona.ListaPersonas.get(a_position).EsHombre ? "Hombre" : "Mujer");

                return t_entrada;
            }
        });

        t_lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent t_intent = new Intent(getBaseContext(), A_DetallesPersona.class);
                t_intent.putExtra("posicion", position);
                startActivityForResult(t_intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int a_requestCode, int a_resultCode, Intent a_data)
    {
        if (a_resultCode == RESULT_OK) iniciaLista();
    }
}
