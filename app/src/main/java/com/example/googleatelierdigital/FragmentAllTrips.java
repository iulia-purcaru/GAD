package com.example.googleatelierdigital;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Repository.Trip.TripRepository;

import java.util.ArrayList;


public class FragmentAllTrips extends Fragment {


    private ArrayList<Trip> trips;
    private AdapterAllTrips adapterAllTrips;

    public FragmentAllTrips() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trips = new ArrayList<Trip>();
        trips = (ArrayList<Trip>) new TripRepository(getContext()).getTrips();

        Context context = view.getContext();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerAllTrips);
        recyclerView.setHasFixedSize(true);
        adapterAllTrips = new AdapterAllTrips(getContext(), trips);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterAllTrips);
        layoutManager.setSmoothScrollbarEnabled(true);
    }

}