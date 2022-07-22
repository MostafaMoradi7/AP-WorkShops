package Workshop3.src.com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        String type = "";

        while (!type.equals("exit")){
            type = scanner.nextLine();
            if (type.equals("exit"))
                return;
            else if (type.contains("show")){
                if (!type.contains("-c") && !type.contains("-g")) {
                    int i = 0;
                    for (Contact x : phoneBook.getContacts()) {
                        ++i;
                        System.out.println("#" + i + " " + x.getFirstName() + " " + x.getLastName());
                    }
                }else if (type.contains("-c")){
                    type = type.substring(8);
                    String firstName = type.substring(0,type.indexOf(' '));
                    String lastName = type.substring(firstName.length()+1);
                    if (phoneBook.findContact(firstName,lastName)!= null)
                        System.out.println(phoneBook.findContact(firstName,lastName).toString());
                    else
                        System.out.println("Couldn't find contact!");
                }else {
                    String group = type.substring(type.indexOf('g')+2);
                    if (phoneBook.findContacts(group) == null){
                        System.out.println("No Groups Found!");
                        continue;
                    }
                    for (Contact x :
                            phoneBook.findContacts(group)) {
                        System.out.println(x.toString());
                    }
                }
            }else if (type.contains("contacts")){
                if (type.contains("-a")){
                    String [] order = type.split(" ",4);
                    String firstName = order[2];
                    String lastName = order[3];
                    String group,email,countryCode,phonenumber,zipCode,country,city;
                    System.out.println("Please enter contact's group: ");
                    group = scanner.nextLine();
                    if (group.equals(""))
                        group = null;
                    System.out.println("Please enter contact's email: ");
                    email = scanner.nextLine();
                    if (email.equals(""))
                        email = null;
                    System.out.println("Please enter contact's country code: ");
                    countryCode = scanner.nextLine();
                    if (countryCode.equals(""))
                        countryCode = null;
                    System.out.println("Please enter contact's phone number: ");
                    phonenumber = scanner.nextLine();
                    if (phonenumber.equals(""))
                        phonenumber = null;
                    System.out.println("Please enter contact's zip code: ");
                    zipCode = scanner.nextLine();
                    if (zipCode.equals(""))
                        zipCode = null;
                    System.out.println("Please enter contact's country: ");
                    country  = scanner.nextLine();
                    if (country.equals(""))
                        country = null;
                    System.out.println("Please enter contact's city: ");
                    city = scanner.nextLine();
                    if (city.equals(""))
                        city = null;

                    phoneBook.addContact(new Contact(group,email,firstName,lastName,new PhoneNumber(countryCode,phonenumber),new Address(zipCode,country,city)));
                    System.out.println("Contact saved!");
                }else {
                    String [] order = type.split(" ",4);
                    String firstName = order[2];
                    String lastName = order[3];
                    if (phoneBook.deleteContact(firstName,lastName))
                        System.out.println("Ok");
                    else
                        System.out.println("Not found");
                }
            }
        }
    }
}
