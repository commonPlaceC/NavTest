package com.example.navigationtest;

import android.icu.util.BuddhistCalendar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.navigationtest.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        if (this.getArguments() != null) {
            TextView textView = binding.textView2;
            bundle = this.getArguments();
            String textArg = textView.getText() + " " + bundle.getString("arg");
            textView.setText(textArg);
        }

        Button buttonThird = binding.buttonThird;
        buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("arg", "Second");
                Navigation.findNavController(view)
                        .navigate(R.id.action_secondFragment_to_thirdFragment, bundle);
            }
        });

        return view;
    }
}