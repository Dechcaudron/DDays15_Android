package org.ieee.umh.ddays15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;


public class A_Main extends Activity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        if(Persona.ListaPersonas==null)
            Persona.ListaPersonas = new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_a_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void AbrirNuevaPersona(View a_view)
    {
        Intent t_intent = new Intent(this, A_NuevaPersona.class);
        startActivity(t_intent);
    }

    public void AbrirVerPersonas(View a_view)
    {
        Intent t_intent = new Intent(this, A_VerPersonas.class);
        startActivity(t_intent);
    }
}
