package com.example.primerno;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerno.car.Car;
import com.example.primerno.car.CarAdapter;
import com.example.primerno.car.CarSource;
import com.example.primerno.utils.FrameLoader;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements FrameLoader {

    private EditText brand;
    private EditText license;
    private EditText status;
    private EditText owner;
    private CarAdapter adapter;
    private Handler handler;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        List<Car> cars = CarSource.getCars();
        adapter = new CarAdapter(cars);
        adapter.setFrameLoader(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        brand = findViewById(R.id.brandEdit);
        license = findViewById(R.id.licenseEdit);
        status = findViewById(R.id.statusEdit);
        owner = findViewById(R.id.carOwnerEdit);
        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(modifyItem, 2500);

        findViewById(R.id.save).setOnClickListener(view -> {
            Car car = new Car(brand.getText().toString(), license.getText().toString(), Boolean.parseBoolean(status.getText().toString()));
            car.setOwnerName(owner.getText().toString());
            cars.set(position, car);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyItemChanged(position);
        });

        

    }

    private final Runnable modifyItem = new Runnable() {
        @Override
        public void run() {
            adapter.modifyItem();
            handler.postDelayed(this, 2500);
        }
    };

    @Override
        public void loadFrame(Car car, int pos) {
        brand.setText(car.getBrand());
        license.setText(car.getLicensePlate());
        owner.setText(car.getOwnerName());
        status.setText(String.valueOf(car.isAvailable()));
        position = pos;
        FrameLayout frameLayout = findViewById(R.id.frame);
        frameLayout.setVisibility(View.VISIBLE);
    }
}