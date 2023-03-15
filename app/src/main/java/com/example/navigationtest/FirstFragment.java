package com.example.navigationtest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.navigationtest.databinding.FragmentFirstBinding;
import com.google.android.material.navigation.NavigationBarView;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Bundle bundle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        if (this.getArguments() != null) {
            TextView textView = binding.textView2;
            bundle = this.getArguments();
            String textArg = textView.getText() + " " + bundle.getString("arg");
            textView.setText(textArg);
        }

        Button buttonSecond = binding.buttonSecond;
        Button buttonThird = binding.buttonThird;

        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("arg", "First");
                Navigation.findNavController(view)
                        .navigate(R.id.action_firstFragment_to_secondFragment, bundle);
            }
        });

        buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("arg", "First");
                Navigation.findNavController(view)
                        .navigate(R.id.action_firstFragment_to_thirdFragment, bundle);
            }
        });

        return view;
    }
}