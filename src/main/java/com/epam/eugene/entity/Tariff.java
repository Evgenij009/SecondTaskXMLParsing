package com.epam.eugene.entity;

public class Tariff {
    private String name;
    private OperatorName operatorName;
    private double payroll;
    private CallPrices callPrices;
    private double pricePerSMS;
    private Parameters parameters;

    public Tariff() {
    }

    public Tariff(String name, OperatorName operatorName, double payroll, CallPrices callPrices, double pricePerSMS, Parameters parameters) {
        this.name = name;
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.callPrices = callPrices;
        this.pricePerSMS = pricePerSMS;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OperatorName getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(OperatorName operatorName) {
        this.operatorName = operatorName;
    }

    public double getPayroll() {
        return payroll;
    }

    public void setPayroll(double payroll) {
        this.payroll = payroll;
    }

    public CallPrices getCallPrices() {
        return callPrices;
    }

    public void setCallPrices(CallPrices callPrices) {
        this.callPrices = callPrices;
    }

    public double getPricePerSMS() {
        return pricePerSMS;
    }

    public void setPricePerSMS(double pricePerSMS) {
        this.pricePerSMS = pricePerSMS;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tariff that = (Tariff) o;

        if (Double.compare(that.payroll, payroll) != 0) return false;
        if (Double.compare(that.pricePerSMS, pricePerSMS) != 0) return false;
        if (!name.equals(that.name)) return false;
        if (operatorName != that.operatorName) return false;
        if (!callPrices.equals(that.callPrices)) return false;
        return parameters.equals(that.parameters);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + operatorName.hashCode();
        temp = Double.doubleToLongBits(payroll);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + callPrices.hashCode();
        temp = Double.doubleToLongBits(pricePerSMS);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + parameters.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AbstractTariff{");
        sb.append("name='").append(name).append('\'');
        sb.append(", operatorName=").append(operatorName);
        sb.append(", payroll=").append(payroll);
        sb.append(", callPrices=").append(callPrices);
        sb.append(", pricePerSMS=").append(pricePerSMS);
        sb.append(", parameters=").append(parameters);
        sb.append('}');
        return sb.toString();
    }
}
