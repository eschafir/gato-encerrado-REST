package com.example.esteban.gatoencerrado.gatoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.esteban.gatoencerrado.R;
import com.example.esteban.gatoencerrado.model.Laberinto;

/**
 * Created by Esteban on 18/6/2016.
 */
public class LaberintoListActivity extends AppCompatActivity implements LaberintoListFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laberinto_app_bar);

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // toolbar.setTitle(getTitle());

        TextView lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        lblTitulo.setText("Laberintos Disponibles");
        Button boton = (Button) findViewById(R.id.laberinto_inventario);
        boton.setText("Gestionar Inventario");
    }

    @Override
    public void onItemSelected(Laberinto laberinto) {
        // In single-pane mode, simply start the detail activity
        // for the selected item ID.
        Intent detailIntent = new Intent(this, LaberintoDetailActivity.class);
        Log.w("Lab", laberinto.getNombre());
        detailIntent.putExtra(LaberintoDetailFragment.ARG_ITEM_ID, laberinto);
        startActivity(detailIntent);
    }

    public void mostrarInventario(View view) {
        Toast.makeText(this, "Abrir inventario", Toast.LENGTH_SHORT).show();
        Intent listaItems = new Intent(this, InventarioListActivity.class);

        startActivity(listaItems);
    }
}
