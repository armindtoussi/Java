package ca.bcit.comp2526.a1c.a1a;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Main.
 * 
 * @author Armin T. - A00942927 
 * @version Jan 28th, 2016 
 */
public class Main {
    
    /**the database where contact info is stored. */
    private String[] database;
    /* a scanner */
    Scanner input;

    /**
     * <p>creates a Main obj, instantiates scanner and database.</p>
     */
    public Main() {
        database = new String[0];
        input = new Scanner(System.in);
    }
    
    /**
     * <p>gets the database.</p>
     * @return an array - the database 
     */
    public String[] getDatabase() {
        return database;
    }

    /**
     * <p>Adds a person to the database.</p>
     * @param name person to be added
     */
    public void add(final String name) {
        String[] temp = new String[database.length + 1];
        System.arraycopy(database, 0, temp, 0, database.length);
        temp[database.length] = name;
        database = temp;
    }

    /**
     * <p>searches the database for a single person.</p>
     * @param name person to be found
     * @return the index of the person to be found
     */
    public int search(final String name) {
        String name2 = "";

        for (int pos = 0; pos < database.length; pos++) {
            Scanner extract = new Scanner(database[pos]);
            name2 = extract.nextLine();

            if (name.compareToIgnoreCase(name2) == 0) {
                return pos;
            }
        }
        return -1;
    }

    /**
     * <p>displays a single person.</p>
     * @param pos index of the person to be displayed
     */
    public void display(int pos) {
        String name;
        String phone;
        Scanner extract = new Scanner(database[pos]);
        name = extract.next();
        phone = extract.next();
        System.out.printf("%-20s%-15s\n", name, phone);
    }

    /**
     * <p>Displays the heading of the display table.</p>
     */
    public void displayHeading() {
        String heading1 = "Name";
        String heading2 = "Phone";
        System.out.printf("%-20s%-15s\n", heading1, heading2);
    }

    /**
     * <p>Displays all the database contents.</p>
     */
    public void displayAll() {
        displayHeading();
        for (int i = 0; i < database.length; i++) {
            display(i);
        }
    }

    /**
     * <p>Removes the person to deleted.</p>
     * @param name person to be deleted
     * @return the boolean result of the remove
     */
    public boolean remove(final String name) {
        int pos = search(name);
        if (pos >= 0) {
            String[] temp = new String[database.length - 1];
            System.arraycopy(database, 0, temp, 0, pos);
            System.arraycopy(database, pos + 1, temp, pos, database.length - pos - 1);
            database = temp;
            return true;
        }
        return false;
    }

    /**
     * <p>displays the whole user menu.</p>
     */
    public void displayMenu() {
        System.out.println("\n\n\n1) Add");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Display All");
        System.out.println("5) Exit\n");
    }

    /**
     * <p>gets the users input choice.</p>
     * @return the choice int
     */
    public int getChoice() {
        int choice = 4;// default
        boolean done = false;
        while (!done) {
            System.out.print("choice? ");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                // Ignore garbage input
            }
            if (choice > 0 && choice <= 5) {
                done = true;
            } else {
                System.out.println("\nYour choice is incorrect, please try again");
            }
        }
        return choice;
    }

    /**
     * <p>adds a person to the database.</p>
     */
    public void addPerson() {
        String name = "";
        String phone = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.print("\nEnter the persons phone number ");
            phone = input.next();
            System.out.println("");
        } catch (Exception e) {
            System.out.println("\nYour input is incorrect, please try again");
            return;
        }
        add(name + " " + phone);
    }

    /**
     * <p>Deletes a person from the database.</p>
     */
    public void deletePerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e) {
            e.getMessage();
        }
        if (!remove(name)) {
            System.out.println("Could not delete " + name);
        } else {
            System.out.println(name + " was deleted successfully");
        }
    }

    /**
     * <p>finds a person in the database.</p>
     */
    public void findPerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e) {
            e.getMessage();
        }
        int pos = search(name);
        if (pos >= 0) {
            displayHeading();
            display(pos);
        } else {
            System.out.println("No such person");
        }
    }

    /**
     * <p>runs the program.</p>
     */
    public void run() {
        int choice = 0;
        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
            case 1://same problem here with Checkstyle.
                addPerson();
                break;
            case 2:
                deletePerson();
                break;
            case 3:
                findPerson();
                break;
            case 4:
                displayAll();
            default:
                // should not get here
            }

        } while (choice != 5);
    }

    /**
     * <p>Entry to the program.</p>
     * @param args none
     */
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.run();
    }
}


/**
 * Gui class.ui
 * @author Armin T - A00942927
 */
class GUI extends JFrame {//Check style says i can't do this 
    //but it's the name of the class you gave us
    
    /**database is a Main obj.*/
    private Main    database;
    /**user choice. */
    private int     choice;
    /**main wimdow frame. */
    private JFrame  frame;
    /**main panel sits on frame. */
    private JPanel  panel;
    /**button panel. */
    private JPanel  buttPanel;
    /**main display panel. */
    private JPanel  displayPanel;
    
