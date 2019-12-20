package by.siarhei.xml.entity;

public enum TariffEnum {
    TARIFFS("tariffs"),
    OPERATOR("operator"),
    PAYROLL("payroll"),
    LAUNCHDATE("launchDate"),
    TARIFF("tariff"),
    NAME("name"),
    INNERCALL("innerCall"),
    EXTERNALCALL("externalCall"),
    HOMECALL("homeCall"),
    SMS("sms"),
    ANNYNUMBER("annyNumber"),
    CONNECTIONPRICE("connectionPrice"),
    TARIFFING("tariffing"),
    PARAMETERS("parameters"),
    PRICES("prices");

    private String value;

    TariffEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
