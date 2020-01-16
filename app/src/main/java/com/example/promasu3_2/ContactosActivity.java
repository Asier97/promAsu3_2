package com.example.promasu3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ContactosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Contacto[] contactos = new Contacto[] {
            new Contacto(1,"Juan","juan@gmail.com"),
            new Contacto(2,"Asier","asier@gmail.com"),
            new Contacto(3,"Perez","perez@gmail.com"),
            new Contacto(4,"Jorge","jorge@gmail.com"),
            new Contacto(5,"Andres","andres@gmail.com")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        SQLiteControlador sql = new SQLiteControlador(this,"ejer1");

        sql.anadirContactos(contactos);

        Contacto[] contactos = sql.getContactos();
//        for (int x=0;x<contactos.length;x++) {
//            Log.i("AA",contactos[x].getEmail());
//        }

        AdaptadorContactos adaptadorWeb = new AdaptadorContactos(this, contactos);
        ListView lv = findViewById(R.id.lvContactos);
        lv.setAdapter(adaptadorWeb);

        lv.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int index, long arg3) {
//        AdaptadorWeb adaptadorWeb = new AdaptadorWeb(this, datosWeb);
//        Web web = adaptadorWeb.getItem(index);
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www."+web.getEnlace()));
//        startActivity(browserIntent);
    }
}
