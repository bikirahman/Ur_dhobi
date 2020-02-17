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

import org.w3c.dom.Text;

public class women extends Fragment {
    View view;
    int kurticount=0;
    int pantscount=0;
    int tshirtcount=0;
    public women() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.women,container,false);
        Button firstkurti=(Button)view.findViewById(R.id.kurtiadd1);
        final TextView kurti=(TextView) view.findViewById(R.id.kurti1);
        Button fdec=(Button)view.findViewById(R.id.kurtidec1);

        firstkurti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               kurticount++;
               kurti.setText(String.valueOf(kurticount));

            }
        });
        fdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kurticount<=0){
                    kurti.setText(String.valueOf(kurticount));
                    Toast.makeText(getActivity(), "Please add items", Toast.LENGTH_SHORT).show();
                }
                else {
                    kurticount--;
                    kurti.setText(String.valueOf(kurticount));

                }
            }
        });
        Button pantsadd=(Button)view.findViewById(R.id.pantsadd2);
        final TextView pants=(TextView)view.findViewById(R.id.pants);
        Button pantsdec=(Button)view.findViewById(R.id.pantsdec2);

        pantsadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantscount++;
                pants.setText(String.valueOf(pantscount));

            }
        });
        pantsdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pantscount<=0){
                    pants.setText(String.valueOf(pantscount));
                    Toast.makeText(getActivity(), "Please add items", Toast.LENGTH_SHORT).show();
                }
                else {
                    pantscount--;
                    pants.setText(String.valueOf(pantscount));
                }
            }
        });

        Button topadd=(Button)view.findViewById(R.id.tshirtadd3);
        Button topdec=(Button)view.findViewById(R.id.tshirtdec3);
        final TextView tshirt=(TextView)view.findViewById(R.id.tshirt3);

        topadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tshirtcount++;
                tshirt.setText(String.valueOf(tshirtcount));

            }
        });
        topdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tshirtcount<=0){
                    tshirt.setText(String.valueOf(tshirtcount));
                    Toast.makeText(getActivity(), "Please add items", Toast.LENGTH_SHORT).show();
                }
                else {
                    tshirtcount--;
                    tshirt.setText(String.valueOf(tshirtcount));
                }
            }
        });

        return view;
    }
}
