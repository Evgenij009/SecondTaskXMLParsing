package by.epam.eugene.entity;

public class CallPrices {
    private float priceWithinTheNetwork;
    private float priceOutsideNetwork;
    private float pricelandlinePhones;

    public CallPrices() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallPrices that = (CallPrices) o;

        if (Float.compare(that.priceWithinTheNetwork, priceWithinTheNetwork) != 0) return false;
        if (Float.compare(that.priceOutsideNetwork, priceOutsideNetwork) != 0) return false;
        return Float.compare(that.pricelandlinePhones, pricelandlinePhones) == 0;
    }

    @Override
    public int hashCode() {
        int result = (priceWithinTheNetwork != +0.0f ? Float.floatToIntBits(priceWithinTheNetwork) : 0);
        result = 31 * result + (priceOutsideNetwork != +0.0f ? Float.floatToIntBits(priceOutsideNetwork) : 0);
        result = 31 * result + (pricelandlinePhones != +0.0f ? Float.floatToIntBits(pricelandlinePhones) : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\n");
        sb.append("\tpriceWithinTheNetwork=").append(priceWithinTheNetwork);
        sb.append(", \n\tpriceOutsideNetwork=").append(priceOutsideNetwork);
        sb.append(", \n\tpricelandlinePhones=").append(pricelandlinePhones);
        return sb.toString();
    }
}
