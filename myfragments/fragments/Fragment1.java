package com.example.risha.myfragments.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.risha.myfragments.R;

/**
 * Created by risha on 30-Dec-17.
 */

public class Fragment1 extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View v=  inflater.inflate(R.layout.layout_1,container,false);
        return v;
    }
}
