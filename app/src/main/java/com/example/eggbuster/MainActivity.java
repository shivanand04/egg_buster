package com.example.eggbuster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView timerDisplay;
    EditText input;
    ImageView img;

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        timerDisplay = findViewById(R.id.textView2);
        input = findViewById(R.id.time_edit);
        img = findViewById(R.id.image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(input.getText())){
                    Toast.makeText(MainActivity.this, "No Input", Toast.LENGTH_SHORT).show();
                    return;
                }

                int time = Integer.parseInt(input.getText().toString());

                img.setImageDrawable(getDrawable(R.drawable.complete_egg));


                timer = new CountDownTimer(time*1000 , 1000) {
                    @Override
                    public void onTick(long l) {

                        int timeInSec = (int) l/1000;

                        int min = timeInSec/60;
                        int sec = timeInSec%60;

                        String display = min+ " : "+sec;

                        timerDisplay.setText(display);

                    }

                    @Override
                    public void onFinish() {

                        img.setImageDrawable(getDrawable(R.drawable.cracked_egg));

                    }
                };
                timer.start();
                }




            });
        }
    }
