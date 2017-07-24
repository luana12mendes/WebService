package com.example.luana.webservice;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.net.URI;

public class Main4Activity extends AppCompatActivity {

    TextView webService;
    String uri = "Http://swapi.co/api/people/1/";
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = URI.create(uri).toString();
        String resultado= "";
        webService = (TextView) findViewById(R.id.Web);

        BuscaTask busca = new BuscaTask(url,null,resultado);
        busca.execute();

    }

    public class BuscaTask extends AsyncTask<String, Void, String>{

        ProgressDialog dialog;

        public BuscaTask(String url, Object o, String resultado) {
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(Main4Activity.this);
            dialog.show();
        }

        @Override
        protected void onPostExecute(String jsonObject) {

            if (jsonObject != null) {
                webService.setText(jsonObject);
            }

            dialog.dismiss();
        }

        @Override
        protected String doInBackground(String... params) {
            return HTTPUtils.acessar(url);
        }
    }
}
