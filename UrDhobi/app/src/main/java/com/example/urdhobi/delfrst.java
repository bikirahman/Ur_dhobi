package com.example.urdhobi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class delfrst extends Fragment {
    View view;
    CheckBox c1,c2,c3;
    public delfrst() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.deliveryfirst,container,false);
        c1=(CheckBox)view.findViewById(R.id.nineto12);
        c2=(CheckBox)view.findViewById(R.id.twlveto3);
        c3=(CheckBox)view.findViewById(R.id.threeto6);

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    c2.setChecked(false);
                    c3.setChecked(false);
                }
            }
        });
        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    c1.setChecked(false);
                    c3.setChecked(false);
                }
            }
        });
        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                c2.setChecked(false);
                c1.setChecked(false);
            }
        });
        return view;
    }
}
