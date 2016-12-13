package com.example.quickcoding161110;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> Arrayint = new ArrayList<Integer>();
    private ArrayList<String> Arraystring = new ArrayList<String>();
    int int1;
    EditText editText;
    String forint = "";
    String forStr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView intlist = (TextView)findViewById(R.id.Int);
        final TextView strlist = (TextView)findViewById(R.id.String);
        editText = (EditText) findViewById(R.id.editText);
        Button button1 = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.isClickable()) {
                    String text = editText.getText().toString();
                    try {
                        int1 = Integer.parseInt(text);
                        Arrayint.add(int1);
                    }catch (NumberFormatException x) {
                        Arraystring.add(text);
                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                if(v.isClickable()) {
                    for(int i = 0; i < Arrayint.size();i++) {
                        forint +=" " + String.valueOf(Arrayint.get(i));
                    }
                    for(int j = 0 ; j < Arraystring.size();j++) {
                        forStr += " " + Arraystring.get(j);
                    }
                    intlist.setText(forint);
                    strlist.setText(forStr);

                }
            }
        });

    }
}
