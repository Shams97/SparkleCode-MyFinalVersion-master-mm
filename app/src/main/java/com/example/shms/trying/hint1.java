package com.example.shms.trying;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shms.trying.R;
import com.example.shms.trying.q1;
import com.example.shms.trying.q4;

public class hint1 extends AppCompatActivity {
    Button tryagain,hello,world;
    private String TAG = q4.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hint1);
        hello=(Button)findViewById(R.id.hello);
        world=(Button)findViewById(R.id.world);

        hello.setText("print('hello')");
        world.setText("print('world')");
        findViewById(R.id.tryagain).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               startActivity(new Intent(hint1.this, q1.class));
            }
        });

    }

}
