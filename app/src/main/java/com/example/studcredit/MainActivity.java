package com.example.studcredit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float credit = 14000;
    float balance = 1000;
    float scholarship = 2500;
    float percent = 5;
    float[] paylogs = new float[120];
    int count=0;
    String out = "";

    private void calc_paylogs(){
        if (credit>balance){
            balance += (balance*percent)/1200+scholarship;
            count+=1;
            float up=balance-paylogs[count-1];
            paylogs[count]=up;
            out+=(Float.toString(up)+" - ");
            calc_paylogs();
        }
    }

    private TextView countOut;
    private TextView logsOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paylogs[0]=balance;

        countOut=findViewById(R.id.countOut);
        logsOut=findViewById(R.id.logsOut);
        calc_paylogs();

        countOut.setText("Количество месяцев до выплаты: "+count);
        logsOut.setText(out);
    }
}