package Workshop3.src.com.company;

public class Contact {
    private String group;
    private String email;
    private String firstName;
    private String lastName;
    private PhoneNumber phoneNumber;
    private Address address;

    public Contact(String group, String email, String firstName, String lastName, PhoneNumber phoneNumber, Address address) {
        this.group = group;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    public String toString(){
        StringBuilder information = new StringBuilder();
        information.append("Full Name: ").append(firstName).append(" ").append(lastName).append("\n");
        information.append("Groups: ");
        if (group == null)
            information.append("NO GROUPS! \n");
        else
            information.append(group).append("\n");

        information.append("Email: ");
        if (email == null)
            information.append("NO EMAILS!\n");
        else
            information.append(email).append("\n");

        if (phoneNumber == null)
            information.append("NO INFORMATION!, ");
        else
            information.append("Phone info: ").append(phoneNumber.toString()).append("\n");
        if (address == null)
            information.append("Address: ").append("NO ADDRESS!");
        else
            information.append("Address: ").append(address.toString()).append("\n");


        return information.toString();
    }
}
