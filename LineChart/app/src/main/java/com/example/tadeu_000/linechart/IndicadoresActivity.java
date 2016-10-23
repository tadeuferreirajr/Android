package com.example.tadeu_000.linechart;

import android.os.AsyncTask;
import android.widget.TextView;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by tadeu_000 on 22/10/2016.
 */

public class IndicadoresActivity extends AppCompatActivity {

    String webpage = null;

    String Bovespapp = null;
    String Bovespa = null;
    String Dolarpp = null;
    String Dolar = null;
    String SalarioMin = null;
    String CDI = null;
    String SELIC = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indicadores);

        try {
            webpage = new ParsePage().execute().get();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }

        String[] arr = webpage.split(" ");

        //for (String ss : arr){
        //    System.out.println(ss);
        //}

        int flagBovespa = 0;
        int flagDolar = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("Bovespa") == true) {
                if (flagBovespa == 0) {
                    Bovespapp = arr[i + 1];
                    Bovespa = arr[i + 2] + " " + arr[i + 3];
                    flagBovespa = 1;
                }
            }

            if (arr[i].equals("Dólar")) {
                if (flagDolar == 0) {
                    Dolarpp = arr[i + 2];
                    Dolar = arr[i + 3];
                    flagDolar = 1;
                }
            }

            if (arr[i].equals("Salário")) {
                SalarioMin = arr[i + 2] + " " + arr[i + 3];
            }


            if (arr[i].equals("CDI")) {
                CDI = arr[i + 1];
            }
            if (arr[i].equals("SELIC")) {
                SELIC = arr[i + 1];
            }

            //if (arr[i].equals("SELIC")) {
            //    System.out.println(arr[i]);
            //   System.out.println(arr[i + 1]);
            //   System.out.println(arr[i + 2]);
            //   System.out.println(arr[i + 3]);
            //}
        }

        TextView BovespappTextView = (TextView) findViewById(R.id.textViewBovespapp);
        TextView BovespaTextView = (TextView) findViewById(R.id.textViewBovespa);
        TextView DolarppTextView = (TextView) findViewById(R.id.textViewDolarpp);
        TextView SalarioMinTextView = (TextView) findViewById(R.id.textViewSalarioMin);
        TextView CDITextView = (TextView) findViewById(R.id.textViewCDI);
        TextView SELICTextView = (TextView) findViewById(R.id.textViewSELIC);

        BovespappTextView.setText(Bovespapp);
        BovespaTextView.setText(Bovespa);
        DolarppTextView.setText(Dolarpp);
        SalarioMinTextView.setText(SalarioMin);
        CDITextView.setText(CDI);
        SELICTextView.setText(SELIC);

    }// On Create
}// Class

    class ParsePage extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... arg0) {
            org.jsoup.nodes.Document doc;
            String resultado = "";
            try {
                doc = Jsoup.connect("http://economia.uol.com.br/cotacoes/indices-economicos/").get();
                resultado = doc.text();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return resultado;
        }
    }
