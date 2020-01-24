package com.example.a1sessiontest.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a1sessiontest.R;

public class Step3FemaleFragment extends Fragment
{
    public interface to4Fragment
    {
        void to4Fragment();
    }

    private to4Fragment to4Fragment;
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try
        {
            to4Fragment = (Step3FemaleFragment.to4Fragment) context;
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
        View view = inflater.inflate(R.layout.step3_female_fragment,null);

        View.OnClickListener onClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                to4Fragment.to4Fragment();
            }
        };

        Button hands, spine, torso, legs;
        hands = view.findViewById(R.id.handsButton);
        spine = view.findViewById(R.id.spineButton);
        torso = view.findViewById(R.id.torsoButton);
        legs = view.findViewById(R.id.legsButton);

        hands.setOnClickListener(onClickListener);
        spine.setOnClickListener(onClickListener);
        torso.setOnClickListener(onClickListener);
        legs.setOnClickListener(onClickListener);

        ImageView woman = view.findViewById(R.id.ridingWoman);
        woman.animate().translationX(-200).setDuration(1000);



        return view;
    }
}
