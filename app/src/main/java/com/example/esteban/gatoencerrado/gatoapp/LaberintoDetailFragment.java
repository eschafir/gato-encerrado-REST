package com.example.esteban.gatoencerrado.gatoapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.esteban.gatoencerrado.R;
import com.example.esteban.gatoencerrado.model.Laberinto;
import com.squareup.picasso.Picasso;

/**
 * Created by Esteban on 19/6/2016.
 */
public class LaberintoDetailFragment extends Fragment implements View.OnClickListener {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Laberinto laberinto;


    public LaberintoDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            laberinto = (Laberinto) getArguments().get(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            activity.setTitle(laberinto.getNombre());
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(laberinto.getNombre());
            } else {
                activity.setTitle(laberinto.getNombre());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_laberinto_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (laberinto != null) {

            ((TextView) rootView.findViewById(R.id.laberinto_descripcion)).setText(laberinto.getDescripcion());

            ImageView imageView = (ImageView) rootView.findViewById(R.id.imgLaberinto);
            Picasso.with(getContext())
                    .load(LaberintoListFragment.getBaseUrl() + "images/" + laberinto.getPath())
                    .resize(1000, 700)
                    .centerCrop()
                    .into(imageView);
        }

        return rootView;
    }


    @Override
    public void onClick(View v) {


    }
}
