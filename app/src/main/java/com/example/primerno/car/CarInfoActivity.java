package com.example.primerno.car;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.primerno.R;

public class CarInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);
        TextView brand = findViewById(R.id.brandView);
        TextView license = findViewById(R.id.licenseView);
        TextView status = findViewById(R.id.statusView);
        TextView carOwner = findViewById(R.id.carOwner);
        Car car = getIntent().getParcelableExtra("car");

        if (car != null) {
            brand.setText(car.getBrand());
            license.setText(car.getLicensePlate());
            status.setText(String.valueOf(car.isAvailable()));
            carOwner.setText(car.getOwnerName());
        }
    }
}