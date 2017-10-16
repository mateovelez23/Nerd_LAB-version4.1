package com.jhonlopera.nerd30;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class PerfilFragment extends Fragment {

    private String correoR,contraseñaR,nombreR, foto,log;
    int duration = Toast.LENGTH_SHORT;
    private TextView tvcorreo,tvnombre;
    private ImageView imagen_perfil;
    SharedPreferences preferencias;
    SharedPreferences.Editor editor_preferencias;
    int silog;


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }
}
