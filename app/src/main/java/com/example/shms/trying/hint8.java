package com.example.shms.trying;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hint8 extends AppCompatActivity {
Button list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint8);

        list =findViewById(R.id.blueYes);

        findViewById(R.id.tryagain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(hint8.this, q8_1.class));
            }
        });
        list.setText("my_list=[12,\"Hello\",3.4]");
    }

}
