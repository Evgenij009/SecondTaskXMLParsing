package com.epam.eugene.entity;

public class CallPrices {
    private float priceWithinTheNetwork;
    private float priceOutsideNetwork;
    private float pricelandlinePhones;

    public CallPrices(float priceWithinTheNetwork, float priceOutsideNetwork, float pricelandlinePhones) {
        this.priceWithinTheNetwork = priceWithinTheNetwork;
        this.priceOutsideNetwork = priceOutsideNetwork;
        this.pricelandlinePhones = pricelandlinePhones;
    }

    public float getPriceWithinTheNetwork() {
        return priceWithinTheNetwork;
    }

    public void setPriceWithinTheNetwork(float priceWithinTheNetwork) {
        this.priceWithinTheNetwork = priceWithinTheNetwork;
    }

    public float getPriceOutsideNetwork() {
        return priceOutsideNetwork;
    }

    public void setPriceOutsideNetwork(float priceOutsideNetwork) {
        this.priceOutsideNetwork = priceOutsideNetwork;
    }

    public float getPricelandlinePhones() {
        return pricelandlinePhones;
    }

    public void setPricelandlinePhones(float pricelandlinePhones) {
        this.pricelandlinePhones = pricelandlinePhones;
    }

}
