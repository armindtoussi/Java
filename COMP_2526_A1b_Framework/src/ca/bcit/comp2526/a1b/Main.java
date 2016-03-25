package ca.bcit.comp2526.a1b;

/**
 * Main.
 * @author Armin T. - A00942927
 * @version v1.0 Jan 18, 2016 
 */
public class Main {
    
    /**
     * The main method drives the program.
     * @param args Command line args
     */
    public static void main(String[] args) {
        final UserInterface userInterface;
        final AddressBook book;

        // STEP ONE: Why is this generating a compiler error?
        //because userInterface is an interface Not a class.
        //so it would need to be implemented into CUI 
        userInterface = new ConsoleUserInterface();
        book = new AddressBook(userInterface);
        userInterface.run(book);
    }
}
