package com.example.shms.trying;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class end_level2 extends AppCompatActivity {
Button bttn;
    TextView scoreNum;
    int  scoreCount;
    public static boolean clickable=false;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_level2);
        bttn=(Button)findViewById(R.id.check2);
        scoreNum=(TextView)findViewById(R.id.cscoreNum);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(end_level2.this, q8_1.class));
            }
        });

        scoreCount =q1.count+q2.count+q3.count+q4.count+q5.count+q6.count+q7_1.count;
        scoreNum.setText(String.valueOf(scoreCount));
        checkScore();
        clickable=true;
    }

    public void checkScore() {
        FirebaseUser user = auth.getCurrentUser();
        String userId = user.getUid();
        String score = String.valueOf(scoreCount);
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("newKey", score);

        if (user != null) {
            db.collection("score").document(userId).set(hashMap);
        }
    }
}
