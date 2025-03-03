package com.example.androidwidgets;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AndroidWidgets extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.androidwidgets);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final EditText editText = findViewById(R.id.editText);
        final Switch mySwitch = findViewById(R.id.switchbtn);
        final TextView txtValue = findViewById(R.id.txtValue);
        final CheckBox checkTrans = findViewById(R.id.checkBox1);
        final CheckBox checkTint = findViewById(R.id.checkBox2);
        final CheckBox checkreSize = findViewById(R.id.checkBox3);
        final ImageView imageView = findViewById(R.id.imageView);
        final TextClock tClock = findViewById(R.id.tClock);
        final WebView web = findViewById(R.id.web);
        final Button captureBtn = findViewById(R.id.Capture);
        web.loadUrl("https://gamecodeschool.com");



        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId){
                        RadioButton rb = group.findViewById(checkedId);

                        switch (rb.getId()){
                            case R.id.radioButton1:
                                tClock.setTimeZone("Europe/London");
                                break;
                            case R.id.radioButton2:
                                tClock.setTimeZone("Etc/GMT-8");
                                break;
                            case R.id.radioButton3:
                                tClock.setTimeZone("America/New_York");

                                break;
                        }

                    }
                }
        );
        mySwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                        if(isChecked){
                            txtValue.setVisibility(View.INVISIBLE);
                        }else{
                            txtValue.setVisibility(View.VISIBLE);
                        }
                    }

                }
        );
        checkTrans.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(checkTrans.isChecked()){
                            imageView.setAlpha(.1f);

                        }else{
                            imageView.setAlpha(1f);
                        }

                    }
                }
        );
        checkTint.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(checkTint.isChecked()){
                            imageView.setColorFilter(Color.argb(150, 255, 0, 0));
                        }else{
                            imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                        }
                    }
                }
        );
        checkreSize.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(checkreSize.isChecked()){
                            imageView.setScaleX(2);
                            imageView.setScaleY(2);
                        }else{
                            imageView.setScaleX(1);
                            imageView.setScaleX(1);
                        }

                    }
                }
        );

        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtValue.setText(editText.getText());
            }
        });


    }
}