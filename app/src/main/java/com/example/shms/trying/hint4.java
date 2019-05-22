package com.example.shms.trying;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shms.trying.R;
import com.example.shms.trying.q4;

public class hint4 extends AppCompatActivity {
    Button c,o,d,e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint4);
        c=findViewById(R.id.red_c);
        o=findViewById(R.id.blue_o);
        d=findViewById(R.id.green_d);
        e=findViewById(R.id.pink_e);

        findViewById(R.id.tryagain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(hint4.this, q4.class));
            }
        });
        c.setText("print(\'c\')");
        o.setText("print(\'o\')");
        d.setText("print(\'d\')");
        e.setText("print(\'e\')");
    }
}
