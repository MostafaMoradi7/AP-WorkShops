package Workshop3.src.com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class PhoneBook {
    private ArrayList<Contact> contacts;

    public PhoneBook(){
        contacts = new ArrayList<>();
    }
    public boolean addContact(Contact newContact){
        if (contacts.contains(newContact))
            return false;
        else
            contacts.add(newContact);
        return true;
    }
    public boolean deleteContact(String firstName, String lastName){
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(firstName) && contacts.get(i).getLastName().equals(lastName)) {
                contacts.remove(i);
                return true;
            }
        }
        return false;
    }
    public Contact findContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }
    public Contact[] findContacts(String group){
        ArrayList<Contact> sameGroupContacts = new ArrayList<Contact>();
        for (Contact x:contacts) {
            if (x.getGroup().equals(group))
                sameGroupContacts.add(x);
        }
        Contact[] result = new Contact[sameGroupContacts.size()];
        for (int i = 0; i < sameGroupContacts.size(); i++) {
            result[i] = sameGroupContacts.get(i);
        }
        return result;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void printContacts(){
        int i = 0;
        for (Contact x :
                contacts) {
            ++i;
            System.out.println("Contact #" + i);
            System.out.println(x.toString());
            System.out.println("    _____________________");
        }
    }
}
