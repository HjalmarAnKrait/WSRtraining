package com.example.a1sessiontest.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a1sessiontest.R;

public class Step2Fragment extends Fragment
{
    private boolean isSelected = false;
    private boolean isFemale;
    private  Button  next;
    private ImageButton female, male;
    public interface to3Fragment
    {
        void toFemale();
        void toMale();
    }
    private to3Fragment to3Fragment;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.e("432", "onCreate");
    }


    @Override
    public void onPause()
    {
        super.onPause();
        Log.e("432", "onAttach");
    }
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        Log.e("432", "onAttach");
        try
        {
           to3Fragment = (Step2Fragment.to3Fragment) context;
        }catch (Exception e)
        {
            Log.e("432", e.toString());
        }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.e("432", "onDestroy");
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        Log.e("432", "onDestroy");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.step2_fragment,null);
        Log.e("432", "onCreateView");

        female = view.findViewById(R.id.femaleButton);
        male = view.findViewById(R.id.maleButton);
        next = view.findViewById(R.id.nextButton);


        View.OnClickListener onClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int id = v.getId();
                switch (id)
                {
                    case R.id.femaleButton:
                        female.setBackground(getResources().getDrawable(R.drawable.round_button_pressed));
                        male.setBackground(getResources().getDrawable(R.drawable.round_button_unpressed));
                        isSelected = true;
                        isFemale = true;
                        break;
                    case R.id.maleButton:
                        male.setBackground(getResources().getDrawable(R.drawable.round_button_pressed));
                        female.setBackground(getResources().getDrawable(R.drawable.round_button_unpressed));
                        isSelected = true;
                        isFemale = false;
                        break;
                    case R.id.nextButton:
                        if(isSelected)
                        {
                            if(isFemale)
                            {
                                to3Fragment.toFemale();
                            }
                            else
                            {
                                to3Fragment.toMale();
                            }
                        }
                        else
                        {
                            Toast.makeText(getContext(), "Make a choice", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        };

        female.setOnClickListener(onClickListener);
        male.setOnClickListener(onClickListener);
        next.setOnClickListener(onClickListener);


        return view;
    }
}
