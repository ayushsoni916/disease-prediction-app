package com.contest.diseasepredictorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class second extends AppCompatActivity {
    EditText name;
    EditText age;
    //    RadioButton male;
//    RadioButton female;
    RadioGroup rg;
    ImageView img;
    String n,a,g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (Build.VERSION.SDK_INT>=21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            name = findViewById(R.id.editTextTextPersonName5);
            age = findViewById(R.id.editTextTextPersonName6);
//            male =findViewById(R.id.radioButton);
//            female =findViewById(R.id.radioButton2);
            rg=findViewById(R.id.radioGroup);
            img = findViewById(R.id.imageView5);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    n = name.getText().toString();
                    a = age.getText().toString();
                    int id=rg.getCheckedRadioButtonId();
                    switch(id)
                    {
                        case (int)R.id.radioButton:
                            g = "Mr.";
                            break;
                        case (int)R.id.radioButton2:
                            g = "Ms.";
                            break;
                    }
                    Intent symp = new Intent(second.this,symptomes.class);
                    symp.putExtra("name",n);
                    symp.putExtra("gender",g);
                    startActivity(symp);
                }
            });


        }
    }
}