package ca.bcit.comp2526.a1b;

import java.util.Scanner;

/**
 * ConsoleUserInterface.
 * @author your name here
 * @version
 */
public class ConsoleUserInterface implements UserInterface{
    private final Scanner input;
    private AddressBook addressBook;

    /**
     * Constructor for objects of type ConsoleUserInterface.
     */
    public ConsoleUserInterface() {
        input = new Scanner(System.in);
    }

    /**
     * <p>Method displayMenu() displays the menu 
     * of choices for the user to select.</p>
     */
    public void displayMenu() {
        System.out.println("\n\n\nWelcome to the Address book.");
        System.out.println("----------------------------\n");
        System.out.println("1) Add a person");
        System.out.println("2) Search");
        System.out.println("3) Remove");
        System.out.println("4) Display all");
        System.out.println("5) Exit");
        System.out.println("Please pick a number:");
        
    }
    
    /**
     * <p>Method readChoice() reads the user menu choice, called
     * by run displayMenu(), and passing result to run().</p>
     * @return an int which is the user menu choice
     */
    public int readChoice() {
        int choice = input.nextInt();
        
        return choice;
    }
    
    @Override
    public void display(Person person) {
        System.out.printf("%-20s %-15s\n", "Name", "Phone Number");
        System.out.println("---------------------------------");
        System.out.printf("%-20s %-15s\n", person.getName(), 
                                           person.getPhoneNumber());
    }

    @Override
    public void displayAll(Person[] people) {
        System.out.printf("%-20s %-15s\n", "Name", "Phone Number");
        System.out.println("---------------------------------");
        for (Person person: people) {
            System.out.printf("%-20s %-15s\n", 
                    person.getName(), person.getPhoneNumber());
        }
        
    }

    @Override
    public String readName() {
        System.out.println("Please enter the person's first name:");
        String name = input.next();
        System.out.println("Please enter the person's last name:");
        name = name + " " + input.next(); 
        System.out.println(name);
        return name;
    }

    /**
     * <p>Method readPerson() reads a person's name from readName()
     * method, and phone number from the console. It then creates and 
     * passes a person object back to addPerson().</p>
     * @return a person to addPerson to be added to database.
     */
    @Override
    public Person readPerson() {
        String name = readName();
        System.out.println("Please enter the person's phone number:");
        String phone;
        
        phone = input.next();
            
        Person person = new Person(name, phone);
        
        return person;
    }

    @Override
    public void run(AddressBook book) {
        int choice = 0;
        do {
            displayMenu();
            choice = readChoice();
            switch (choice) {
              case 1:
                  book.addPerson();
                  break;
              case 2: 
                  book.findPerson();
                  break;
              case 3:
                  book.deletePerson();
                  break;
              case 4:
                  book.displayAll();
                  break;
              default:
                  //should never reach this block
            } 
        } while (choice != 5);
    }

    @Override
    public void displayMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void displayErrorMsg(String msg) {
        System.out.println(msg);
    }

    
}
