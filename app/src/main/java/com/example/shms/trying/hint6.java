package com.example.shms.trying;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hint6 extends AppCompatActivity {
Button print1,print2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint6);
        print1=findViewById(R.id.blueYes);
        print2=findViewById(R.id.noo);
        findViewById(R.id.tryagain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(hint6.this, q6.class));
            }
        });

   print1.setText("print('yes')");
   print2.setText("print('no')");


    }

}