    /**label for writing to main display. */
    private JLabel  displayLabel;
    /**label for main panel.*/
    private JLabel  mainLabel;

    /**add button. */
    private JButton buttonOne;
    /**remove button.k */
    private JButton buttonTwo;
    /**find button. */
    private JButton buttonThree;
    /**display all button. */
    private JButton buttonFour;
       
    /**string builder for html table display.*/
    private StringBuilder sb;
    
    /**
     * <p>Main gui class.</p>
     */
    public GUI() {
        frame = new JFrame("Address Book");
        
        mainPanel();
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 380);
        frame.setVisible(true);   
    }
    
    /**
     * <p>constructs the gui and adds it to main panel.</p>
     */
    public void mainPanel() {
        panel        = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        
        mainLabel = new JLabel("Welcome to your address book.");
        mainLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        panel.add(mainLabel);
        
        //run methods to create components
        buttonPanel();
        
        mainDisplay();
        
        panel.add(displayPanel);
        panel.add(buttPanel);
    }
    
    /**
     * <p>scroll panel for main display label.</p>
     */
    public void makeScrollPane() {
        
        
    }
    
    /**
     * <p>builds the display label header for displaying people.</p>
     */
    public void displayHeader() {

        sb = new StringBuilder();
        
        String head1 = "Name";
        String head2 = "Phone";
        
        
        sb.append("<html>");
        sb.append("<table table-border=1>");
        sb.append("<thead>");
        sb.append("<tr>");
        sb.append("<th align='left'>" + head1 + "</th>");
        sb.append("<th align='right'>" + head2 + "</th>");
        sb.append("</thead>");
    }
    
    /**
     * <p>run creates the Main object. </p>
     */
    public void run() {
        database = new Main();
    }
    
    
    /*
    private void evaluateChoice() {
        
        switch (choice) {
        case 1: 
           // addPerson();
            break;
        case 2: 
            //deletePerson();
            break;
        case 3:
            //findPerson();
            break;
        case 4: 
            displayAll();
            break;
        case 5:
            System.exit(0);
            break;
            
        default:
            //should not get here.
          
            
        }
    }*/

    /**
     * <p>finds a person.</p>
     * @param person to find
     */
    private void findPerson(String person) {
        final String[] people = database.getDatabase();
        
        int pos = 0;
        try {
            pos = database.search(person);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            //none
        }
            
        displayHeader();
        sb.append("<tr>");
        sb.append("<tr align='left'>" + people[pos] +  "</td>");
        sb.append("</tr>");
        tableFooter();
    }

    /**
     * <p>footer for the display html table.</p>
     */
    private void tableFooter() {
        sb.append("</table>");
        sb.append("</html>");
    }
    
    /**
     * <p>displays all people in the database.</p>
     */
    private void displayAll() {
        displayHeader();
        String[] people = database.getDatabase();
        String name   = "";
        String number = "";
        int length    = 0;
        
        
        for (int i = 0; i < people.length; i++) {
            length = people[i].length();
            for (int j = 0; j < length; j++) {
                Character character = people[i].charAt(j);
                if (!(Character.isDigit(character))) {
                    name += character;
                } else {
                    number += character;
                }
            }
            sb.append("<tr>");
            sb.append("<td align='left'> " + name + "</td>");
            sb.append("<td align='right'> " + number + "</td>");
            sb.append("</tr>");
            name = "";
            number = "";
        }
        
        tableFooter();
    
    }

    /**
     * <p>removes a person from the database.</p>
     * @param person to be removed
     */
    private void deletePerson(String person) {
        System.out.println(person);
        if (person != null && person.length() > 0) {
            System.out.println(person);
            try {
                database.remove(person);
            } catch (Exception e) {
                e.getMessage();
                displayErrorMsg("Unable to remove person.");
            } finally {
                //none
            }
        }
        for (int i = 0; i < database.getDatabase().length; i++) {
            System.out.println(database.getDatabase()[i]);
        }
    }
    
    /**
     * <p>adds a person to the database.</p>
     * @param person to be added
     */
    private void addPerson(String person) {
        if (person != null && person.length() > 0) {
            database.add(person);
        }
    }
    
    /**
     * <p>creates a person to enter to database.</p>
     * @param name person to be created
     */
    private void createPerson(String name) {
        String person = name;
        try {
            addPerson(person);
        } catch (Exception e) {
            e.getMessage();
            displayErrorMsg("Problem adding the person to the database.");
        } finally {
            // none
        }
            
    }
    
    /**
     * <p>text to prompt adding a person.</p>
     * @return message to add person
     */
    private String addPrompt() {
        return "Please enter person's name and number to add:";
    }
   
    /**
     * <p>text to prompt remove a person.</p>
     * @return message to remove person
     */
    private String removePrompt() {
        return "Please enter the person's name you wish to remove:";
    }
    
    /**
     * <p>text to prompt find a person.</p>
     * @return message to find person
     */
    private String findPrompt() {
        return "Please enter the name of the person to find:";
    }
    
    //may remove will comment after.
    private void displayMenu(Graphics grap) {
       
        
    }
    
    //may remove, will comment after.
    public void paint(Graphics grap) {
        displayMenu(grap);
    }
 
    /**
     * <p>displays a message on the display panel.</p>
     * @param msg to be displayed
     */
    public void displayMsg(String msg) {
        displayLabel.setText(msg);
    }
    
    /**
     * <p>displays an error message on main display panel.</p>
     * @param msg to be displayed.
     */
    public void displayErrorMsg(String msg) {
        displayLabel.setText(msg);
    }
    
    /**
     * <p>Creates the main button panel.</p>
     */
    private void buttonPanel() {
        buttPanel    = new JPanel();
        buttPanel.setPreferredSize(new Dimension(350, 40));
        buttPanel.setBackground(Color.LIGHT_GRAY);
        buttPanel.setBorder(BorderFactory.createEtchedBorder());
        
        //create and add buttons
        createDisplayButton();
        buttPanel.add(buttonOne);
        buttPanel.add(buttonTwo);
        buttPanel.add(buttonThree);
        buttPanel.add(buttonFour);

        
    }
    
    /**
     * <p>creates the main display panel.</p>
     */
    private void mainDisplay() {
        
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(350, 250));
        displayPanel.setBackground(Color.white);
        displayPanel.setBorder(BorderFactory
                .createLoweredSoftBevelBorder());
        
        //add panels to main display
        createDisplayLabel();
        displayPanel.add(displayLabel);
        
    } 
    
    /**
     * <p>creates the display label for main display.</p>
     */
    private void createDisplayLabel() {
        displayLabel = new JLabel();
        displayLabel.setFont(new Font("Arial", Font.BOLD, 16));
        displayErrorMsg("Please make a choice:");
    }
    
    /**
     * <p>Creates the buttons for display.</p>
     */
    private void createDisplayButton() {
        buttonOne   = new JButton("1.Add");
        buttonOne.addActionListener(new ButtonListener());

        buttonTwo   = new JButton("2.Remove");
        buttonTwo.addActionListener(new ButtonListener());
           
        buttonThree = new JButton("3.Find");
        buttonThree.addActionListener(new ButtonListener());
        
        buttonFour  = new JButton("4.Display All");
        buttonFour.addActionListener(new ButtonListener());
       
    }
    
    /**
     * <p>Keyboard input listener.</p>
     * @author Armin T - A00942927
     *
     */
    private class KeyBoardInput extends KeyAdapter {
        /**the key that's pressed.*/
        private String enteredInput;
        
        /**
         * <p>handles the key typed event.</p>
         */
        public void keyTyped(KeyEvent event) {
                      
            try {
                choice = Integer.parseInt("" + event.getKeyChar());
                
            } catch (Exception except) {
                choice = -1;//result in nothing happening
                //may not need that for mouse input .
            }
            
            //evaluateChoice();
        }
        
    }

    /**
     * <p>button listener class for buttons.</p>
     * @author Armin T
     *
     */
    private class ButtonListener implements ActionListener {

        /**
         * <p>handles action event.</p>
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            String  name   = "";
          
            if (event.getActionCommand()
                    .equalsIgnoreCase("1.Add")) {
                name = JOptionPane.showInputDialog(addPrompt());
                try {
                    createPerson(name);
                } catch (Exception ex) {
                    ex.getMessage();
                } finally {
                    if (name == null || name.length() < 0) {
                        displayErrorMsg("Invalid entry, enter a name.");
                        
                    }
                }
                
            } else if (event.getActionCommand()
                    .equalsIgnoreCase("2.Remove")) {
                name = JOptionPane.showInputDialog(removePrompt());
                try {
                    deletePerson(name);
                } catch (Exception ex) {
                    ex.getMessage();
                } finally {
                    if (name == null || name.length() < 0) {
                        displayErrorMsg("Invalid entry, enter a name.");
                        
                    }
                }
            
            } else if (event.getActionCommand()
                    .equalsIgnoreCase("3.Find")) {
                name = JOptionPane.showInputDialog(findPrompt());
                try {
                    findPerson(name);
                    displayLabel.setText(sb.toString());
                } catch (Exception ex) {
                    ex.getMessage();
                } finally {
                    if (name == null || name.length() < 0) {
                        displayErrorMsg("Invalid entry, enter a name.");
                        
                    }
                }
                
            } else if (event.getActionCommand()
                    .equalsIgnoreCase("4.Display All")) {
                try {
                    displayAll();
                    displayLabel.setText(sb.toString());
                } catch (Exception ex) {
                    ex.getMessage();
                } finally {
                    //nothing to run
                }
            }       
        }    
    }
}





















