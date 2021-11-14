package selenium_core.helpers.database_helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDbQuery //Help us to get the data from automation scripts
{
    //----------------------------------------------------------------------------------------------------------------||
    public String getOwnerName(int carId) throws SQLException, NumberFormatException
    {
        String ownerName = null;
        String dbQuery = "select Owner_name from Cars where ID=" + carId;
        ResultSet result = DatabaseHelper.getInstance().getResultSet(dbQuery);
        // ResultSet result = DatabaseHelper.getResultSet(dbQuery);
        while(result.next())
        {
            // number = Integer.parseInt(result.getString("Mobile_Number")); // if data int
            ownerName = result.getString("Owner_name"); // If data String
        }
        return ownerName;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public List<Car> getCar() throws SQLException
    {
        List<Car> dataPerson = new ArrayList<Car>();
        String dbQuery = "select * from Cars";
        ResultSet result = DatabaseHelper.getInstance().getResultSet(dbQuery);
        while(result.next())
        {
            Car car = new Car();
            car.setCarMark(result.getString("Car_mark"));
            car.setCarModel(result.getString("Car_model"));
            car.setCarYear(Integer.parseInt(result.getString("Car_year")));
            car.setCountry(result.getString("Country"));
            car.setOwnerName(result.getString("Owner_name"));

            dataPerson.add(car);
        }
        return dataPerson;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void main(String[] args) throws SQLException
    {
        ApplicationDbQuery applicationDBQuery = new ApplicationDbQuery();
        String name = applicationDBQuery.getOwnerName(2);
        System.out.println("The name is: " + name) ;

        List<Car> listOfData = applicationDBQuery.getCar();
        for(Car data: listOfData)
        {
            System.out.println("Car ID is: " + data.getId() + "| Car mark is: " + data.getCarMark()
                    + "|  Car model is: " + data.getCarModel() + "| Year is: " + data.getCarYear()
                    + "| Country is: " + data.getCountry()
                    + "|  Owner name is: " + data.getOwnerName());
        }
    //----------------------------------------------------------------------------------------------------------------||
    }
}
