package com.example.promasu3_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class AdaptadorBiblioteca extends ArrayAdapter<Libro> {

    private Libro[] datosLibro;
    public AdaptadorBiblioteca(@NonNull Context context, Libro[] datos) {
        super(context, R.layout.adaptador_biblioteca, datos);
        this.datosLibro = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.adaptador_biblioteca, null);

        int isbn = datosLibro[position].getIsbn();
        String nombre = datosLibro[position].getNombre();
        String autor = datosLibro[position].getAutor();
        String genero = datosLibro[position].getGenero();

        TextView tvNombre = item.findViewById(R.id.nombreLibro);
        tvNombre.setText(nombre);

        TextView tvIsbn = item.findViewById(R.id.isbnLibro);
        tvIsbn.setText("ISBN: "+isbn);

        TextView tvAutor = item.findViewById(R.id.autorLibro);
        tvAutor.setText("Autor: "+autor);

        TextView tvGenero = item.findViewById(R.id.generoLibro);
        tvGenero.setText("Genero: "+genero);

        return (item);
    }
}