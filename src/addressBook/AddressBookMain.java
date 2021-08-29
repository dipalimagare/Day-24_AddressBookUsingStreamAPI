package addressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
public class AddressBookMain {

	static Scanner sc = new Scanner(System.in);
    private LinkedList<Contact> contactDetailsList;


    private AddressBookMain() {
        contactDetailsList = new LinkedList<>();
    }


    private void addContact(int addressBookNum) {
        System.out.print("Enter the number of entry in Address Book:: " + addressBookNum);
        int numOfEntries = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numOfEntries; i++) {
            String firstName, lastName;
            int flag = 0;
            do {
                int counter = 0;
                System.out.println("First Name: ");
                firstName = sc.nextLine();
                System.out.println("Last Name: ");
                lastName = sc.nextLine();
                final String first = firstName;
                final String last = lastName;
                if(contactDetailsList.stream().anyMatch(n->n.getFirstName().equals(first)) && contactDetailsList.stream().anyMatch(n->n.getLastName().equals(last)))
                {
                    counter++;
                }
                if (counter != 0) {
                    System.out.println("This name already exists! Please enter again");
                    flag = 0;
                } else
                    flag = 1;
            } while (flag == 0);
            System.out.println("Address: ");
            String address = sc.nextLine();
            System.out.println("City: ");
            String city = sc.nextLine();
            System.out.println("State: ");
            String state = sc.nextLine();
            System.out.println("ZIP: ");
            int zip = sc.nextInt();
            System.out.println("Phone No: ");
            long phoneNo = sc.nextLong();
            sc.nextLine();
            System.out.println("Email ID: ");
            String emailId = sc.nextLine();
            Contact contactDetail = new Contact(city, state, emailId, address, lastName, zip, phoneNo, firstName);
            contactDetailsList.add(contactDetail);
        }
   
    }
    
    private static void editContact(Map<String, AddressBookMain> addressBookMap) {
        sc.nextLine();
        System.out.println("First Name of the person whose record is to be edited: ");
        String firstName = sc.nextLine();
        System.out.println("Last Name of the person whose record is to be edited: ");
        String lastName = sc.nextLine();
        System.out.println("New Address: ");
        String address = sc.nextLine();
        System.out.println("New City: ");
        String city = sc.nextLine();
        System.out.println("New State: ");
        String state = sc.nextLine();
        System.out.println("New ZIP: ");
        int zip = sc.nextInt();
        System.out.println("New Phone No: ");
        long phoneNo = sc.nextLong();
        sc.nextLine();
        System.out.println("Edited Email ID: ");
        String emailId = sc.nextLine();
        for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
            AddressBookMain value = entry.getValue();
            for (int i = 0; i < value.contactDetailsList.size(); i++)
                if (value.contactDetailsList.get(i).firstName.equals(firstName)
                        && value.contactDetailsList.get(i).lastName.equals(lastName)) {
                    Contact contactDetails = new Contact(city, state, emailId, address, lastName, zip, phoneNo, firstName);
                    value.contactDetailsList.set(i, contactDetails);
                    System.out.println("Edited the contact");
                }
        }
    }

    private static void searchContactDetails(Map<String, AddressBookMain> addressBookMap) {
        sc.nextLine();
        System.out.println("Enter First Name of person whose record is to be searched: ");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name of person whose record is to be searched: ");
        String lastName = sc.nextLine();
        int flag = 0;
        for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
            AddressBookMain value = entry.getValue();
            for (int i = 0; i < value.contactDetailsList.size(); i++)
                if (value.contactDetailsList.get(i).firstName.equals(firstName)&& value.contactDetailsList.get(i).lastName.equals(lastName))
                {
                    System.out.println(value.contactDetailsList.get(i));
                    flag = 1;
                    break;
                }
        }
        if (flag == 0) {
            System.out.println("No such record found");
        }
    }

    public static void deleteContactDetails(Map<String, AddressBookMain> addressBookMap) {
        sc.nextLine();
        System.out.println("Enter First Name of person whose record is to be deleted: ");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name of person whose record is to be deleted: ");
        String lastName = sc.nextLine();
        int flag = 0;
        for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
            AddressBookMain value = entry.getValue();
            for (int i = 0; i < value.contactDetailsList.size(); i++)
                if (value.contactDetailsList.get(i).firstName.equals(firstName)
                        && value.contactDetailsList.get(i).lastName.equals(lastName)) {
                    value.contactDetailsList.remove(i);
                    System.out.println("Deleted Contact");
                    flag = 1;
                }
        }
        if (flag == 0) {
            System.out.println("No such record found");
        }

    }

    private static void displayContactDetails(Map<String, AddressBookMain> addressBookMap) {
        for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
            AddressBookMain value = entry.getValue();
            for (int i = 0; i < value.contactDetailsList.size(); i++)
                System.out.println(value.contactDetailsList.get(i));
        }
    }

    private static void searchByCity(Map<String, AddressBookMain> addressBookMap) {
        sc.nextLine();
        System.out.println("Enter City of person whose record is to be searched: ");
        String city = sc.nextLine();
        int flag = 0;
        for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
            AddressBookMain value = entry.getValue();
            for (int i = 0; i < value.contactDetailsList.size(); i++)
                if (value.contactDetailsList.stream().anyMatch(n->n.getCity().equals(city))) {
                    System.out.println(value.contactDetailsList.get(i));
                    flag = 1;
                    break;
                }
        }
        if (flag == 0) {
            System.out.println("No such record found");
        }
    }

    private static void searchByState(Map<String, AddressBookMain> addressBookMap) {
        sc.nextLine();
        System.out.println("Enter state of person whose record is to be searched: ");
        String state = sc.nextLine();
        int flag = 0;
        for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
            AddressBookMain value = entry.getValue();
            for (int i = 0; i < value.contactDetailsList.size(); i++)
                if (value.contactDetailsList.stream().anyMatch(n->n.getState().equals(state))) {
                    System.out.println(value.contactDetailsList.get(i));
                    flag = 1;
                    break;
                }
        }
        if (flag == 0) {
            System.out.println("No such record found");
        }
    }
    
   
	public static void main(String[] args) {
        Map<String, AddressBookMain> addressBookMap = new HashMap<>();
        System.out.println("How many address books should be created? ");
        int noOfAddressBooks = sc.nextInt();
        sc.nextLine();
        
        AddressBookMain[] addressBookArray = new AddressBookMain[noOfAddressBooks];
        for (int i = 0; i < noOfAddressBooks; i++) {
            System.out.println("Enter name for Address Book " + (i + 1) + ": ");
            String addressBookName = sc.nextLine();
            addressBookArray[i] = new AddressBookMain();
            addressBookArray[i].addContact(i + 1);
            addressBookMap.put(addressBookName, addressBookArray[i]);
           
   //         Collections.sort(addressBookMain,SortbyName());
        } 
     

     
        int i = 1;
        while (i == 1) {
            System.out.println("Choose an option ");
            System.out.println("1. Edit Contact ");
            System.out.println("2. Delete Contact ");
            System.out.println("3. Search Contact ");
            System.out.println("4. Display Contact ");
            System.out.println("5. Search Contact by city ");
            System.out.println("6. Search Contact by state ");
            System.out.println("7. search contact by sortByCityStateOrZip");
            System.out.println("8. Exit ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    editContact(addressBookMap);
                    break;
                case 2:
                    deleteContactDetails(addressBookMap);
                    break;
                case 3:

                    break;
                case 4:
                    displayContactDetails(addressBookMap);
                    break;
                case 5:
                    searchByCity(addressBookMap);
                    break;
                case 6:
                    searchByState(addressBookMap);
                    break;
                default:
                    i = 0;
            }
        }

    }

}

