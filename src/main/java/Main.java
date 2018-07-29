import dbs.WorldDB;
import models.City;
import models.Country;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        WorldDB db = new WorldDB();

        Scanner input = new Scanner(System.in);
        System.out.print("country code: ");
        String code = input.nextLine();

        for (City city : db.getCitiesInCountry(code)) {
            System.out.println(city);
        }
        System.out.println();

        System.out.println("All countries");
        List<Country> countries = db.getAllCountries();
        for(Country country : countries) {
            System.out.println("  " + country);
        }
        System.out.println();

        System.out.println("Population 1,000 - 10,000");
        countries = db.getCountriesBetweenPopulation(1_000, 10_000);
        for (Country country : countries) {
            System.out.println("  " + country);
        }
        System.out.println();

        System.out.println("Abandoned countries:");
        countries = db.getCountriesBelowPopulation(1);
        for (Country country : countries) {
            System.out.println("  " + country);
        }
        System.out.println();

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter Language: ");
        String lang = input.nextLine();

        List<Country> place = db.getCountryByLanguage(lang);
        for (Country country : place) {
            System.out.println(country.name);
        }
        System.out.println();
    }
}
