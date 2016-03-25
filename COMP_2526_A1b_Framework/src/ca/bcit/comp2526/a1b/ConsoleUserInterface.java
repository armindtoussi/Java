package ca.bcit.comp2526.a1b;

import java.util.Scanner;

/**
 * ConsoleUserInterface.
 * @author Armin T. - A00942927
 * @version v1.0 Jan 18, 2016
 */
public class ConsoleUserInterface implements UserInterface{
    
    /** input is a scanner for user input. */
    private final Scanner input;
    //removed addressBook variable because my program doesn't use it.

    /**
     * <p>Constructor for objects of type ConsoleUserInterface.</p>
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
    
    /**
     * <p>Method, display, displays the selected person.</p>
     * @param person is the person to be displayed.
     * @Override
     */
    public void display(Person person) {
        System.out.printf("%-20s %-15s\n", "Name", "Phone Number");
        System.out.println("---------------------------------");
        System.out.printf("%-20s %-15s\n", person.getName(), 
                                           person.getPhoneNumber());
    }

    
    /**
     * <p>Method displayAll displays all of the contents of the 
     *    database.</p>
     * @Override
     */
    public void displayAll(Person[] people) {
        System.out.printf("%-20s %-15s\n", "Name", "Phone Number");
        System.out.println("---------------------------------");
        for (Person person: people) {
            System.out.printf("%-20s %-15s\n", 
                    person.getName(), person.getPhoneNumber());
        }
        
    }

    
    /**
     * <p>Method readName is a method for reading in a 
     *    person's name into the database.</p>
     * @Override
     */
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

    
    /**
     * <p>Method run is the main program control function.</p>
     * @param book is an AddressBook object needed for the program.
     * @Override
     */
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

    
    /**
     * <p>Displays the specified message to the user.</p>
     * @Override
     * @param msg is the message to be displayed.
     */
    public void displayMsg(String msg) {
        System.out.println(msg);
    }

    /**
     * <p>Displays the specified error message.</p>
     * @param msg is the specified error message passed.
     * @Override
     */
    public void displayErrorMsg(String msg) {
        System.out.println(msg);
    }

    
}
