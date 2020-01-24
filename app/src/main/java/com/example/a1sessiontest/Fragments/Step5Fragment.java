package com.example.a1sessiontest.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a1sessiontest.R;

public class Step5Fragment extends Fragment
{
    public interface toAuthRegActivity
    {
        void toAuthRegActivity();
    }
    toAuthRegActivity toAuthRegActivity;

    @Override
    public void onAttach(Context context)
    {
        try
        {
            toAuthRegActivity = (Step5Fragment.toAuthRegActivity) context;
        }
        catch (Exception e)
        {
            Log.e("432", e.toString());
        }
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.step5_fragment,null);
        Log.e("432", "onCreateView");
        final EditText weight, height;
        weight = view.findViewById(R.id.weightText);
        height = view.findViewById(R.id.heightText);
        Button nextButton = view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!(weight.getText().toString().isEmpty() || height.getText().toString().isEmpty()))
                {
                    toAuthRegActivity.toAuthRegActivity();
                    getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE).edit().putBoolean("isFirstLaunch", false).apply();
                }
                else
                {
                    Toast.makeText(getContext(), "Enter All Fields", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}
