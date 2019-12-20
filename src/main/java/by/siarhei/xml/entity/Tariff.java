package by.siarhei.xml.entity;

public class Tariff {
    String operator;
    double payroll;
    String launchDate;
    String tariffName;
    TariffPrices prices;
    TariffParameters parameters;

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTariffName() {
        return this.tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public double getPayroll() {
        return this.payroll;
    }

    public void setPayroll(double payrollPrice) {
        this.payroll = payrollPrice;
    }

    public TariffPrices getPrices() {
        return this.prices;
    }

    public void setPrices(TariffPrices prices) {
        this.prices = prices;
    }

    public TariffParameters getParameters() {
        return this.parameters;
    }

    public void setParameters(TariffParameters parameters) {
        this.parameters = parameters;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public String toString() {
        return String.format(
                "%n%nTariff [%s], by %s operator, with payroll %s. %nWiths prices:%n%s %nParameters: %n%s"
                , tariffName, operator, payroll, prices.toString(), parameters.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tariff tariff = (Tariff) obj;
        if (Double.compare(tariff.payroll, payroll) != 0) {
            return false;
        }
        if (operator != null ? !operator.equals(tariff.operator) : tariff.operator != null) {
            return false;
        }
        if (launchDate != null ? !launchDate.equals(tariff.launchDate) : tariff.launchDate != null) {
            return false;
        }
        if (tariffName != null ? !tariffName.equals(tariff.tariffName) : tariff.tariffName != null) {
            return false;
        }
        if (prices != null ? !prices.equals(tariff.prices) : tariff.prices != null) {
            return false;
        }
        return parameters != null ? parameters.equals(tariff.parameters) : tariff.parameters == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = operator != null ? operator.hashCode() : 0;
        temp = Double.doubleToLongBits(payroll);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (launchDate != null ? launchDate.hashCode() : 0);
        result = 31 * result + (tariffName != null ? tariffName.hashCode() : 0);
        result = 31 * result + (prices != null ? prices.hashCode() : 0);
        result = 31 * result + (parameters != null ? parameters.hashCode() : 0);
        return result;
    }
}
