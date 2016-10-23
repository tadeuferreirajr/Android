package com.example.tadeu_000.linechart;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by tadeu_000 on 22/10/2016.
 */

public class IndicadoresBrasilActivity extends AppCompatActivity {

    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;

    Button PIBbutton;
    Button VarPIBbutton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indicadores_brasil);

        chart = (BarChart) findViewById(R.id.chart1);

        PIBbutton = (Button)findViewById(R.id.buttonPIB);
        VarPIBbutton = (Button)findViewById(R.id.buttonVarPIB);

        PIBbutton.setOnClickListener(onClickListener);
        VarPIBbutton.setOnClickListener(onClickListener);

    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch(v.getId()){
                case R.id.buttonPIB:
                    BARENTRY = new ArrayList<>();
                    BarEntryLabels = new ArrayList<String>();
                    AddValuesToBARENTRY("PIB");
                    AddValuesToBarEntryLabels("PIB");

                    Bardataset = new BarDataSet(BARENTRY, "Valores em trilhão");
                    BARDATA = new BarData(BarEntryLabels, Bardataset);

                    Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                    chart.setData(BARDATA);

                    chart.animateY(3000);

                    break;
                case R.id.buttonVarPIB:
                    BARENTRY = new ArrayList<>();
                    BarEntryLabels = new ArrayList<String>();
                    AddValuesToBARENTRY("VarPIB");
                    AddValuesToBarEntryLabels("VarPIB");

                    Bardataset = new BarDataSet(BARENTRY, "Crescimento do PIB em %");
                    BARDATA = new BarData(BarEntryLabels, Bardataset);

                    Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                    chart.setData(BARDATA);

                    chart.animateY(3000);
                    break;

            }
        }
    };

    public void AddValuesToBARENTRY(String s){

        if (s == "PIB") {
            BARENTRY.add(new BarEntry(705.6f, 0));
            BARENTRY.add(new BarEntry(857.9f, 1));
            BARENTRY.add(new BarEntry(955.5f, 2));
            BARENTRY.add(new BarEntry(1006f, 3));
            BARENTRY.add(new BarEntry(1092f, 4));
            BARENTRY.add(new BarEntry(1202f, 5));
            BARENTRY.add(new BarEntry(1316f, 6));
            BARENTRY.add(new BarEntry(1491f, 7));
            BARENTRY.add(new BarEntry(1720f, 8));
            BARENTRY.add(new BarEntry(1959f, 9));
            BARENTRY.add(new BarEntry(2172f, 10));
            BARENTRY.add(new BarEntry(2410f, 11));
            BARENTRY.add(new BarEntry(2718f, 12));
            BARENTRY.add(new BarEntry(3108f, 13));
            BARENTRY.add(new BarEntry(3328f, 14));
            BARENTRY.add(new BarEntry(3887f, 15));
            BARENTRY.add(new BarEntry(4375f, 16));
            BARENTRY.add(new BarEntry(4806f, 17));
            BARENTRY.add(new BarEntry(5316f, 18));
            BARENTRY.add(new BarEntry(5521f, 19));
            BARENTRY.add(new BarEntry(5904f, 20));
        }

        if (s == "VarPIB") {
            BARENTRY.add(new BarEntry(4.1f, 0));
            BARENTRY.add(new BarEntry(2.5f, 1));
            BARENTRY.add(new BarEntry(3.2f, 2));
            BARENTRY.add(new BarEntry(0.3f, 3));
            BARENTRY.add(new BarEntry(0.9f, 4));
            BARENTRY.add(new BarEntry(4.9f, 5));
            BARENTRY.add(new BarEntry(1.8f, 6));
            BARENTRY.add(new BarEntry(2.7f, 7));
            BARENTRY.add(new BarEntry(1.3f, 8));
            BARENTRY.add(new BarEntry(5.7f, 9));
            BARENTRY.add(new BarEntry(3.2f, 10));
            BARENTRY.add(new BarEntry(4f, 11));
            BARENTRY.add(new BarEntry(6f, 12));
            BARENTRY.add(new BarEntry(5f, 13));
            BARENTRY.add(new BarEntry(-0.2f, 14));
            BARENTRY.add(new BarEntry(7.6f, 15));
            BARENTRY.add(new BarEntry(3.9f, 16));
            BARENTRY.add(new BarEntry(1.8f, 17));
            BARENTRY.add(new BarEntry(2.7f, 18));
            BARENTRY.add(new BarEntry(0.1f, 19));
            BARENTRY.add(new BarEntry(-3.8f, 20));
        }
    }

    public void AddValuesToBarEntryLabels(String s){

        if(s == "PIB" || s == "VarPIB") {
            BarEntryLabels.add("1995");
            BarEntryLabels.add("1996");
            BarEntryLabels.add("1997");
            BarEntryLabels.add("1998");
            BarEntryLabels.add("1999");
            BarEntryLabels.add("2000");
            BarEntryLabels.add("2001");
            BarEntryLabels.add("2002");
            BarEntryLabels.add("2003");
            BarEntryLabels.add("2004");
            BarEntryLabels.add("2005");
            BarEntryLabels.add("2006");
            BarEntryLabels.add("2007");
            BarEntryLabels.add("2008");
            BarEntryLabels.add("2009");
            BarEntryLabels.add("2010");
            BarEntryLabels.add("2011");
            BarEntryLabels.add("2012");
            BarEntryLabels.add("2013");
            BarEntryLabels.add("2014");
            BarEntryLabels.add("2015");
        }

    }

}


