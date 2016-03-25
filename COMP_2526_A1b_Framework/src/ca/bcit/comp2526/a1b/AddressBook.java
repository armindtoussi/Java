package ca.bcit.comp2526.a1b;

/**
 * AddressBook.
 * 
 * @author Armin T.    A00942927
 * @version v1.0  Jan 19, 2016
 */
public class AddressBook {
    /** database is the database of Person's. */
    private final Database database;
    /** userInterface is a userInterface object for interaction.  */
    private final UserInterface userInterface;

    /**
     * <p>Constructor for objects of type AddressBook.</p>
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

    /**
     * <p>Method remove attempts to remove a person by name.</p>
     * @param name the name of the person to find. and remove.
     * @return a true or false value indicating success or failure.
     */
    private boolean remove(final String name) {
        return (database.removeByName(name) != null);
    }

    /**
     * <p>Method search, takes a name param and uses findByName 
     *    method from database to find a person. and return it.</p>
     * @param name a string that represents a person.
     * @return returns a person if found.
     */
    private Person search(final String name) {
        return (database.findByName(name));
    }

    /**
     * <p>method displayAll passes an array of Person's to 
     *    ControlUserInterface's displayAll() method.</p>
     */
    public void displayAll() {
        Person[] people = database.getAll();
        userInterface.displayAll(people);
    }

    /**
     * <p>Method display calls display in Console user interface
     *    and passes a Person to it for display.</p>
     * @param person the person to display.
     */
    private void display(final Person person) {
        userInterface.display(person);
    }
}
