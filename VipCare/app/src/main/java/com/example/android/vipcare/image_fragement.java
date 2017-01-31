package com.example.android.vipcare;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class image_fragement extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        if (container == null){
            return null;
        }
        return inflater.inflate(R.layout.image_fragement,container, false);
    }
}
