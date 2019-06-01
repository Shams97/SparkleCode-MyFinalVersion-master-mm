package com.example.shms.trying;

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

public class q5 extends AppCompatActivity {

    Button var1,var2,statement,yes,check;
    public static int count =3;
    private static final String LOGCAT = "DROP EVENT:";
    LinearLayout bigliner;
    private FirebaseFirestore db;
    public static TextView points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q5);

        var1=(Button)findViewById(R.id.xvalue);
        var2=(Button)findViewById(R.id.yYalue);
        statement=(Button)findViewById(R.id.redIf);
        yes=(Button)findViewById(R.id.blueYes);
        check=(Button)findViewById(R.id.check);
        points=(TextView)findViewById(R.id.points);
        bigliner= (LinearLayout)findViewById(R.id.bigliner);



        var1.setText("input(x)");
        var2.setText("input(y)");
        statement.setText("if x < y :");
        yes.setText("print('yes')");


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checking())
                    showDialog(q5.this);
                else
                    startActivity( new Intent(q5.this, q6.class));
            }
        });


        findViewById(R.id.xvalue).setOnTouchListener(new View.OnTouchListener() {
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

        findViewById(R.id.yYalue).setOnTouchListener(new View.OnTouchListener() {
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

        findViewById(R.id.redIf).setOnTouchListener(new View.OnTouchListener() {
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

        findViewById(R.id.blueYes).setOnTouchListener(new View.OnTouchListener() {
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

        points.setText(String.valueOf(count));

    }

    public  boolean checking(){
        boolean flag = false;
        int[] topPos = new int[4];
        topPos[0] = bigliner.indexOfChild(var1);
        topPos[1] = bigliner.indexOfChild(var2);
        topPos[2] = bigliner.indexOfChild(statement);
        topPos[3] =bigliner.indexOfChild(yes);

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
                startActivity(new Intent(q5.this, hint5.class));

                dialog.cancel();
            }
        });
        dialog.show();
    }

}
