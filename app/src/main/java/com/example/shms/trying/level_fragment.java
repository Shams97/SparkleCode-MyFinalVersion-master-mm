package com.example.shms.trying;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class level_fragment extends Fragment {
Button l1,l2,l3;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.level_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        l1 = (Button) view.findViewById(R.id.L1);
        l2 = (Button) view.findViewById(R.id.L2);
        l3 = (Button) view.findViewById(R.id.L3);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), q1.class);
                startActivity(intent);

            }
        });

                l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (end_level1.clickable) {
                    l2.setEnabled(true);
                    startActivity(new Intent(getActivity(),q5.class));

                } else {
                    l2.setEnabled(false);
                }
            }
        });

        l3.setEnabled(false);
    }

}


