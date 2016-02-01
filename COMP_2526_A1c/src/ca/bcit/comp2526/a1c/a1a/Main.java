package ca.bcit.comp2526.a1c.a1a;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 * Main.
 * 
 * @author your name here
 * @version
 */
public class Main {
    
    private String[] database;
    Scanner input;

    public Main() {
        database = new String[0];
        input = new Scanner(System.in);
    }
    
    public String[] getDatabase() {
        return database;
    }

    public void add(final String name) {
        String[] temp = new String[database.length + 1];
        System.arraycopy(database, 0, temp, 0, database.length);
        temp[database.length] = name;
        database = temp;
    }

    public int search(final String name) {
        String name2;

        for (int pos = 0; pos < database.length; pos++) {
            Scanner extract = new Scanner(database[pos]);
            name2 = extract.nextLine();

            if (name.compareToIgnoreCase(name2) == 0) {
                return pos;
            }
        }
        return -1;
    }

    public void display(int pos) {
        String name, phone;
        Scanner extract = new Scanner(database[pos]);
        name = extract.next();
        phone = extract.next();
        System.out.printf("%-20s%-15s\n", name, phone);
    }

    public void displayHeading() {
        String heading1 = "Name";
        String heading2 = "Phone";
        System.out.printf("%-20s%-15s\n", heading1, heading2);
    }

    public void displayAll() {
        displayHeading();
        for (int i = 0; i < database.length; i++) {
            display(i);
        }
    }

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

    public void displayMenu() {
        System.out.println("\n\n\n1) Add");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Display All");
        System.out.println("5) Exit\n");
    }

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
            if (choice > 0 && choice <= 5)
                done = true;
            else
                System.out.println("\nYour choice is incorrect, please try again");
        }
        return choice;
    }

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

    public void deletePerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e) {
        }
        if (!remove(name))
            System.out.println("Could not delete " + name);
        else
            System.out.println(name + " was deleted successfully");
    }

    public void findPerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e) {
        }
        int pos = search(name);
        if (pos >= 0) {
            displayHeading();
            display(pos);
        } else {
            System.out.println("No such person");
        }
    }

    public void run() {
        int choice = 0;
        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
            case 1:
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

    public static void main(String[] args) {
        GUI g = new GUI();
        g.run();
    }
}


@SuppressWarnings("serial")
class GUI extends JFrame {
    
    private Main    database;
    
    private int     choice;
    private JFrame  frame;
    private JPanel  panel;
    private JPanel  buttPanel;
    private JPanel  displayPanel;
    
    private JLabel  displayLabel;
    private JLabel  mainLabel;

    
    private JButton buttonOne;
    private JButton buttonTwo;
    private JButton buttonThree;
    private JButton buttonFour;
    
    private StringBuilder sb;
    
