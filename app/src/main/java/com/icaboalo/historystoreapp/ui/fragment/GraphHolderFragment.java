package com.icaboalo.historystoreapp.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.icaboalo.historystoreapp.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/15/2015.
 */
public class GraphHolderFragment extends Fragment{

    @Bind(R.id.pie_chart)
    PieChart mPieChart;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_graph_holder, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        setUpPieChart();
    }

    private void setUpPieChart() {
        /*definimos algunos atributos*/
        mPieChart.setHoleRadius(40f);
        mPieChart.setRotationEnabled(true);
        mPieChart.animateXY(1500, 1500);

		/*creamos una lista para los valores Y*/
        ArrayList<Entry> valsY = new ArrayList<Entry>();
        valsY.add(new Entry(5 * 100 / 25, 0));
        valsY.add(new Entry(20 * 100 / 25, 1));

 		/*creamos una lista para los valores X*/
        ArrayList<String> valsX = new ArrayList<String>();
        valsX.add("Varones");
        valsX.add("Mujeres");

 		/*creamos una lista de colores*/
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.red_flat));
        colors.add(getResources().getColor(R.color.green_flat));

 		/*seteamos los valores de Y y los colores*/
        PieDataSet set1 = new PieDataSet(valsY, "Resultados");
        set1.setSliceSpace(3f);
        set1.setColors(colors);

		/*seteamos los valores de X*/
        PieData data = new PieData(valsX, set1);
        mPieChart.setData(data);
        mPieChart.highlightValues(null);
        mPieChart.invalidate();
    }
}
