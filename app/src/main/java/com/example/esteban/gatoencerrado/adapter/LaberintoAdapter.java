package com.example.esteban.gatoencerrado.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.esteban.gatoencerrado.R;
import com.example.esteban.gatoencerrado.gatoapp.LaberintoListFragment;
import com.example.esteban.gatoencerrado.model.Laberinto;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Esteban on 19/6/2016.
 */
public class LaberintoAdapter extends ArrayAdapter<Laberinto> {
    public LaberintoAdapter(Context context, List<Laberinto> laberintos) {
        super(context, R.layout.laberinto_row, laberintos);

    }

    @Override
    public long getItemId(int position) {
        //return position;
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.laberinto_row, parent, false);
        final Laberinto laberinto = getItem(position);

        //String URL_PHOTOS = "http://192.168.1.40:9000/images/";
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgLab);
        Picasso.with(getContext())
                .load(LaberintoListFragment.getBaseUrl() + "images/" + laberinto.getPath())
                .into(imageView);

        TextView tvLaberinto = (TextView) rowView.findViewById(R.id.lblLaberinto);
        tvLaberinto.setText(laberinto.getNombre().toString());

        return rowView;
    }
}
