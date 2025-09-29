package entity;

public class Currency {
    private String abbreviation;
    private String name;
    private double rateToUSD;

    public Currency(String abbreviation, String name, double rateToUSD) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setCode(String name) {
        this.name = name;
    }

    public double getRateToUSD() {
        return rateToUSD;
    }
    public void setRateToUSD(double rateToUSD) {
        this.rateToUSD = rateToUSD;
    }
}
