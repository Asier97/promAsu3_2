package com.example.promasu3_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class AdaptadorContactos extends ArrayAdapter<Contacto> {

    private Contacto[] datosContacto;
    public AdaptadorContactos(@NonNull Context context, Contacto[] datos) {
        super(context, R.layout.adaptador_contactos, datos);
        this.datosContacto = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.adaptador_contactos, null);

        String nombre = datosContacto[position].getNombre();
        String email = datosContacto[position].getEmail();

        TextView tvNombre = item.findViewById(R.id.e1TvNombre);
        tvNombre.setText(nombre);

        TextView tvEmail = item.findViewById(R.id.e1TvEmail);
        tvEmail.setText(email);

        return (item);
    }
}