package com.example.shms.trying;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentTransaction;
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
//import java.io.IOException;

//import com.example.shms.trying.hints.hint4;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class q4 extends AppCompatActivity {

    private android.widget.RelativeLayout.LayoutParams layoutParams;
    private static final String LOGCAT = "DROP EVENT:";
    public static int count =3;
    private FirebaseFirestore db;
    TextView points;
    Button check,red_c,green_d,red_e,blue_o;



    FragmentTransaction transaction;
    LinearLayout bigliner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);
        FirebaseApp.initializeApp(this);
        db = FirebaseFirestore.getInstance();
        //get the id of the views
        check = (Button) findViewById(R.id.check);

        final CollectionReference CollRef = db.collection("blocks");
        red_c = (Button) findViewById(R.id.red_c);
        green_d = (Button) findViewById(R.id.green_d);
        red_e = (Button) findViewById(R.id.pink_e);
        blue_o = (Button) findViewById(R.id.blue_o);
        points=(TextView)findViewById(R.id.points);

       bigliner= (LinearLayout)findViewById(R.id.bigliner);
        red_c.setText("print(\'c\')");
        blue_o.setText("print(\'o\')");
        green_d.setText("print(\'d\')");
        red_e.setText("print(\'e\')");
        final String codes[] = {red_c.getText().toString(), blue_o.getText().toString()
                , green_d.getText().toString(), red_e.getText().toString()};

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!checking())
                    showDialog(q4.this);
                    else
                {
                    startActivity(new Intent(q4.this, end_level1.class));
                }


            }
        });


        findViewById(R.id.blue_o).setOnTouchListener(new View.OnTouchListener() {
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

        findViewById(R.id.green_d).setOnTouchListener(new View.OnTouchListener() {
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
        findViewById(R.id.pink_e).setOnTouchListener(new View.OnTouchListener() {
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
        findViewById(R.id.red_c).setOnTouchListener(new View.OnTouchListener() {
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
//    points.setText(String.valueOf(count));
    }

  public  boolean checking(){
        boolean flag = false;
      int[] topPos;
      topPos = new int[4];
      topPos[0] = bigliner.indexOfChild(red_c);
                topPos[1] = bigliner.indexOfChild(blue_o);
                topPos[2] = bigliner.indexOfChild(green_d);
                topPos[3] = bigliner.indexOfChild(red_e);
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
                startActivity(new Intent(q4.this, hint4.class));

                dialog.cancel();
            }
        });

        dialog.show();
    }
}