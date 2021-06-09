package com.epam.eugene.entity;

public class CallPrices {
    private double priceWithinTheNetwork;
    private double priceOutsideNetwork;
    private double pricelandlinePhones;

    public CallPrices(double priceWithinTheNetwork, double priceOutsideNetwork, double pricelandlinePhones) {
        this.priceWithinTheNetwork = priceWithinTheNetwork;
        this.priceOutsideNetwork = priceOutsideNetwork;
        this.pricelandlinePhones = pricelandlinePhones;
    }

    public double getPriceWithinTheNetwork() {
        return priceWithinTheNetwork;
    }

    public void setPriceWithinTheNetwork(double priceWithinTheNetwork) {
        this.priceWithinTheNetwork = priceWithinTheNetwork;
    }

    public double getPriceOutsideNetwork() {
        return priceOutsideNetwork;
    }

    public void setPriceOutsideNetwork(double priceOutsideNetwork) {
        this.priceOutsideNetwork = priceOutsideNetwork;
    }

    public double getPricelandlinePhones() {
        return pricelandlinePhones;
    }

    public void setPricelandlinePhones(double pricelandlinePhones) {
        this.pricelandlinePhones = pricelandlinePhones;
    }

}
