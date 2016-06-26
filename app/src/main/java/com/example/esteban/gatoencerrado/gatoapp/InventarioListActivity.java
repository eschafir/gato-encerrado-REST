package com.example.esteban.gatoencerrado.gatoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.esteban.gatoencerrado.R;
import com.example.esteban.gatoencerrado.adapter.ItemAdapter;

/**
 * Created by Esteban on 25/6/2016.
 */
public class InventarioListActivity extends AppCompatActivity {

    private ListView list;
    private String[] items = {"Ubuntu", "Android", "iOS", "Windows", "Mac OSX",
            "Google Chrome OS", "Debian", "Mandriva", "Solaris", "Unix"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invetario_layout);

        TextView titulo = (TextView) findViewById(R.id.tituloInventario);
        titulo.setText("Inventario");


        list = (ListView) findViewById(R.id.listview);
//        ListAdapter adaptador = new ItemAdapter(this, RepoLaberintos.getInstance().getListaItems(null, 10));
//        list.setAdapter(adaptador);
    }
}
