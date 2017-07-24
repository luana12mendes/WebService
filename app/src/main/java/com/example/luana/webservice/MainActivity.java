package com.example.luana.webservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] items = {"Ir ao mercado", "Ir ao Dentista", "Pagar as Contas", "Ir ao shopping"};
        ListView listaSimples = (ListView) findViewById(R.id.listaSimplesId);
        ArrayAdapter<String> adapterSimples = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        listaSimples.setAdapter(adapterSimples);
    }
}
