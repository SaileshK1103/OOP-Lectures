package dao;

import datasource.MariaDbConnection;
import entity.Currency;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {
    public List<Currency> getAllCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        String sql = "SELECT abbreviation, name, rate_to_USD FROM currency";

        try {
            Connection conn = MariaDbConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                currencies.add(new Currency(
                        rs.getString("abbreviation"),
                        rs.getString("name"),
                        rs.getDouble("rate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currencies;
    }
    public double getRateByAbbreviation(String abbreviation) {
        String sql = "SELECT rate_to_USD FROM currency WHERE abbreviation = ?";
        try(Connection conn = MariaDbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, abbreviation);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return  rs.getDouble("rate_to_USD");
            }
        }
        catch (SQLException e) {
            System.out.println("Error fetching rate: " + e.getMessage());
        }
        return -1;
    }
}
