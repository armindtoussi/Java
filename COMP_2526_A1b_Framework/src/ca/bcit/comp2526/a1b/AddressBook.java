package ca.bcit.comp2526.a1b;

/**
 * AddressBook.
 * 
 * @author Armin T.    A00942927
 * @version v1.0  Jan 19, 2016
 */
public class AddressBook {
    private final Database database;
    private final UserInterface userInterface;

    /**
     * Constructor for objects of type AddressBook.
     * 
     * @param userInterface
     *            The user interface
     */
    public AddressBook(final UserInterface userInterface) {
        this.userInterface = userInterface;
        database = new Database();
    }

    /**
     * <p>Method addPerson() reads in a Person from ConsoleUserInterface
     * object using readPerson() method and adds it to the database 
     * arraylist.</p>
     */
    public void addPerson() {
        Person person = userInterface.readPerson();
        if (person != null) {
            database.add(person);
        }
    }

    /**
     * <p>Method deletePerson() deletes a user input person from the
     * database.</p>
     */
    public void deletePerson() {
        String name = "";
        
        try {
            name = userInterface.readName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (!remove(name)) {
            userInterface.displayErrorMsg("Unable to delete."); 
        } else {
            userInterface.displayMsg(name + " was deleted successfully");
        }
    }

    /**
     * <p>Method findPerson() finds a Person in the database.</p>
     */
    public void findPerson() {
        try {
            String name = userInterface.readName();
            if (name != null && name.length() > 0) {
                Person person = search(name);
                if (person != null) {
                    display(person);
                } else {
                    userInterface
                    .displayErrorMsg("No such person was found.");
                }
            } else {
                userInterface.displayErrorMsg("No such person found.");
            }
        } catch (Exception e)  {
            System.out.println(e.getMessage());
        }
        
    }

    private boolean remove(final String name) {
        return (database.removeByName(name) != null);
    }

    private Person search(final String name) {
        return (database.findByName(name));
    }

    public void displayAll() {
        Person[] people = database.getAll();
        userInterface.displayAll(people);
    }

    private void display(final Person person) {
        userInterface.display(person);
    }
}
