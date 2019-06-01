package com.example.shms.trying;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.example.shms.trying.hints.hint1;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class q1 extends AppCompatActivity {
    Button var1,var2,check;
    public static int count = 3;
     TextView points;
    private final    Map<String, Object> scores = new HashMap<>();
    private static final String LOGCAT = "DROP EVENT:";
    LinearLayout bigliner;
    private FirebaseFirestore db;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

        db = FirebaseFirestore.getInstance();


        //Initialization of all the content in layout
            var1 =findViewById(R.id.hello);
            var2 =findViewById(R.id.world);
            bigliner=findViewById(R.id.bigliner);
            points=findViewById(R.id.points);
            check=findViewById(R.id.checkquestion);

            //set the text of the question
            var1.setText("print('Hello')");
            var2.setText("print('World')");

            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!checking())
                        showDialog(q1.this);
                    else
                        startActivity( new Intent(q1.this, q2.class));
                }
            });


            var1.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                        view.startDrag(null, shadowBuilder, view, 0);
                        view.setVisibility(View.VISIBLE);
                        return true;
                    } else {
                        return false;
                    }
                }
            });

            var2.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                        view.startDrag(null, shadowBuilder, view, 0);
                        view.setVisibility(View.VISIBLE);
                        return true;
                    } else {
                        return false;
                    }
                }
            });


            findViewById(R.id.bigliner).setOnDragListener(new View.OnDragListener() {
                @Override
                public boolean onDrag(View layoutview, DragEvent dragevent) {
                    int action = dragevent.getAction();
                    switch (action) {
                        case DragEvent.ACTION_DRAG_STARTED:
                            Log.d(LOGCAT, "Drag event started");
                            break;
                        case DragEvent.ACTION_DRAG_ENTERED:
                            Log.d(LOGCAT, "Drag event entered into " + layoutview.toString());
                            break;
                        case DragEvent.ACTION_DRAG_EXITED:
                            Log.d(LOGCAT, "Drag event exited from " + layoutview.toString());
                            break;
                        case DragEvent.ACTION_DROP:
                            Log.d(LOGCAT, "Dropped");
                            View view = (View) dragevent.getLocalState();
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            LinearLayout container = (LinearLayout) layoutview;
                            container.addView(view);
                            view.setVisibility(View.VISIBLE);
                            break;
                        case DragEvent.ACTION_DRAG_ENDED:
                            Log.d(LOGCAT, "Drag ended");
                            break;

                        default:
                            break;
                    }
                    return true;
                }
            });
        }

        public  boolean checking(){
            boolean flag = false;
            int topPos[] = new int[2];
            topPos[0] = bigliner.indexOfChild(var1);
            topPos[1] = bigliner.indexOfChild(var2);

            for(int i=0;i<topPos.length;i++)
                if(i==topPos[i])
                    flag = true;
                else
                    flag=false;

            return flag;
        }

        public void showDialog(Activity activity) {
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.newcustom_layout);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.blue(32)));

            Button mDialogNo = dialog.findViewById(R.id.backToCode);
            mDialogNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            Button mDialogOk = dialog.findViewById(R.id.githint);
            mDialogOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (count != 0)
                        count--;
                    else
                            count=0;
                    points.setText(String.valueOf(count));
                    startActivity(new Intent(q1.this, hint1.class));

                    dialog.cancel();
                }
            });

            dialog.show();
        }


}


