
/**
 * @author Hyeonjin Kim
 * @version "%I%, %G%"
 */
	/**
	 * AddressEntry class, describes contents of a single AddressEntry for use in AddressBook
	 */
public class AddressEntry {

	private String firstName, lastName, street, city, state, phone, email ;
	private int zip;

	   /**
     * default Constructor
     */
	public AddressEntry(String firstName,String lastName,String street,String city, String state, String phone,String email, int zip) {
		setFirstName(firstName);
		setLastName(lastName);
		setCity(city);
		setState(state);
		setStreet(street);
		setPhone(phone);
		setZip(zip);
		setEmail(email);
	}

	 /**
     * Constructor allows for initialization of all AddressEntry fields
     * @param firstname    first name
     * @param lastname    last name
     * @param street   street name
     * @param city    city name
     * @param state   state name
     * @param zip    zip code
     * @param phone   phone number
     * @param email    email address
     */
	
	
	public String getFirstName() {
		return firstName;
	}
	/**
    *
    * @param firstname   first name
    */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	/**
    *
    * @param lastname   last name
    */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	/**
    *
    * @param city city
    */
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	/**
    *
    * @param state   state
    */
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	/**
    *
    * @param street   street
    */
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	/**
    *
    * @param phone   phone
    */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getZip() {
		return zip;
	}
	/**
    *
    * @param zip   zip
    */
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	/**
    *
    * @param email   email
    */
	public void setEmail(String email) {
		this.email = email;
	}
	
	  /**
     * @return data from this object as a neatly formatted String
     */
	public String toString() {
		
		return firstName +"\n"+ lastName+"\n"+ street+"\n"+ city+"\n"+ state+"\n"+ phone+"\n"+ email +"\n"+ String.valueOf(zip)+"\n"+"\n";
		
	}
}
