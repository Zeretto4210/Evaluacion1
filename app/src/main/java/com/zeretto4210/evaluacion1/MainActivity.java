package com.zeretto4210.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int count;
    private int starter;
    private int[] highvalue;
    private int[] minvalue;
    private int totalvalue;
    private int avgvalue;
    private TextView report;
    private TextView number;
    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        starter = 100; // folio de inicio (?)
        count = 0;
        highvalue = new int[] {0,0}; //[0] = folio, [1] = valor
        minvalue = new int[] {0,2147483640};  //[0] = folio, [1] = valor
        totalvalue = 0;
        avgvalue = 0;
        report = (TextView) findViewById(R.id.l_report);
        number  = (TextView) findViewById(R.id.i_value);
        text = "";
    }
    public void press(View v){
        int value = Integer.parseInt(""+number.getText());
        number.setText("");
        if(value >=190){
            count++;
            if(value>highvalue[1]){
                highvalue[0] = count+starter;
                highvalue[1] = value;
            }
            if(value<minvalue[1]){
                minvalue[0] = count+starter;
                minvalue[1] = value;
            }
            totalvalue += value;
            avgvalue = totalvalue/count;

            text = " Boletas Ingresadas: "+count+"\n Boleta Mayor: Folio "+highvalue[0]+" - Valor $"+highvalue[1]+"\n Boleta Menor: Folio "+minvalue[0]+" - Valor $"+minvalue[1]+"\n Ingresos Totales: $"+totalvalue+"\n Promedio: $"+avgvalue+"\n Primer Folio: "+starter+"\n Ultimo Folio: "+(count+starter)+"";
        }
        report.setText(text);
    }
}