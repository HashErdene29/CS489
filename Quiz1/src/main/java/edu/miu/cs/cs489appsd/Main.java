package edu.miu.cs.cs489appsd;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<EmailAddress> emailAddressList = new ArrayList<>();
        emailAddressList.add(new EmailAddress(111, "johnsmith@gmail.com", "Personal"));
        emailAddressList.add(new EmailAddress(112, "johnsmith@workemail.com", "Work"));

        List<EmailAddress> emailAddressList2 = new ArrayList<>();
        emailAddressList2.add(new EmailAddress(511, "lauraclint@gmail.com", "Personal"));

        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(121, 6412331234l, "Mobile"));

        List<PhoneNumber> phoneNumberList2 = new ArrayList<>();
        phoneNumberList2.add(new PhoneNumber(521, 6412334567l, "Mobile"));
        phoneNumberList2.add(new PhoneNumber(522, 8002331234l, "Work"));

        // CREATE
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact(1, "John", "Smith", "Technology", "Software Engineer", emailAddressList, phoneNumberList));
        contactList.add(new Contact(2, "Tom", "Clark", "Marketing", "Manager"));
        contactList.add(new Contact(3, "Tom", "Clark", "Marketing", "Manager"));
        contactList.add(new Contact(4, "Tom", "Clark", "Marketing", "Manager"));
        contactList.add(new Contact(5, "Laura", "Clint", "Communication", "Employee", emailAddressList2, phoneNumberList2));

//        Collections.sort(contactList, Comparator.comparing(Contact::getFirst_name));
        printContacts(contactList);
        // UPDATE
        updateContacts(contactList, 002);
        // DELETE
        deleteContacts(contactList, 003);
        // SEARCH
        findContact(contactList, 001);
        // MERGE
        mergeContact(contactList);
    }

    public static void printContacts(List<Contact> contactList){
        System.out.println("Printed in JSON format");
        System.out.println("[");
        JSONArray jsonArray = new JSONArray(contactList);
        for(int i =0; i < jsonArray.length(); i++){
            System.out.printf("\t" + "{  ");
            JSONObject innerobj = jsonArray.getJSONObject(i);
            for(Iterator it = innerobj.keys(); it.hasNext(); ){
                String key = (String) it.next();
                System.out.printf("'" + key + "'" + ":" + innerobj.get(key) + ",  ");
            }
            System.out.println("  }" );
        }
        System.out.println("]");
        System.out.println("--------------------------------------------");
    }

    public static void updateContacts (List<Contact> contactList, int contactId){
        System.out.println("Updated contact.");
        for(Contact c: contactList){
            if(c.getContact_id() == contactId){
                c.setFirst_name("Tom Updated");
                c.setLast_name("Clark Updated");

                System.out.printf("[" + "\t" + "{  ");
                JSONObject innerobj = new JSONObject(c);
                for(Iterator it = innerobj.keys(); it.hasNext(); ){
                    String key = (String) it.next();
                    System.out.printf("'" + key + "'" + ":" + innerobj.get(key) + ",  ");
                }
                System.out.println("  }    ]" );
                System.out.println("--------------------------------------------");
            }
        }

    }

    public static void deleteContacts(List<Contact> contactList, int contactId){
        Iterator<Contact> iterator = contactList.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getContact_id() == contactId) {
                iterator.remove();
                System.out.println("Contact with ID " + contactId + " has been removed.");
            }
        }
        System.out.println("[");
        JSONArray jsonArray = new JSONArray(contactList);
        for(int i =0; i < jsonArray.length(); i++){
            System.out.printf("\t" + "{  ");
            JSONObject innerobj = jsonArray.getJSONObject(i);
            for(Iterator it = innerobj.keys(); it.hasNext(); ){
                String key = (String) it.next();
                System.out.printf("'" + key + "'" + ":" + innerobj.get(key) + ",  ");
            }
            System.out.println("  }" );
        }
        System.out.println("]");
        System.out.println("--------------------------------------------");
    }

    public static void findContact(List<Contact> contactList, int contactId){
        System.out.println("Find contact with ID number 001.");
        for (Contact c: contactList){
            if(c.getContact_id() == contactId){
                JSONObject obj = new JSONObject(c);
                for(Iterator it = obj.keys(); it.hasNext(); ){
                    String key = (String) it.next();
                    System.out.printf("\t" + "{ '" + key + "'" + ":" + obj.get(key) + ",  }");
                }
            }
        }
        System.out.println("\n");
    }

    public static void mergeContact(List<Contact> contactList){
        System.out.println("Merge the duplicated contacts.");
        Set<String> uniqueNames = new HashSet<>();
        Iterator<Contact> iterator = contactList.iterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            String nameKey = contact.getFirst_name() + " " + contact.getLast_name();
            if (!uniqueNames.add(nameKey)) { // add() returns false if the set already contains the name
                iterator.remove(); // Remove the current contact if the name is already in the set
            }
        }
        System.out.println("[");
        JSONArray jsonArray = new JSONArray(contactList);
        for(int i =0; i < jsonArray.length(); i++){
            System.out.printf("\t" + "{  ");
            JSONObject innerobj = jsonArray.getJSONObject(i);
            for(Iterator it = innerobj.keys(); it.hasNext(); ){
                String key = (String) it.next();
                System.out.printf("'" + key + "'" + ":" + innerobj.get(key) + ",  ");
            }
            System.out.println("  }" );
        }
        System.out.println("]");
        System.out.println("--------------------------------------------");
    }
}