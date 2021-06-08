package com.example.mydiary;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Fragment3 extends Fragment {
    private  static final String TAG = "Fragment2";

    Context context;
    PieChart chart;
    BarChart chart2;
    LineChart chart3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

        initUI(rootView);



        return rootView;
    }

    public void initUI(ViewGroup rootView){
        chart = rootView.findViewById(R.id.chart1);
        chart.setUsePercentValues(true);
        chart.getDescription().setEnabled(false);

        chart.setCenterText("기분별 비율");
        chart.setTransparentCircleColor(Color.WHITE);
        chart.setTransparentCircleAlpha(110);
        chart.setHoleRadius(58f);
        chart.setTransparentCircleRadius(61f);
        chart.setDrawCenterText(true);
        chart.setHighlightPerTapEnabled(true);

        Legend legent1 = chart.getLegend();
        legent1.setEnabled(false);

        chart.setEntryLabelColor(Color.WHITE);
        chart.setEntryLabelTextSize(10f);

        setData1();

        chart2 = rootView.findViewById(R.id.chart2);
        chart2.setDrawValueAboveBar(true);
        chart2.getDescription().setEnabled(false);
        chart2.setDrawGridBackground(false);

        XAxis xAxis = chart2.getXAxis();
        xAxis.setEnabled(false);

        YAxis leftAxis = chart2.getAxisLeft();
        leftAxis.setLabelCount(6, false);
        leftAxis.setAxisMinimum(0.0f);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setGranularity(1f);

        YAxis rightAxis = chart2.getAxisRight();
        rightAxis.setEnabled(false);

        Legend legend2 = chart2.getLegend();
        legend2.setEnabled(false);

        chart2.animateXY(1500, 1500);


        chart3 = rootView.findViewById(R.id.chart3);

        chart3.getDescription().setEnabled(false);
        chart3.setDrawGridBackground(false);
        chart3.setBackgroundColor(Color.WHITE);
        chart3.setViewPortOffsets(0, 0, 0, 0);

        Legend legend3 = chart3.getLegend();
        legend3.setEnabled(false);

        XAxis xAxis3 = chart3.getXAxis();
        xAxis3.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis3.setTextSize(10f);
        xAxis3.setTextColor(Color.WHITE);
        xAxis3.setDrawAxisLine(false);
        xAxis3.setDrawGridLines(true);
        xAxis3.setTextColor(Color.rgb(255, 192, 56));
        xAxis3.setCenterAxisLabels(true);
        xAxis3.setGranularity(1f);
        xAxis3.setValueFormatter(new ValueFormatter() {
            private final SimpleDateFormat mFormat = new SimpleDateFormat("MM-dd", Locale.KOREA);

            @Override
            public String getFormattedValue(float value) {
                Date date = new Date();
                long millis = date.getTime() + TimeUnit.HOURS.toMillis((long) value);
                return mFormat.format(new Date(millis));
            }
        });

        YAxis leftAxis3 = chart3.getAxisLeft();
        leftAxis3.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        leftAxis3.setTextColor(ColorTemplate.getHoloBlue());
        leftAxis3.setDrawGridLines(true);
        leftAxis3.setGranularityEnabled(true);
        leftAxis3.setAxisMinimum(0f);
        leftAxis3.setAxisMaximum(5f);
        leftAxis3.setYOffset(-9f);
        leftAxis3.setTextColor(Color.rgb(255, 192, 56));

        YAxis rightAxis3 = chart3.getAxisRight();
        rightAxis3.setEnabled(false);





    }

    private void setData1(){
        ArrayList<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(20,"" , getResources().getDrawable(R.drawable.smile1_24)));
        entries.add(new PieEntry(20,"" , getResources().getDrawable(R.drawable.smile2_24)));
        entries.add(new PieEntry(20,"" , getResources().getDrawable(R.drawable.smile3_24)));
        entries.add(new PieEntry(20,"" , getResources().getDrawable(R.drawable.smile4_24)));
        entries.add(new PieEntry(20,"" , getResources().getDrawable(R.drawable.smile5_24)));

        PieDataSet dataSet = new PieDataSet(entries, "기분별 비율");

        dataSet.setDrawIcons(true);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, -40));
        dataSet.setSelectionShift(5f);

        ArrayList<Integer> colors = new ArrayList<>();
        for (int c : ColorTemplate.JOYFUL_COLORS) {
            colors.add(c);
        }
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(22.0f);
        data.setValueTextColor(Color.WHITE);

        chart.setData(data);
        chart.invalidate();
    }

    private void setData2(){
        ArrayList<BarEntry> entries = new ArrayList<>();

    }


}
