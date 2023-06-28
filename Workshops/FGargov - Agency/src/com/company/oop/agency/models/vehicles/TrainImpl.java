package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.models.vehicles.enums.VehicleType;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleBase implements Train {

    private static final int PASSENGER_MIN_VALUE = 30;
    private static final int PASSENGER_MAX_VALUE = 150;
    private static final String PASSENGER_ERROR_MESSAGE = String.format(
            "A train cannot have less than %d passengers or more than %d passengers.",
            PASSENGER_MIN_VALUE,
            PASSENGER_MAX_VALUE);
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;
    private static final String CART_ERROR_MESSAGE = String.format(
            "A train cannot have less than %d cart or more than %d carts.",
            CARTS_MIN_VALUE,
            CARTS_MAX_VALUE);

    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer);
        setCarts(carts);
    }

    @Override
    public int getCarts() {
        return this.carts;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.LAND;
    }

    private void setCarts(int cart) {
        ValidationHelper.validateValueInRange(cart, CARTS_MIN_VALUE, CARTS_MAX_VALUE, CART_ERROR_MESSAGE);
        this.carts = cart;
    }

    @Override
    void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                PASSENGER_ERROR_MESSAGE);
    }

    @Override
    public String getAsString() {
        return String.format("%s" +
                        "Carts amount: %d\n",
                super.getAsString(),
                getCarts());
    }
}