    public GUI() {
        frame = new JFrame("Address Book");
        
        mainPanel();
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 230);
        frame.setVisible(true);
        
        
        
    }
    
    public void mainPanel() {
        panel        = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        mainLabel = new JLabel("Welcome to your address book.");
        panel.add(mainLabel);
        
        //run methods to create components
        buttonPanel();
        
        mainDisplay();
        
        panel.add(displayPanel);
        panel.add(buttPanel);
    }
    
    public void display(String[] people) {
        String msg = "";
        //displays passed people data
        for(int i = 0; i < people.length; i++) {
            
            //display persons to panel - to do 
        }
    }
    
    public void displayHeader() {

        sb = new StringBuilder();
        
        String head1 = "Name";
        String head2 = "Phone";
        
        sb.append("<html>");
        sb.append("<table border=0>");
        sb.append("<thead>");
        sb.append("<tr>");
        sb.append("<th align='left'>" + head1 + "</th>");
        sb.append("<th align='right'>" + head2 + "</th>");
        sb.append("</thead>");
    }
    
    public String readName() {
        //prompt user for input on center display panel
        
        return "";
    }
    
    
    public String readPhone() {
        
        return "";
    }
    
    
    public String readPerson() {
        final String name;
        final String phone;
        final String person;
        
        name = readName();
        phone = readPhone();
        
        if(name == null || phone == null) {
            return null;
        }
        
        person = name + " " + phone;
        
        return person;
    }
    
    public void run() {
        database = new Main();
    }
    
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
    }

    private void findPerson(String person) {
        String[] people = database.getDatabase();
        
        int pos = database.search(person);
        System.out.println(pos);
        displayHeader();
        sb.append("<tr>");
        sb.append("<tr align='left'>" + people[pos] +  "</td>");
        sb.append("</tr>");
        tableFooter();
    }

    private void tableFooter() {
        sb.append("</table>");
        sb.append("</html>");
    }
    
    private void displayAll() {
        displayHeader();
        String[] people = database.getDatabase();
        String name   = "";
        String number = "";
        int length    = 0;
        
        for(int i = 0; i < people.length; i++) {
            length = people[i].length();
            for(int j = 0; j < length; j++) {
                Character character = people[i].charAt(j);
                if(!(Character.isDigit(character))) {
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

    private void deletePerson(String person) {
        System.out.println(person);
        if(person != null && person.length() > 0) {
            System.out.println(person);
            database.remove(person);
        }
        for(int i = 0; i < database.getDatabase().length; i++) {
            System.out.println(database.getDatabase()[i]);
        }
    }

    private void addPerson(String person) {
        if(person != null && person.length() > 0) {
            database.add(person);
        }
    }
    
    private void createPerson(String name) {
        String person = name;
        addPerson(person);
    }
    
    private String addPrompt() {
        return "Please enter person's name and number to add:";
    }
   
    
    private String removePrompt() {
        return "Please enter the person's name you wish to remove:";
    }
    
    private String findPrompt() {
        return "Please enter the name of the person to find:";
    }
    
    private void displayMenu(Graphics g) {
       
        
    }
    
    public void paint(Graphics g) {
        displayMenu(g);
    }
 
    public void displayMsg(String msg) {
        displayLabel.setText(msg);
    }
    
    public void displayErrorMsg(String msg) {
        displayLabel.setText(msg);
    }
    
    private void buttonPanel() {
        buttPanel    = new JPanel();
        buttPanel.setPreferredSize(new Dimension(350, 40));
        buttPanel.setBackground(Color.LIGHT_GRAY);
        buttPanel.setBorder(BorderFactory.createEtchedBorder());
        createDisplayButton();
        buttPanel.add(buttonOne);
        buttPanel.add(buttonTwo);
        buttPanel.add(buttonThree);
        buttPanel.add(buttonFour);

        
    }
    
    private void mainDisplay() {
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(350, 100));
        displayPanel.setBackground(Color.white);
        displayPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        displayLabel = new JLabel();
        displayLabel.setText("Please make a choice");
        displayPanel.add(displayLabel);
        
    } 
    
    
    private void createDisplayButton() {
        buttonOne   = new JButton("1.Add");
        buttonOne.addActionListener(new ButtonListener());

        buttonTwo   = new JButton("2.Remove");
        buttonTwo.addActionListener(new ButtonListener());
           
        buttonThree = new JButton("3.Find");
        buttonThree.addActionListener(new ButtonListener());
        
        buttonFour  = new JButton("4.Display");
        buttonFour.addActionListener(new ButtonListener());
       
    }
    
    
    private class KeyBoardInput extends KeyAdapter {
        private String enteredInput;
        
        public void keyTyped (KeyEvent e) {
                      
            try {
                choice = Integer.parseInt("" + e.getKeyChar());
                
            } catch (Exception except) {
                choice = -1;//result in nothing happening
                //may not need that for mouse input .
            }
            
            evaluateChoice();
        }
        
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String  name   = "";
          
            if(e.getActionCommand().equalsIgnoreCase("1.Add")) {
                name = JOptionPane.showInputDialog(addPrompt());
                createPerson(name);
                
            } else if(e.getActionCommand().equalsIgnoreCase("2.Remove")) {
                name = JOptionPane.showInputDialog(removePrompt());
                deletePerson(name);
                
            
            } else if(e.getActionCommand().equalsIgnoreCase("3.Find")) {
                name = JOptionPane.showInputDialog(findPrompt());
                findPerson(name);
                displayLabel.setText(sb.toString());
            
            } else if(e.getActionCommand().equalsIgnoreCase("4.Display")) {
                displayAll();
                displayLabel.setText(sb.toString());
            }
            
        }
      
        
    }
    
}





















