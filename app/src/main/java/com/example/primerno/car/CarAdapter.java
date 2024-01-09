package com.example.primerno.car;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerno.MainActivity;
import com.example.primerno.R;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {
    private Context context;
    private final List<Car> cars;

    public CarAdapter(List<Car> cars) {
        this.cars = cars;
    }


    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View mechanicView = inflater.inflate(R.layout.car, parent, false);
        return new CarViewHolder(mechanicView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.setStatus(car.isAvailable() + "");
        holder.setBrand(car.getBrand());
        holder.setLicense(car.getLicensePlate());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, CarInfoActivity.class);
            intent.putExtra("car", car);
            context.startActivity(intent);
        });

        holder.itemView.setOnLongClickListener(view -> {
            ((MainActivity) context).loadFrame(car);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
