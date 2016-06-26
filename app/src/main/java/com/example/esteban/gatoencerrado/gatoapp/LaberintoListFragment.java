package com.example.esteban.gatoencerrado.gatoapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.esteban.gatoencerrado.adapter.LaberintoAdapter;
import com.example.esteban.gatoencerrado.model.Laberinto;
import com.example.esteban.gatoencerrado.service.LaberintoService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Esteban on 18/6/2016.
 */
public class LaberintoListFragment extends ListFragment implements View.OnClickListener {


    private Callbacks mCallbacks = sDummyCallbacks;

    private LaberintoService laberintoService;

    @Override
    public void onClick(View v) {

    }

    public interface Callbacks {
        void onItemSelected(Laberinto laberinto);
    }


    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(Laberinto laberinto) {
        }
    };

    public LaberintoListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String BASE_URL = "http://192.168.1.40:9000/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        laberintoService = retrofit.create(LaberintoService.class);

        Call<List<Laberinto>> laberintoCall = laberintoService.getLaberintos();

        laberintoCall.enqueue(new Callback<List<Laberinto>>() {
            @Override
            public void onResponse(Response<List<Laberinto>> response, Retrofit retrofit) {
                List<Laberinto> laberintos = response.body();

                setListAdapter(new LaberintoAdapter(
                        getActivity(),
                        laberintos));
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                Log.e("LaberitoList", t.getMessage());
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {
        super.onListItemClick(listView, v, position, id);
        Laberinto laberinto = (Laberinto) listView.getAdapter().getItem(position);
        mCallbacks.onItemSelected(laberinto);
    }


}


