package by.siarhei.xml.entity;

public class Tariff {
    String operator;
    double payroll;
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

    @Override
    public String toString() {
        return String.format(
                "%n%nTariff [%s], by %s operator, with payroll %s. %nWiths prices:%n%s %nParameters: %n%s"
                , tariffName, operator, payroll, prices.toString(), parameters.toString());
    }
}
