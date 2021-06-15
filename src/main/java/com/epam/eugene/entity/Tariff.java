package com.epam.eugene.entity;

import java.time.LocalDate;

public class Tariff {
    private String name;
    private String vendorCode;
    private LocalDate localDate;
    private float payroll;
    private float smsPrice;
    private OperatorName operatorName;
    private CallPrices callPrices = new CallPrices();
    private Parameters parameters = new Parameters();

    public Tariff() {
    }

    public Tariff(String name, String vendorCode, LocalDate localDate, float payroll, float smsPrice, OperatorName operatorName, CallPrices callPrices, Parameters parameters) {
        this.name = name;
        this.vendorCode = vendorCode;
        this.localDate = localDate;
        this.payroll = payroll;
        this.smsPrice = smsPrice;
        this.operatorName = operatorName;
        this.callPrices = callPrices;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public OperatorName getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(OperatorName operatorName) {
        this.operatorName = operatorName;
    }

    public float getPayroll() {
        return payroll;
    }

    public void setPayroll(float payroll) {
        this.payroll = payroll;
    }

    public CallPrices getCallPrices() {
        return callPrices;
    }

    public void setCallPrices(CallPrices callPrices) {
        this.callPrices = callPrices;
    }

    public float getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(float smsPrice) {
        this.smsPrice = smsPrice;
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

        Tariff tariff = (Tariff) o;

        if (Float.compare(tariff.payroll, payroll) != 0) return false;
        if (Float.compare(tariff.smsPrice, smsPrice) != 0) return false;
        if (name != null ? !name.equals(tariff.name) : tariff.name != null) return false;
        if (vendorCode != null ? !vendorCode.equals(tariff.vendorCode) : tariff.vendorCode != null) return false;
        if (localDate != null ? !localDate.equals(tariff.localDate) : tariff.localDate != null) return false;
        if (operatorName != tariff.operatorName) return false;
        if (callPrices != null ? !callPrices.equals(tariff.callPrices) : tariff.callPrices != null) return false;
        return parameters != null ? parameters.equals(tariff.parameters) : tariff.parameters == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (vendorCode != null ? vendorCode.hashCode() : 0);
        result = 31 * result + (localDate != null ? localDate.hashCode() : 0);
        result = 31 * result + (payroll != +0.0f ? Float.floatToIntBits(payroll) : 0);
        result = 31 * result + (smsPrice != +0.0f ? Float.floatToIntBits(smsPrice) : 0);
        result = 31 * result + (operatorName != null ? operatorName.hashCode() : 0);
        result = 31 * result + (callPrices != null ? callPrices.hashCode() : 0);
        result = 31 * result + (parameters != null ? parameters.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\nTariff");
        sb.append("\nname='").append(name).append('\'');
        sb.append(", \nvendorCode='").append(vendorCode).append('\'');
        sb.append(", \nlocalDate=").append(localDate);
        sb.append(", \npayroll=").append(payroll);
        sb.append(", \nsmsPrice=").append(smsPrice);
        sb.append(", \noperatorName=").append(operatorName);
        sb.append(", \ncallPrices").append(callPrices);
        sb.append(", \nparameters").append(parameters);
        return sb.toString();
    }
}
