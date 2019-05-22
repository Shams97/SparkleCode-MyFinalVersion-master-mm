package com.example.shms.trying;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.google.firebase.firestore.FirebaseFirestore;

public class q8_1 extends AppCompatActivity {

    Button myList,for_statement,print,check;
    public static int count =3;
    public static TextView points;

    private static final String LOGCAT = "DROP EVENT:";
    LinearLayout bigliner;
    private FirebaseFirestore db;
TextView output;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q8_1);

        myList=findViewById(R.id.xvalue);
        for_statement=findViewById(R.id.yYalue);
        print=findViewById(R.id.redIf);
        check=findViewById(R.id.check);
        bigliner=findViewById(R.id.bigliner);
        output=findViewById(R.id.outPut);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checking())
                    showDialog(q8_1.this);
                else
                    startActivity( new Intent(q8_1.this, q9.class));
            }
        });

        myList.setOnTouchListener(new View.OnTouchListener() {
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

        for_statement.setOnTouchListener(new View.OnTouchListener() {
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

        print.setOnTouchListener(new View.OnTouchListener() {
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

        myList.setText("my_list=[12,\"Hello\",3.4]");
        for_statement.setText("for i in range(len(my_list)):");
        print.setText("print(my_list [ i ] )");
        output.setText("12,\"Hello\",3.4");
    }

    public  boolean checking(){
        boolean flag = false;
        int[] topPos = new int[3];
        topPos[0] = bigliner.indexOfChild(myList);
        topPos[1] = bigliner.indexOfChild(for_statement);
        topPos[2] = bigliner.indexOfChild(print);

        for(int i=0;i<topPos.length;i++)
            flag = i == topPos[i];

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
                startActivity(new Intent(q8_1.this, hint8.class));
                dialog.cancel();
            }
        });

        dialog.show();
    }

}
