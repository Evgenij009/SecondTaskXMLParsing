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
    public String toString() {
        final StringBuffer sb = new StringBuffer("\n");
        sb.append(" \tfeeConnection=").append(feeConnection);
        sb.append(",\n\tfavoriteNumber=").append(favoriteNumber);
        sb.append(", \n\ttariffication=").append(tariffication);
        return sb.toString();
    }
}
