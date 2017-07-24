package com.example.luana.webservice;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by luana on 23/07/2017.
 */

class TwitterTask extends AsyncTask<String, Void, String[]> {

    @Override
    protected void doInBackground(Void... params) {
        try{
            String filtro = params[0];

            if(TextUtils.isEmpty(filtro)){
                return null;
            }
        String urlTwitter = "http://fipeapi.appspot.com/api/1/motos/marcas.json";
        String url = Uri.parse(urlTwitter + filtro).toString();
        String conteudo = HTTPUtils.acessar(url);

        JSONObject jsonObject = new JSONObject(conteudo);
        JSONArray resultados = jsonObjetct.get.JSONArray("results");

        String[] tweets = new String[resultados.length()];

        for(int i=0; i< resultados.length(); i++){
            JSONObject tweet = resultados.getJSONObject(i);
            String texto = tweet.getString("text");
            String usuario = tweet.getString("from_user");
            tweets[i]= usuario + "_ " + texto;
        }

        return tweets;
    }catch (Exception e){
            throw new RunTimeException(e);
        }
    }

    @Override
    protected void onPreExecute () {
        dialog = new ProgressDialog(TwitterSearchActivity.this);
        dialog.show();

    }

    @Override
    protected void onProgressUpdate() {

    }

    @Override
    protected void onPostExecute(String[] result) {
        if (result != null){
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(getBaseContext(),
                            android.R.layout.simple_list_item_1, result);
            lista.setAdapter(adapter);
        }
        dialog.dismiss();
    }
}
