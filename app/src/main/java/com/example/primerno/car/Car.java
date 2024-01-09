package com.example.primerno.car;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Car implements Parcelable {
    private String brand;
    private String licensePlate;
    private boolean available;
    private String ownerName;

    public Car(String brand, String licensePlate, boolean available) {
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.available = available;
        this.ownerName = "SuperMan";
    }

    protected Car(Parcel in) {
        brand = in.readString();
        licensePlate = in.readString();
        available = in.readByte() != 0;
        ownerName = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(brand);
        parcel.writeString(licensePlate);
        parcel.writeByte((byte) (available ? 1 : 0));
        parcel.writeString(ownerName);
    }
}
