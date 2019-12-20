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
                "Inner call price: %s%n External call price: %s%n Home call price: %s%n SMS price: %s ",
                innerCallPrice, externalCallPrice, homeCallPrice, smsPrice);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TariffPrices prices = (TariffPrices) obj;
        if (Double.compare(prices.innerCallPrice, innerCallPrice) != 0) {
            return false;
        }
        if (Double.compare(prices.externalCallPrice, externalCallPrice) != 0) {
            return false;
        }
        if (Double.compare(prices.homeCallPrice, homeCallPrice) != 0) {
            return false;
        }
        return Double.compare(prices.smsPrice, smsPrice) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(innerCallPrice);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(externalCallPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(homeCallPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(smsPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
