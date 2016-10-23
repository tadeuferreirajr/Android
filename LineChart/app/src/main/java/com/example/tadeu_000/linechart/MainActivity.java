package com.example.tadeu_000.linechart;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.IOException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static com.example.tadeu_000.linechart.R.id.button1;
import static com.example.tadeu_000.linechart.R.string.button2;

public class MainActivity extends AppCompatActivity {

    Button Indicadoresbutton;
    Button IndicadoresBrasilbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Indicadoresbutton = (Button)findViewById(R.id.button1);
        IndicadoresBrasilbutton = (Button)findViewById(R.id.button2);

        Indicadoresbutton.setOnClickListener(onClickListener);
        IndicadoresBrasilbutton.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch(v.getId()){
                case R.id.button1:
                    Intent indicadores = new Intent(getApplicationContext(),IndicadoresActivity.class);
                    startActivity(indicadores);
                    break;
                case R.id.button2:
                    Intent indicadoresbrasil = new Intent(getApplicationContext(),IndicadoresBrasilActivity.class);
                    startActivity(indicadoresbrasil);
                    break;
            }
        }
    };


}

