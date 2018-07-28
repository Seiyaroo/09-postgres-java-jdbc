import dbs.WorldDB;
import models.Country;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WorldDB db = new WorldDB();

        List<Country> countries = db.getAllCountries();
        for(Country country : countries) {
            System.out.println(country );
        }
    }
}
