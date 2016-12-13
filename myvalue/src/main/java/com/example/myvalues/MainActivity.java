package com.example.myvalues;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

abstract class MyValues {
    public abstract int getResult();
}
class MyMinimum extends MyValues {
    MainActivity main = new MainActivity();
    int min = main.CurrentVal[0];

    @Override
    public int getResult() {
        min = main.CurrentVal[0];
        for(int i = 0; i < main.CurrentVal.length; i++) {
            if(min > main.CurrentVal[i]) {
                min = main.CurrentVal[i];
            }
        }
        return min;
    }
}
class MyAverage extends MyValues{

    MainActivity main1 = new MainActivity();
    int sum;
    int av;
    @Override
    public int getResult() {
        for(int i = 0 ; i < main1.CurrentVal.length; i++) {
           sum += main1.CurrentVal[i];
        }
        av = sum / 6;
        return av;
    }
}

public class MainActivity extends AppCompatActivity {
    public int[] CurrentVal = {1,5,9,3,22,12};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView currentvalue = (TextView)findViewById(R.id.currentval);
        final TextView result = (TextView)findViewById(R.id.result);
        Button minbtn = (Button)findViewById(R.id.getmin);
        Button avbtn = (Button)findViewById(R.id.getav);

        currentvalue.setText("1,5,9,3,22,12");

        minbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.isClickable()) {
                    MyMinimum mini = new MyMinimum();
                    result.setText(String.valueOf(mini.getResult()));
                }
            }
        });
        avbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.isClickable()) {
                    MyAverage aver = new MyAverage();
                    result.setText(String.valueOf(aver.getResult()));
                }
            }
        });

    }
}
