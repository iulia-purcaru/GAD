package com.example.googleatelierdigital;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Repository.Trip.TripRepository;

import java.util.ArrayList;


public class FragmentMyTrips extends Fragment {

    private ArrayList<Trip> trips;
    private AdapterAllTrips adapterMyTrips;

    public FragmentMyTrips() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_trips, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPref = getActivity().getSharedPreferences("com.example.googleatelierdigital", Context.MODE_PRIVATE);
        int userId = sharedPref.getInt("com.example.googleatelierdigital.userId", 0);

        trips = new ArrayList<Trip>();
        trips = (ArrayList<Trip>) new TripRepository(getContext()).getTripsByUserId(userId);

        Context context = view.getContext();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerMyTrips);
        recyclerView.setHasFixedSize(true);
        adapterMyTrips = new AdapterAllTrips(getContext(), trips);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterMyTrips);
        layoutManager.setSmoothScrollbarEnabled(true);
    }
}