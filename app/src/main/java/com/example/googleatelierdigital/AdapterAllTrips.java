package com.example.googleatelierdigital;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Model.User;
import com.example.googleatelierdigital.Repository.Trip.TripRepository;
import com.example.googleatelierdigital.Repository.User.UserRepository;

import java.util.ArrayList;

public class AdapterAllTrips extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Trip> vTrips;
    private Context context;

    public AdapterAllTrips(Context context, ArrayList<Trip> vTrips) {
        this.context = context;
        this.vTrips = vTrips;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tripNameView;
        public TextView tripIdView;
        public ImageView tripImageView;
//        public TextView userTripNameView;

        public ViewHolder(View itemView) {
            super(itemView);

            tripNameView = itemView.findViewById(R.id.tripName);
            tripIdView = itemView.findViewById(R.id.tripId);
//            userTripNameView = itemView.findViewById(R.id.uTripName);
            tripImageView = itemView.findViewById(R.id.tripImage);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);

        final View view = inflater.inflate(R.layout.cardview_trips, parent, false);
        RecyclerView.ViewHolder viewHolder = new AdapterAllTrips.ViewHolder(view);

        final TextView tripId = ((ViewHolder)viewHolder).tripIdView;

//        view.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                SharedPreferences sharedPref = context.getSharedPreferences("com.example.googleatelierdigital", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPref.edit();
//
//                editor.putInt("com.example.googleatelierdigital.tripId", Integer.parseInt(tripId.getText().toString()));
//                editor.apply();
//
//                FragmentManager manager = ((MainActivity)context).getSupportFragmentManager();
//                manager.beginTransaction().replace(R.id.fragment_container_main, new FragmentTrip()).commit();
//            }
//        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //need to update
        ImageView image = ((ViewHolder)holder).tripImageView;
        TextView nameTextView = ((ViewHolder)holder).tripNameView;
        TextView tripIdTextView = ((ViewHolder)holder).tripIdView;
//        TextView userTripNameView = ((ViewHolder)holder).userTripNameView;


//        TripRepository tripRepository = new TripRepository(context);
//        String userName = tripRepository.getUserIdByTripId(Integer.parseInt(tripIdTextView.getText().toString()));
//        userTripNameView.setText(userName);

        nameTextView.setText(vTrips.get(position).getName());

        tripIdTextView.setText(((Integer)vTrips.get(position).getId()).toString());
    }

    @Override
    public int getItemCount() {
        return vTrips.size();
    }
}
