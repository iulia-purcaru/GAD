package com.example.googleatelierdigital;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.googleatelierdigital.Model.User;
import com.example.googleatelierdigital.Repository.User.UserRepository;

public class FragmentLogin extends Fragment {

    public FragmentLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        final EditText email = view.findViewById(R.id.iEmail);
        final EditText password = view.findViewById(R.id.iPassword);

        final Button login = view.findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         UserRepository userRepository = new UserRepository(getContext());
                                         User user = userRepository.getUserByEmail(email.getText().toString());
                                         String pass = userRepository.getUserPassword(email.getText().toString());

                                         if(email.getText().toString().isEmpty()){
                                             email.setError("You must provide an email!");
                                             email.requestFocus();
                                         }
                                         else if(password.getText().toString().isEmpty()){
                                             password.setError("You must provide a password!");
                                             password.requestFocus();
                                         }
                                         else if(user != null && !pass.equals(password.getText().toString())){
                                             password.setError("The password is incorrect!");
                                             password.requestFocus();
                                         }
                                         else{
                                             Toast.makeText(getContext(), "User is not correct", Toast.LENGTH_LONG).show();
                                         }

                                     }
                                 }

        );
        return view;
    }
}