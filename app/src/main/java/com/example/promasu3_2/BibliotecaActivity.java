package com.example.promasu3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class BibliotecaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Libro[] libros = new Libro[] {
        new Libro(1,"Harry Potter","J.K. Rowling","Fantasia","Harry potter es un niño con poderes mágicos que blablabla"),
        new Libro(2,"El Hobbit","Alguien","Fantasia","Unos enanos tienen que reconquistar su montaña")
    };

    private ListView lv;
    private SQLiteControlador sql;
    private EditText eIsbn,eNombre,eAutor,eGenero,eDesc;
    private Button mod,del;

    private void actualizar() {
        libros = sql.getLibros();

        AdaptadorBiblioteca adaptadorBiblioteca = new AdaptadorBiblioteca(this, libros);
        lv.setAdapter(adaptadorBiblioteca);

        lv.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca);

        sql = new SQLiteControlador(this,"ejer2");
        eIsbn = findViewById(R.id.eIsbn);
        eNombre = findViewById(R.id.eNombre);
        eAutor = findViewById(R.id.eAutor);
        eGenero = findViewById(R.id.eGenero);
        eDesc = findViewById(R.id.eDescipcion);
        mod = findViewById(R.id.bModificar);
        del = findViewById(R.id.bBorrar);

        lv = findViewById(R.id.lvBiblioteca);

        sql.anadirLibros(libros);
        actualizar();

    }

    public void onItemClick(AdapterView<?> parent, View view, int index, long arg3) {
        AdaptadorBiblioteca adaptadorBiblioteca = new AdaptadorBiblioteca(this, libros);
        Libro libro = adaptadorBiblioteca.getItem(index);

        eIsbn.setText(Integer.toString(libro.getIsbn()));
        eNombre.setText(libro.getNombre());
        eAutor.setText(libro.getAutor());
        eGenero.setText(libro.getGenero());
        eDesc.setText(libro.getDescripcion());

        mod.setEnabled(true);
        del.setEnabled(true);
    }

    private Libro cogerLibro(boolean isbn) {
        Libro libro = new Libro();

        if (isbn) libro.setIsbn(Integer.parseInt(eIsbn.getText().toString()));
        else libro.setIsbn(0);
        libro.setNombre(eNombre.getText().toString());
        libro.setAutor(eAutor.getText().toString());
        libro.setGenero(eGenero.getText().toString());
        libro.setDescripcion(eDesc.getText().toString());

        return libro;
    }

    private void limpiar() {
        eIsbn.setText("");
        eNombre.setText("");
        eAutor.setText("");
        eGenero.setText("");
        eDesc.setText("");

        mod.setEnabled(false);
        del.setEnabled(false);
    }

    public void operar(View view) {
        switch (view.getId()) {
            case R.id.bAnadir:
                sql.addLibro(cogerLibro(false));
                break;
            case R.id.bModificar:
                sql.modLibro(cogerLibro(true));
                break;
            case R.id.bBorrar:
                sql.delLibro(cogerLibro(true));
                break;
        }
        actualizar();
        limpiar();
    }
}
