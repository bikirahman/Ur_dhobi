package com.example.urdhobi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class men extends Fragment {
    View view;
    int counttop=0;
    int count=0;
    int item3count=0;
    public men() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.men,container,false);

        Button add=(Button)view.findViewById(R.id.itemaddbut1);
        final TextView textView=(TextView)view.findViewById(R.id.itemdetails1);
        Button sub=(Button)view.findViewById(R.id.itemdec1);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                textView.setText(String.valueOf(count));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count<=0){
                    textView.setText(String.valueOf(count));
                    Toast.makeText(getActivity(), "Please add items", Toast.LENGTH_SHORT).show();
                }
                else {
                    count--;
                    textView.setText(String.valueOf(count));
                }

            }
        });


        Button topadd=(Button)view.findViewById(R.id.itemaddbut2);
        Button topdec=(Button)view.findViewById(R.id.itemdec2);
        final TextView tshirt=(TextView)view.findViewById(R.id.itemdetails2);

        topadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counttop++;
                tshirt.setText(String.valueOf(counttop));

            }
        });
        topdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counttop<=0){
                    tshirt.setText(String.valueOf(counttop));
                    Toast.makeText(getActivity(), "Please add items", Toast.LENGTH_SHORT).show();

                }
                else {
                    counttop--;
                    tshirt.setText(String.valueOf(counttop));

                }
            }
        });

        Button item3add=(Button)view.findViewById(R.id.itemaddbut3);
        final Button item3dec=(Button)view.findViewById(R.id.itemdec3);
        final TextView item3=(TextView)view.findViewById(R.id.itemdetails3);

        item3add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item3count++;
                item3.setText(String.valueOf(item3count));

            }
        });
        item3dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item3count<=0){
                    item3.setText(String.valueOf(item3count));
                    Toast.makeText(getActivity(), "Please add items", Toast.LENGTH_SHORT).show();
                }
                else {
                    item3count--;
                    item3.setText(String.valueOf(item3count));

                }
            }
        });
        return view;
    }
}
