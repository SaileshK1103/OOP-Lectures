package dao;

import datasource.MariaDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDao {
    public double getRateByAbbreviation(String abbreviation) {
        String sql = "SELECT rate FROM currencies WHERE abbreviation = ?";
        try(Connection conn = MariaDbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, abbreviation);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return  rs.getDouble("rate");
            }
        }
        catch (SQLException e) {
            System.out.println("Error fetching rate: " + e.getMessage());
        }
        return -1;
    }
}
