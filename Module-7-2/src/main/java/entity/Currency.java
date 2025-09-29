package entity;

public class Currency {
    private String abbreviation;
    private String code;
    private double rateToUSD;

    public Currency(String abbreviation, String code, double rateToUSD) {
        this.abbreviation = abbreviation;
        this.code = code;
        this.rateToUSD = rateToUSD;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRateToUSD() {
        return rateToUSD;
    }
    public void setRateToUSD(double rateToUSD) {
        this.rateToUSD = rateToUSD;
    }
}
