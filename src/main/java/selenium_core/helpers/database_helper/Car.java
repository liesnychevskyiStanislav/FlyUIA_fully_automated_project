package selenium_core.helpers.database_helper;

public class Car
{
    private int id;
    private String car_mark;
    private String car_model;
    private int car_year;
    private String country;
    private String owner_name;


    public int getId()
    {
        return id;
    }

    public String getCarMark()
    {
        return car_mark;
    }

    public void setCarMark(String mark)
    {
        this.car_mark = mark;
    }

    public String getCarModel()
    {
        return car_model;
    }

    public void setCarModel(String model)
    {
        this.car_model = model;
    }

    public int getCarYear()
    {
        return car_year;
    }

    public void setCarYear(int year)
    {
        this.car_year = year;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getOwnerName()
    {
        return owner_name;
    }

    public void setOwnerName(String name)
    {
        this.owner_name = name;
    }
}
