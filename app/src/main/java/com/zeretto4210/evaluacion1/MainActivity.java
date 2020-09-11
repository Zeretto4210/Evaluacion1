package com.zeretto4210.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int count;
    private int[] highvalue;
    private int[] minvalue;
    private int totalvalue;
    private int avgvalue;
    private TextView report;
    private TextView number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        highvalue = new int[] {0,0}; //[0] = folio, [1] = valor
        minvalue = new int[] {0,0};  //[0] = folio, [1] = valor
        totalvalue = 0;
        avgvalue = 0;
        report = (TextView) findViewById(R.id.l_report);
        number  = (TextView) findViewById(R.id.i_value);
    }
    public void press(View v){
        int value = Integer.parseInt(""+number.getText());
        number.setText("");

        count++;
        if(value>highvalue[1]){
            highvalue[0] = count;
            highvalue[1] = value;
        }
        if(value<minvalue[1]){
            minvalue[0] = count;
            minvalue[1] = value;
        }
        totalvalue += value;
        avgvalue = totalvalue/count;

        String text = " Boletas Ingresadas: "+count+"\n Boleta Mayor: Folio "+highvalue[0]+" - Valor $"+highvalue[1]+"\n Boleta Menor: Folio"+minvalue[0]+" - Valor $"+minvalue[1]+"\n Ingresos Totales: $"+totalvalue+"\n Promedio: $"+avgvalue+"\n Primer Folio: 1\n Ultimo Folio: "+count+"";

        report.setText(text);
    }
}