package by.siarhei.xml.entity;

public class TariffParameters {
    String tariffing;
    double annyNumberPrice;
    double connectionPrice;

    public TariffParameters() {
        tariffing = "minutes";
    }

    public void setAnnyNumberPrice(double annyNumberPrice) {
        this.annyNumberPrice = annyNumberPrice;
    }

    public void setConnectionPrice(double connectionPrice) {
        this.connectionPrice = connectionPrice;
    }

    public void setTariffing(String tariffing) {
        this.tariffing = tariffing;
    }

    @Override
    public String toString() {
        return String.format(
                "Tariffing is for: %s%n Anny number price: %s%n Connection price: %s",
                tariffing, annyNumberPrice, connectionPrice);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TariffParameters that = (TariffParameters) obj;
        if (Double.compare(that.annyNumberPrice, annyNumberPrice) != 0) {
            return false;
        }
        if (Double.compare(that.connectionPrice, connectionPrice) != 0) {
            return false;
        }
        return tariffing != null ? tariffing.equals(that.tariffing) : that.tariffing == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = tariffing != null ? tariffing.hashCode() : 0;
        temp = Double.doubleToLongBits(annyNumberPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(connectionPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
