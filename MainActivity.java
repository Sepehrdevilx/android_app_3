package com.example.timestable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ListView myListView;
    public void generateTimesTable (int timeTableNumber){
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for(int j = 1;j <= 100; j++){
            timesTableContent.add(Integer.toString(j*timeTableNumber));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTableContent);
        myListView.setAdapter(arrayAdapter);
    }
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar timesTableSeekBar = findViewById(R.id.timesTableSeekBar);
        myListView = findViewById(R.id.myListView);
        int max = 20;
        int startingPos = 10;
        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(startingPos);
        generateTimesTable(startingPos);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if (progress <min){
                    timesTableNumber = min;
                    timesTableSeekBar.setProgress(min);
                }
                else{
                    timesTableNumber= progress;
                }
                Log.i("seekbar Value", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





    }

}
