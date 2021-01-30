package com.example.googleatelierdigital;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Repository.Trip.TripRepository;

import java.util.Calendar;

public class FragmentAdd extends Fragment {

    private DatePickerDialog.OnDateSetListener onDateSetListener ;

    public FragmentAdd() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        EditText nameTrip = view.findViewById(R.id.tripName);
        EditText location = view.findViewById(R.id.tripLocation);
        EditText tripDate = view.findViewById(R.id.tripDate);
        tripDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Dialog_MinWidth,onDateSetListener,
                                                                            year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month ++;
                String date = day + "/" + month + "/" +year;
                tripDate.setText(date);
            }
        };


       // final String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Button addTrip = view.findViewById(R.id.add);
        addTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("com.example.googleatelierdigital", Context.MODE_PRIVATE);
                int userId = sharedPreferences.getInt("com.example.googleatelierdigital", 0);

                if(nameTrip.getText().toString().isEmpty()){
                    nameTrip.setError("Insert Trip Name!");
                    nameTrip.requestFocus();
                }
                else if(location.getText().toString().isEmpty()){
                    location.setError("Insert Trip Name!");
                    location.requestFocus();
                }
                else{
                    //TO DO
                    //change when I add photo + field in constructor
                    final Trip trip = new Trip(nameTrip.getText().toString(), location.getText().toString(), tripDate.getText().toString(), null, userId);
                    new TripRepository(getContext()).insertTrip(trip, new ActionListener(){
                        @Override
                        public void actionSucces() {
                            Toast.makeText(getContext(), "Trip added", Toast.LENGTH_LONG).show();
                            SharedPreferences sharedPref = getActivity().getSharedPreferences("com.example.googleatelierdigital", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putInt("com.example.googleatelierdigital.tripId", trip.getId());
                            editor.apply();
                            getFragmentManager().beginTransaction().replace(R.id.fragment_container_main,new FragmentMyTrips()).commit();
                        }

                        @Override
                        public void actionFailed() {
                            Toast.makeText(getContext(), "Tehnically error", Toast.LENGTH_LONG).show();
                        }
                    });


                }
            }
        });
        return view;
    }
}