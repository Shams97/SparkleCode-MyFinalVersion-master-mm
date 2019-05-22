package com.example.shms.trying;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shms.trying.R;
import com.example.shms.trying.q2;

public class hint2 extends AppCompatActivity {
Button first,second,third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint2);
        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        third=findViewById(R.id.third);

        findViewById(R.id.tryagain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(hint2.this, q2.class));
            }
        });
        first.setText("input(x)");
        second.setText("input(y)");
        third.setText("print('result=' ,x+y)");

    }
}
