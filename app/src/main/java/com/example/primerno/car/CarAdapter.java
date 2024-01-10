package com.example.primerno.car;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerno.R;
import com.example.primerno.utils.FrameLoader;

import java.util.List;
import java.util.Random;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {
    private Context context;
    private final List<Car> cars;
    private FrameLoader frameLoader;

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
            frameLoader.loadFrame(car);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public void modifyItem() {
        Random random = new Random();
        int randomPos = random.nextInt(getItemCount());
        Car car = cars.get(randomPos);
        car.setAvailable(!car.isAvailable());
        notifyItemChanged(randomPos);
    }

    public void setFrameLoader(FrameLoader frameLoader) {
        this.frameLoader = frameLoader;
    }
}
