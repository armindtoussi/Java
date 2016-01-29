package ca.bcit.comp2526.a1c.a1a;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
            name2 = extract.next();

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
    private Main database;
    private int  choice;
    
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    
    public GUI() {
        
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void mainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        
        button1 = new JButton("button 1");
        button2 = new JButton("button 2");
        button3 = new JButton("button 3");
        button4 = new JButton("button 4");
        panel.add(button1, BorderLayout.NORTH);
        panel.add(button2, BorderLayout.WEST);
        panel.add(button3, BorderLayout.EAST);
        panel.add(button4, BorderLayout.SOUTH);
        
        
    }
    
    public void display(String[] people) {
        String msg = "";
        //displays passed people data
        for(int i = 0; i < people.length; i++) {
            
            //display persons to panel - to do 
        }
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
            break;
        case 5:
            System.exit(0);
            break;
            
        default:
            //should not get here.
          
            
        }
    }

    private void findPerson() {
        // TODO Auto-generated method stub
        
    }

    private void displayAll() {
        // TODO Auto-generated method stub
        
    }

    private void deletePerson() {
        // TODO Auto-generated method stub
        
    }

    private void addPerson() {
        // TODO Auto-generated method stub
        //need some kind of text box method to take in input 
        //for all of the previous 4 methods.
    }
    
    
    private void displayMenu(Graphics g) {
        
        
    }
    
    public void paint(Graphics g) {
        displayMenu(g);
    }
 
    public void displayMsg(String msg) {
        //setTitle(msg);
    }
    
    public void displayErrorMsg(String msg) {
        //show some kind of error in the main display panel
        //most likely things like incorrect input and so on
    }
    
    private void buttonPanel() {
        //create buttons for top panel 
        
    }
    
    private void mainDisplay() {
        //create main display Panel 

    } 
    
    private void inputTextBox() {
        //create the textbox for placement
    }
    
    private void createDisplayButton() {
        //create big display button
    }
    
    
    private class KeyBoardInput extends KeyAdapter {
     
        
        public void keyTyped (KeyEvent e) {
            
            try {
                choice = Integer.parseInt("" + e.getKeyChar());
                
            } catch (Exception except) {
                choice = -1;//result in nothing happening
                //may not need that for mouse input .
            }
            
            evaluateChoice();
            //calls choice thingy.
        }
    }
    
}





















