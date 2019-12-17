package by.siarhei.xml.entity;

public class TariffParameters {
    String tariffing;
    double annyNumberPrice;
    double connectionPrice;


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
                "Tariffing is for: %s%nAnny number price: %s%nConnection price: %s",
                tariffing, annyNumberPrice, connectionPrice);
    }
}
