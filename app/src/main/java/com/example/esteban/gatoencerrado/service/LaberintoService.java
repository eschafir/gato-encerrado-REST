package com.example.esteban.gatoencerrado.service;

import com.example.esteban.gatoencerrado.model.Item;
import com.example.esteban.gatoencerrado.model.Laberinto;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Esteban on 18/6/2016.
 */
public interface LaberintoService {
    @GET("laberintos")
    Call<List<Laberinto>> getLaberintos();

    @GET("inventario")
    Call<List<Item>> getInventario();
}
