package com.example.geographyspinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner s1;
    TextView tv1;
    ImageView iv1;
    String data;
    String[] countryList = {"Choose country:", "Israel", "Afghanistan", "Japan", "Kazakhstan", "Iran", "China", "Italy"};
    String[] capitalList = {"Jerusalem", "Kabul", "Tokyo", "Astana", "Tehran", "Beijing", "Rome"};
    String[] flagsList = {"israel.png", "afgan.png", "japan.png", "kaz.png", "iran.png", "china.png", "italy.png"};
    int[] images = {R.drawable.israel, R.drawable.afgan, R.drawable.japan, R.drawable.kaz, R.drawable.iran, R.drawable.china, R.drawable.italy};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = findViewById(R.id.spnr);
        tv1 = findViewById(R.id.tvData);
        iv1 = findViewById(R.id.flagsView);

        s1.setOnItemSelectedListener(this);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,countryList);
        s1.setAdapter(adp);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if (position!=0)
        {
            iv1.setVisibility(View.VISIBLE);
            data = "Country:"+countryList[position]+"\nCapital city:"+capitalList[position - 1] ;
            tv1.setText(data);

            iv1.setImageResource(images[position - 1]);
        }
        else
        {
            tv1.setText("");
            iv1.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}