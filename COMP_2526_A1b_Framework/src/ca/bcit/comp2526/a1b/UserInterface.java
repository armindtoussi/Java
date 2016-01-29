package ca.bcit.comp2526.a1b;

/**
 * UserInterface.
 * 
 * @author Armin T. - A00942927  
 * @version v1.0  Jan 19, 2016
 */
public interface UserInterface {

    void display(Person person);

    void displayAll(Person[] people);

    String readName();

    Person readPerson();

    void run(AddressBook book);

    void displayMsg(String msg);

    void displayErrorMsg(String msg);
}
