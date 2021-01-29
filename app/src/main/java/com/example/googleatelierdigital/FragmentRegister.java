package com.example.googleatelierdigital;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.googleatelierdigital.Model.User;
import com.example.googleatelierdigital.Repository.User.UserRepository;


public class FragmentRegister extends Fragment {

    public FragmentRegister() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        final EditText userName = view.findViewById(R.id.rFullName);
        final EditText email = view.findViewById(R.id.rEmail);
        final EditText password = view.findViewById(R.id.rPassword);
        final EditText passwordConfirmed = view.findViewById(R.id.rPasswordC);

        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {

                    @Override
                    public boolean onDown(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                        final int SWIPE_MIN_DISTANCE = 120;
                        final int SWIPE_MAX_OFF_PATH = 250;
                        final int SWIPE_THRESHOLD_VELOCITY = 200;
                        try {
                            if (Math.abs(motionEvent.getY() - motionEvent1.getY()) > SWIPE_MAX_OFF_PATH)
                                return false;
                            if (motionEvent1.getX() - motionEvent.getX() < -SWIPE_MIN_DISTANCE
                                    && Math.abs(v) > SWIPE_THRESHOLD_VELOCITY) {
                                FragmentLogin loginFragment = new FragmentLogin();
                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.fragment_container_first, loginFragment);
                                fragmentTransaction.commit();
                            }
                        } catch (Exception e) {
                            // nothing
                        }
                        return super.onFling(motionEvent, motionEvent1, v, v1);
                    }
                });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });

        Button newUser = view.findViewById(R.id.Register);
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User userRegistered = new UserRepository(getContext()).getUserByEmail(email.getText().toString());
                if (userName.getText().toString().isEmpty()) {
                    userName.setError("Field required");
                    userName.requestFocus();
                } else if (password.getText().toString().isEmpty()) {
                    password.setError("Field required");
                    password.requestFocus();
                } else if (passwordConfirmed.getText().toString().isEmpty()) {
                    passwordConfirmed.setError("Field required");
                    passwordConfirmed.requestFocus();
                } else if (email.getText().toString().isEmpty()) {
                    email.setError("Field required");
                    email.requestFocus();
                }else if (userRegistered != null) {
                    email.setError("For this email adress alreday exists an account!");
                    email.requestFocus();
                }else if (!password.getText().toString().equals(passwordConfirmed.getText().toString())) {
                    passwordConfirmed.setError("Repassword must be the same with password!");
                    passwordConfirmed.requestFocus();
                }else{
                    final User user = new User(userName.getText().toString(), password.getText().toString(),email.getText().toString());

                    new UserRepository(getContext()).insertTask(user, new ActionListener() {
                        @Override
                        public void actionSucces() {
                            Toast.makeText(getContext(), "User registered!", Toast.LENGTH_LONG).show();

                            //get id
                            UserRepository userRepository = new UserRepository(getContext());
                            User userAdded = userRepository.getUser(email.getText().toString(), password.getText().toString());

                            SharedPreferences sharedPref = getActivity().getSharedPreferences("com.example.googleatelierdigital", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putInt("com.example.googleatelierdigital.userId", userAdded.getId());
                            editor.apply();
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void actionFailed() {
                            Toast.makeText(getContext(), "Some tehnical problems!", Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        });

        return view;
    }
}