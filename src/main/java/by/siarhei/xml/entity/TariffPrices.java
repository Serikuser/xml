package by.siarhei.xml.entity;

public class TariffPrices {
    double innerCallPrice;
    double externalCallPrice;
    double homeCallPrice;
    double smsPrice;

    public void setInnerCallPrice(double innerCallPrice) {
        this.innerCallPrice = innerCallPrice;
    }

    public void setExternalCallPrice(double externalCallPrice) {
        this.externalCallPrice = externalCallPrice;
    }

    public void setHomeCallPrice(double homeCallPrice) {
        this.homeCallPrice = homeCallPrice;
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    @Override
    public String toString() {
        return String.format(
                "Inner call price: %s%nExternal call price: %s%nHome call price: %s%nSMS price: %s ",
                innerCallPrice, externalCallPrice, homeCallPrice, smsPrice);
    }
}
