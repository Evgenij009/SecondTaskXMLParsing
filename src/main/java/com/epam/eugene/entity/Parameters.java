package com.epam.eugene.entity;

public class Parameters {
    private long favoriteNumber;
    private double feeConnection;
    private Tariffication tariffication;

    public Parameters(long favoriteNumber, double feeConnection, Tariffication tariffication) {
        this.favoriteNumber = favoriteNumber;
        this.feeConnection = feeConnection;
        this.tariffication = tariffication;
    }

    public void setFavoriteNumber(long favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public void setFeeConnection(double feeConnection) {
        this.feeConnection = feeConnection;
    }

    public void setTariffication(Tariffication tariffication) {
        this.tariffication = tariffication;
    }

    public long getFavoriteNumber() {
        return favoriteNumber;
    }

    public double getFeeConnection() {
        return feeConnection;
    }

    public Tariffication getTariffication() {
        return tariffication;
    }

}
