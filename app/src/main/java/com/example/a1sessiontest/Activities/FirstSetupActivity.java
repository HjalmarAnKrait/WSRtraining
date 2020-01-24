package com.example.a1sessiontest.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a1sessiontest.Fragments.Step1Fragment;
import com.example.a1sessiontest.Fragments.Step2Fragment;
import com.example.a1sessiontest.Fragments.Step3FemaleFragment;
import com.example.a1sessiontest.Fragments.Step3MaleFragment;
import com.example.a1sessiontest.Fragments.Step4Fragment;
import com.example.a1sessiontest.Fragments.Step5Fragment;
import com.example.a1sessiontest.R;

public class FirstSetupActivity extends AppCompatActivity implements Step1Fragment.to2Fragment, Step2Fragment.to3Fragment,
        Step3FemaleFragment.to4Fragment, Step3MaleFragment.to4Fragment, Step4Fragment.to5Fragment, Step5Fragment.toAuthRegActivity
{
    private TextView stepNumberTextView, stepDescriptionTextView;
    private int stepNumber = 1;
    private int fragmentContainerId = R.id.frameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_setup);

        stepNumberTextView = findViewById(R.id.stepNumberTextView);
        stepDescriptionTextView = findViewById(R.id.stepDescriptionTextView);
        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainerId, new Step1Fragment());
        setStepNumberText(1);
        fragmentTransaction.commit();



    }

    private void setStepNumberText(int stepNumber)
    {
        String stepNumberText = String.format("Step %d/5", stepNumber);
        switch (stepNumber)
        {
            case 1:
                stepDescriptionTextView.setText("What is your purpose?");
                break;
            case 2:
                stepDescriptionTextView.setText("What is your gender?");
                break;
            case 3:
                stepDescriptionTextView.setText("What do you work on?");
                break;
            case 4:
                stepDescriptionTextView.setText("How often do you excercise?");
                break;
            case 5:
                stepDescriptionTextView.setText("Whats your height and weight?");
                break;
                default:
                    stepDescriptionTextView.setText("Ты что, наркоман?\nБЫСТРО ЛЕЗЬ В КОД И ИСПРАВЛЯЙ");
                    break;
        }
        stepNumberTextView.setText(stepNumberText);
    }

    @Override
    public void to2Fragment()
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainerId, new Step2Fragment());
        setStepNumberText(++stepNumber);
        fragmentTransaction.commit();
    }

    @Override
    public void toFemale()
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainerId, new Step3FemaleFragment());
        setStepNumberText(++stepNumber);
        fragmentTransaction.commit();
    }

    @Override
    public void toMale()
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainerId, new Step3MaleFragment());
        setStepNumberText(++stepNumber);
        fragmentTransaction.commit();
    }

    @Override
    public void to4Fragment()
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainerId, new Step4Fragment());
        setStepNumberText(++stepNumber);
        fragmentTransaction.commit();
    }

    @Override
    public void to5Fragment()
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainerId, new Step5Fragment());
        setStepNumberText(++stepNumber);
        fragmentTransaction.commit();
    }

    @Override
    public void toAuthRegActivity()
    {
        startActivity(new Intent(getApplicationContext(), AuthActivity.class));
        finish();
    }
}
