package by.epam.eugene.entity;

public class Parameters {
    private int favoriteNumber;
    private float feeConnection;
    private Tariffication tariffication;

    public Parameters() {
    }

    public Parameters(float feeConnection, int favoriteNumber, Tariffication tariffication) {
        this.favoriteNumber = favoriteNumber;
        this.feeConnection = feeConnection;
        this.tariffication = tariffication;
    }

    public void setFavoriteNumber(int favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public void setFeeConnection(float feeConnection) {
        this.feeConnection = feeConnection;
    }

    public void setTariffication(Tariffication tariffication) {
        this.tariffication = tariffication;
    }

    public int getFavoriteNumber() {
        return favoriteNumber;
    }

    public float getFeeConnection() {
        return feeConnection;
    }

    public Tariffication getTariffication() {
        return tariffication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parameters that = (Parameters) o;

        if (favoriteNumber != that.favoriteNumber) return false;
        if (Float.compare(that.feeConnection, feeConnection) != 0) return false;
        return tariffication == that.tariffication;
    }

    @Override
    public int hashCode() {
        int result = favoriteNumber;
        result = 31 * result + (feeConnection != +0.0f ? Float.floatToIntBits(feeConnection) : 0);
        result = 31 * result + (tariffication != null ? tariffication.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\n");
        sb.append(" \tfeeConnection=").append(feeConnection);
        sb.append(",\n\tfavoriteNumber=").append(favoriteNumber);
        sb.append(", \n\ttariffication=").append(tariffication);
        return sb.toString();
    }
}
