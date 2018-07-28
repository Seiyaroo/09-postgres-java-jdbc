package dbs;

import models.City;
import models.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WorldDB {
    private static final String GET_ALL_COUNTRIES = "SELECT * FROM countries"

    private Connection conn;

    public WorldDB () {
        String url = "jdbc:postgresql://localhost:5432/world";
        Properties props = new Properties();
        // use these properties if you have to provide a username or PW
        //props.setProperty("user", "fred");
        //props.setProperty("password", "secret");
        //props.setProperty("ssl", "true");

        try {
            this.conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();

        try {
            Statement SQL = this.conn.createStatement()
            ResultSet results = sql.executeQuery("SELECT * FROM world")

            while (results.next()) {
                Country country = new Country();
                country.name = results.getString("name");
                country.countryCode = results.getString("code");
                country.population = results.getInt("population");
                countries.add(country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
    }
        return countries;
    }

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        return cities;
    }

    public List<City> getCitiesInCountry(Country country) {
        List<City> cities = new ArrayList<>();
        return cities;
    }
}
