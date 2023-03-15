package com.example.navigationtest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.navigationtest.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        if (this.getArguments() != null) {
            TextView textView = binding.textView2;
            bundle = this.getArguments();
            String textArg = textView.getText() + " " + bundle.getString("arg");
            textView.setText(textArg);
        }

        Button buttonFirst = binding.buttonFirst;
        Button buttonSecond = binding.buttonThird;

        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("arg", "Third");
                Navigation.findNavController(view)
                        .navigate(R.id.action_thirdFragment_to_firstFragment, bundle);
            }
        });

        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("arg", "Third");
                Navigation.findNavController(view)
                        .navigate(R.id.action_thirdFragment_to_secondFragment, bundle);
            }
        });

        return view;
    }
}