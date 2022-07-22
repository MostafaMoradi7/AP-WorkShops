package Workshop3.src.com.company;

public class Address {
    private String zipCode;
    private String country;
    private String city;

    public Address(String zipCode, String country, String city){
        this.zipCode = zipCode;
        this.country = country;
        this.city = city;
    }

    public String toString(){
        /*
        IN THE FILE, THERE HAS BEEN NO INFORMATION SET
        ABOUT THE CITY!
        SO WE IMAGINE CITY CAN BE DEFINED OPTIONALLY.
         */
        StringBuilder information = new StringBuilder();
        if (zipCode == null)
            information.append("UNKNOWN-ZIPCODE, ");
        else
            information.append(zipCode).append(", ");


        if (country == null)
            information.append("UNKNOWN-COUNTRY, ");
        else
            information.append(country).append(", ");


        if (city == null)
            information.append("UNKNOWN-CITY");
        else
            information.append(city);

        return information.toString();
    }
}
