package com.example.a1sessiontest.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a1sessiontest.R;

public class Step4Fragment extends Fragment
{
    private boolean isSelected = false;
    public interface to5Fragment
    {
        void to5Fragment();
    }
    to5Fragment to5Fragment;

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try
        {
            to5Fragment = (Step4Fragment.to5Fragment) context;
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
        View view = inflater.inflate(R.layout.step4_fragment,null);
        final Button newbie, keep, advanced, next;
        newbie = view.findViewById(R.id.newbieButton);
        keep = view.findViewById(R.id.keepButton);
        advanced = view.findViewById(R.id.advancedButton);
        next = view.findViewById(R.id.nextButton);
        View.OnClickListener onClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int id = v.getId();
                switch (id)
                {
                    case R.id.newbieButton:
                        newbie.setBackground(getResources().getDrawable(R.drawable.rounded_button_pressed));
                        keep.setBackground(getResources().getDrawable(R.drawable.rounded_button_unpressed));
                        advanced.setBackground(getResources().getDrawable(R.drawable.rounded_button_unpressed));
                        isSelected = true;
                        break;

                    case R.id.keepButton:
                        keep.setBackground(getResources().getDrawable(R.drawable.rounded_button_pressed));
                        newbie.setBackground(getResources().getDrawable(R.drawable.rounded_button_unpressed));
                        advanced.setBackground(getResources().getDrawable(R.drawable.rounded_button_unpressed));
                        isSelected = true;
                        break;

                    case R.id.advancedButton:
                        advanced.setBackground(getResources().getDrawable(R.drawable.rounded_button_pressed));
                        keep.setBackground(getResources().getDrawable(R.drawable.rounded_button_unpressed));
                        newbie.setBackground(getResources().getDrawable(R.drawable.rounded_button_unpressed));
                        isSelected = true;
                        break;

                    default:
                        if(isSelected)
                        {
                            to5Fragment.to5Fragment();
                        }
                        else
                        {
                            Toast.makeText(getContext(), "Make a choice!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        };

        newbie.setOnClickListener(onClickListener);
        advanced.setOnClickListener(onClickListener);
        keep.setOnClickListener(onClickListener);
        next.setOnClickListener(onClickListener);

        return view;
    }

}
