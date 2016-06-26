package com.example.esteban.gatoencerrado.gatoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.esteban.gatoencerrado.R;
import com.example.esteban.gatoencerrado.adapter.ItemAdapter;
import com.example.esteban.gatoencerrado.model.Item;
import com.example.esteban.gatoencerrado.service.LaberintoService;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Esteban on 25/6/2016.
 */
public class InventarioListActivity extends AppCompatActivity {

    private ListView list;
    private LaberintoService laberintoService;
    private List<Item> itemsH = new ArrayList<Item>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invetario_layout);

        TextView lblTitulo = (TextView) findViewById(R.id.lblTituloInventario);
        lblTitulo.setText("Inventario");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LaberintoListFragment.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        laberintoService = retrofit.create(LaberintoService.class);
        Call<List<Item>> inventarioCall = laberintoService.getInventario();

        /**
         * INVENTARIO HARDCODEADO
         */
        itemsH.add(new Item("Pala"));
        itemsH.add(new Item("Mochila"));
        itemsH.add(new Item("Llaves"));
        list = (ListView) findViewById(R.id.listview);
        ListAdapter adaptador = new ItemAdapter(this, itemsH);
        list.setAdapter(adaptador);

    }
}
