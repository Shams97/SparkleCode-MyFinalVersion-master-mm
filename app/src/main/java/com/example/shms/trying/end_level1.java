package com.example.shms.trying;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class end_level1 extends AppCompatActivity {
  Button bttn;
    TextView scoreNum;
    int  scoreCount;
    public static boolean clickable=false;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_level1);
        FirebaseApp.initializeApp(this);
//        db = FirebaseFirestore.getInstance();

        bttn=(Button)findViewById(R.id.GoToTheNext);
        scoreNum=(TextView)findViewById(R.id.cscoreNum);

          bttn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(end_level1.this,q5.class));

        }
    });

        scoreCount =q1.count+q2.count+q3.count+q4.count;
        scoreNum.setText(String.valueOf(scoreCount));
checkScore();
        clickable=true;
    }

            public void checkScore()
            {
                FirebaseUser user = auth.getCurrentUser();
                String userId=user.getUid();
                String score =String.valueOf(scoreCount);
                Map<String, Object> hashMap = new HashMap<>();
                hashMap.put("newKey",score);

                if(user!=null)
                {
                db.collection("score").document(userId).set(hashMap);
                }

            }
}
