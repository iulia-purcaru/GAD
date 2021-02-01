package com.example.googleatelierdigital;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Repository.Trip.TripRepository;

import java.util.ArrayList;
import java.util.List;

public class AdapterMyTrips extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Trip> vTrips;
    private Context context;

    public AdapterMyTrips(Context context, ArrayList<Trip> vTrips) {
        this.context = context;
        this.vTrips = vTrips;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tripNameView_;
        public TextView tripIdView_;
        public ImageView tripImageView_;

        public ViewHolder(View itemView) {
            super(itemView);

            tripNameView_ = itemView.findViewById(R.id.myTripName);
            tripIdView_ = itemView.findViewById(R.id.myTripId);
            tripImageView_ = itemView.findViewById(R.id.myTripImage);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);

        final View view = inflater.inflate(R.layout.cardview_mytrip, parent, false);

        RecyclerView.ViewHolder viewHolder = new AdapterMyTrips.ViewHolder(view);

        Button delete = view.findViewById(R.id.myTripDelete);
        final TextView recipeIdTextView = ((ViewHolder)viewHolder).tripIdView_;

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TripRepository tripRepository = new TripRepository(context);
                Trip trip = tripRepository.getTrip(Integer.parseInt(recipeIdTextView.getText().toString()));

                tripRepository.deleteTrip(trip);
                Trip trip1 = tripRepository.getTrip(Integer.parseInt(recipeIdTextView.getText().toString()));

                if(trip1 == null) {
                    Toast.makeText(context, "Recipe successfully deleted!", Toast.LENGTH_SHORT).show();
                    FragmentManager manager = ((MainActivity)context).getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container_main, new FragmentMyTrips()).commit();
                } else {
                    Toast.makeText(context, "Error on delete recipe!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView image = ((ViewHolder)holder).tripImageView_;
        TextView nameTextView = ((ViewHolder)holder).tripNameView_;
        TextView tripIdTextView = ((ViewHolder)holder).tripIdView_;
        nameTextView.setText(vTrips.get(position).getName());
        tripIdTextView.setText(((Integer)vTrips.get(position).getId()).toString());

    }

    @Override
    public int getItemCount() {
        return vTrips.size();
    }
}
