package com.example.primerno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        List<Car> cars = CarSource.getCars();
        CarAdapter adapter = new CarAdapter(cars);
        adapter.setFrameLoader(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        brand = findViewById(R.id.brandEdit);
        license = findViewById(R.id.licenseEdit);
        status = findViewById(R.id.statusEdit);
        owner = findViewById(R.id.carOwnerEdit);

        findViewById(R.id.save).setOnClickListener(view -> {
            int position = getIntent().getIntExtra("pos", 0);
            Car car = new Car(brand.getText().toString(), license.getText().toString(), Boolean.parseBoolean(status.getText().toString()));
            car.setOwnerName(owner.getText().toString());
            cars.set(position, car);
            Objects.requireNonNull(recyclerView.getAdapter()).notifyItemChanged(position);
        });

        

    }

    @Override
        public void loadFrame(Car car) {
        brand.setText(car.getBrand());
        license.setText(car.getLicensePlate());
        owner.setText(car.getOwnerName());
        status.setText(String.valueOf(car.isAvailable()));
    }
}