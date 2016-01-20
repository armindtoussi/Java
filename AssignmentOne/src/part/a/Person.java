package part.a;

/**
 * <p>
 * Class Person is designed to store information of a person 
 * including name and phone number.
 * </p>
 * 
 * @author Armin T
 * @version v0.1 January 10, 2016
 *
 */
public class Person {
    
    /** NUM_LENGTH is a constant representing the length of a phone num.*/
    private static final int    NUM_LENGTH = 10;
    /** NUM_DASH is a String constant.  */
    private static final String NUM_DASH   = "-";

    /** phoneNum represent a Person's phone number as a string.*/
    private String phoneNum;
    /** firstName is a string representing a Person's first name. */
    private String firstName;
    /** middleName is a string representing a Person's middle name. */
    private String middleName;
    /** lastName is a String representing a Person's last name. */
    private String lastName;
    
    
    /**
     * <p>
     * Constructor, Person, creates a Person object by 
     * instantiating phoneNum, firstName, middleName, lastName.
     * </p>
     * @param phoneNum sets the Person's phone number.
     * @param firstName sets the Person's first name.
     * @param middleName sets the Person's middle name.
     * @param lastName sets the Person's last name.
     */
    public Person(String phoneNum, String firstName, 
            String middleName, String lastName) {
        this.setPhoneNum(phoneNum);
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
    }
    
    /**
     * <p>
     * Constructor, Person, creates a Person object by 
     * instantiating phoneNum, firstName, lastName.
     * </p>
     * @param phoneNum sets the Person's phone number.
     * @param firstName sets the Person's first name.
     * @param lastName sets the Person's last name.
     */
    public Person(String phoneNum, String firstName, String lastName) {
        this.setPhoneNum(phoneNum);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
    
    
    /**
     * <p>
     * Method, formatName() formats the Person's name 
     * so that the first letter is capital and the rest is
     * lower case and the full name is separated by delimiters.
     * </p>
     * @return a formatted full name.
     */
    public String formatName() {
        String temp = "";
        
        if (middleName != null)  {
            temp = firstName.substring(0, 1).toUpperCase() 
                    + firstName.substring(1).toLowerCase() + " " 
                    + middleName.substring(0, 1).toUpperCase()
                    + middleName.substring(1).toLowerCase() + " "
                    + lastName.substring(0, 1).toUpperCase()
                    + lastName.substring(1).toLowerCase();
        } else if (firstName != null && lastName != null)  {
            temp = firstName.substring(0, 1).toUpperCase()
                    + firstName.substring(1).toLowerCase() + " "
                    + lastName.substring(0, 1).toUpperCase()
                    + lastName.substring(1).toLowerCase();
        }
        
        return temp;
    }
    
    /**
     * <p>
     * Method, formatPhoneNum() takes the phone number string
     * and adds the formatting of a '-' character between the
     * sets of numbers.
     * </p>
     * @return formatted phone number as  String
     */
    public String formatPhoneNum() {
        String temp = "";
        if (phoneNum != null)  {
            temp = phoneNum.substring(0, 3) + NUM_DASH 
                    + phoneNum.substring(3, 6) + NUM_DASH
                    + phoneNum.substring(6);
        }    
        return temp;
        
    }
    
    /**
     * <p>
     * Setter, setLastName sets the lastName of the Person
     * if there is at least one character, and it is not 
     * null. 
     * </p>
     * @param lastName last Name of the Person you want to set
     */
    public void setLastName(String lastName) {
        if (lastName.length() > 0 && lastName != null) {
            this.lastName = lastName;
        }
    }
    
    /**
     * <p>
     * Getter, getLastName, retrieves and returns 
     * lastName, a Person's last name.
     * </p>
     * @return gets lastName of the Person.
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * <p>
     * Setter, setMiddleName sets the middle name of the 
     * person as long as the input is at least one character
     * and is not null. 
     * </p>
     * @param middleName sets the middle name
     */
    public void setMiddleName(String middleName) {
        if (middleName.length() > 0 && middleName != null)  {
            this.middleName = middleName;
        }
    }
    
    /**
     * <p>
     * Getter, getMiddleName retrieves and returns 
     * middleName, a Person's middle name.
     * </p>
     * @return gets a Person's middleName
     */
    public String getMiddleName() {
        return middleName;
    }
    
    /**
     * <p>
     * Setter, setFirstName sets the firstName param 
     * as long as it is not null and there is at least
     * one character denoting the name
     * </p>
     * @param firstName is the Person's first name.
     */
    public void setFirstName(String firstName) {
        if (firstName.length() > 0 && firstName != null) { 
            this.firstName = firstName;
        }
    }
     
    /**
     * <p>
     * Getter, getFirstName retrieves and returns 
     * the Person's first name.
     * </p>
     * @return gets Person's firstName.
     */
    public String getFirstName() {
        return firstName;
    }
    
    
    
    /**
     * <p>
     * Setter, setPhoneNum sets the phone number of the 
     * Person and adds dashes into the 9 digit number as 
     * is normal represented in everyday life.
     * </p>
     * @param phoneNum is the phone number of a Person.
     */
    public void setPhoneNum(String phoneNum) {
        if (phoneNum.length() == NUM_LENGTH && phoneNum != null)  {
            this.phoneNum = phoneNum;
        }
    }
    
    /**
     * <p>
     * Getter, getPhoneNumber returns the String value 
     * phoneNum.
     * </p>
     * @return phoneNum, as Person's phone number.
     */
    public String getPhoneNum() {
        return phoneNum;
    }
    
    
}









