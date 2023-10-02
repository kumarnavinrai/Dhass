package com.example.dhass;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlaceholderFragment extends Fragment {

    private Button buttonSave;
    private EditText upperLimitEditText;
    private EditText lowerLimitEditText;
    public PlaceholderFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        // Customize the fragment's layout and functionality here
        buttonSave = view.findViewById(R.id.saveButton);
        upperLimitEditText = view.findViewById(R.id.upperLimitEditText);
        lowerLimitEditText = view.findViewById(R.id.lowerLimitEditText);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ul = upperLimitEditText.getText().toString();
                String ll = lowerLimitEditText.getText().toString();
                ul = ul.trim();
                ll = ll.trim();
                if(!ul.isEmpty() && Integer.parseInt(ul) <= 100){
                    if(!ll.isEmpty() && Integer.parseInt(ll) >=1){
                        if(Integer.parseInt(ul) > Integer.parseInt(ll)) {
                            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putInt("upperlimit", Integer.parseInt(ul));
                            editor.putInt("lowerlimit", Integer.parseInt(ll));
                            editor.apply();
                            Toast.makeText(view.getContext(), "Successfully Saved !!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(view.getContext(),"Upper limit should be more than lower limit !", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(view.getContext(),"Lower Limit Cannot be empty or less than 1 !", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(view.getContext(),"Upper Limit Cannot be empty or greater than 100 !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
