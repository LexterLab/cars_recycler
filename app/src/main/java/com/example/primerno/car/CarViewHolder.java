package com.example.primerno.car;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerno.R;

public class CarViewHolder extends RecyclerView.ViewHolder {
    private final TextView brand;
    private final TextView license;
    private final TextView status;

    public CarViewHolder(@NonNull View itemView) {
        super(itemView);
        this.brand = itemView.findViewById(R.id.brand);
        this.license = itemView.findViewById(R.id.license);
        this.status = itemView.findViewById(R.id.status);
    }

    public void setBrand(String brand) {
        this.brand.setText(brand);
    }

    public void setLicense(String license) {
        this.license.setText(license);
    }

    public void setStatus(String status) {
        this.status.setText(status);
    }
}
