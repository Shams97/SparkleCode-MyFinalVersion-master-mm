package com.example.shms.trying;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class q7_1 extends AppCompatActivity {
    Button for_statment,PrintOut,check;
    public static int count =3;
    public static TextView points,outPut;

    private static final String LOGCAT = "DROP EVENT:";
    LinearLayout bigliner;
    private FirebaseFirestore db;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q7_1);

        for_statment=findViewById(R.id.redIf);
        PrintOut=findViewById(R.id.blueYes);
        check=findViewById(R.id.check);
        points=findViewById(R.id.points);
        outPut= findViewById(R.id.outPut);
        bigliner=findViewById(R.id.bigliner);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!checking())
                    showDialog(q7_1.this);
                else {
                    startActivity(new Intent(q7_1.this, end_level2.class));
                }
            }
        });


        for_statment.setOnTouchListener(new View.OnTouchListener() {
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

        PrintOut.setOnTouchListener(new View.OnTouchListener() {
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

//        for_statment.setText("for x in range(1,6)");
//        PrintOut.setText("print(x)");
    }
    public  boolean checking(){
        boolean flag = false;
        int topPos[] = new int[2];
        topPos[0] = bigliner.indexOfChild(for_statment);
        topPos[1] = bigliner.indexOfChild(PrintOut);

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
                startActivity(new Intent(q7_1.this, hint7.class));

                dialog.cancel();
            }
        });

        dialog.show();
    }

}
