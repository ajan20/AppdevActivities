package com.example.JavaMeetUi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidwidgets.R;

public class StackHeap extends AppCompatActivity  implements View.OnClickListener{
    private TextView MainText;
    private Button Addbtn, Takebtn, Growbtn, Shrinkbtn, Hidebtn, Resetbtn;
    private int value = 0;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stack_heap);
        MainText = findViewById(R.id.MainText);
        Addbtn = findViewById(R.id.Addbtn);
        Takebtn = findViewById(R.id.Takebtn);
        Growbtn = findViewById(R.id.Growbtn);
        Shrinkbtn = findViewById(R.id.Shrinkbtn);
        Hidebtn = findViewById(R.id.Hidebtn);
        Resetbtn = findViewById(R.id.Resetbtn);

        // Set OnClickListeners
        Addbtn.setOnClickListener(this);
        Takebtn.setOnClickListener(this);
        Growbtn.setOnClickListener(this);
        Shrinkbtn.setOnClickListener(this);
        Hidebtn.setOnClickListener(this);
        Resetbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float size;
        switch (v.getId()) {
            case R.id.Addbtn:
                value++;
                MainText.setText(String.valueOf(value));
                break;

            case R.id.Takebtn:
                value--;
                MainText.setText(String.valueOf(value));
                break;

            case R.id.Growbtn:
                size = MainText.getTextScaleX();
                MainText.setTextScaleX(size * 1.1f); // Smooth scaling
                break;

            case R.id.Shrinkbtn:
                size = MainText.getTextScaleX();
                MainText.setTextScaleX(size * 0.9f); // Smooth shrinking
                break;

            case R.id.Hidebtn:
                MainText.setVisibility(MainText.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                break;

            case R.id.Resetbtn:
                value = 0;
                MainText.setText(String.valueOf(value));
                MainText.setTextScaleX(1.0f); // Reset text size
                MainText.setVisibility(View.VISIBLE); // Reset visibility
                break;
        }

    }
}