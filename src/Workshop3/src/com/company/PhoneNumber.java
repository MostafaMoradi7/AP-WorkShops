package Workshop3.src.com.company;

public class PhoneNumber {
    private String countryCode;
    private String number;

    public PhoneNumber(String countryCode, String number){
        this.countryCode = countryCode;
        setNumber(number);
    }

    public void setNumber(String number){
        if (number == null)
            this.number = null;
        else {
            if (number.length() == 10)
                this.number = number;
            else
                System.out.println("number is NOT STANDARD");
        }
    }

    public String toString(){
    StringBuilder information = new StringBuilder();
    if (countryCode == null)
        information.append("UNKNOWN COUNTRY!, ");
    else
        information.append("+").append(countryCode);

    if (number == null)
        information.append("NO-NUMBER-ENTERED ");
    else
        information.append(number);

    return information.toString();
    }
}
