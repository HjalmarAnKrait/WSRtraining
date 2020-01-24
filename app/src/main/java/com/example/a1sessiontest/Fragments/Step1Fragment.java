package com.example.a1sessiontest.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a1sessiontest.R;

public class Step1Fragment extends Fragment
{
    public interface to2Fragment
    {
        void to2Fragment();
    }

    private to2Fragment to2Fragment;
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try
        {
            to2Fragment = (Step1Fragment.to2Fragment) context;
        }
        catch (Exception e)
        {
            Log.e("432", e.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.step1_fragment,null);

        View.OnClickListener onClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                to2Fragment.to2Fragment();
            }
        };

        Button weight, fit, muscle;
        weight = view.findViewById(R.id.weightButton);
        fit = view.findViewById(R.id.fitButton);
        muscle = view.findViewById(R.id.muscleButton);

        weight.setOnClickListener(onClickListener);
        fit.setOnClickListener(onClickListener);
        muscle.setOnClickListener(onClickListener);



        return view;
    }
}
