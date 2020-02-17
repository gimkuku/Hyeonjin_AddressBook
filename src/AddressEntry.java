public class AddressEntry {

	private String firstName, lastName, street, city, state, phone, email ;
	private int zip;

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

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		
		return firstName +"\n"+ lastName+"\n"+ street+"\n"+ city+"\n"+ state+"\n"+ phone+"\n"+ email +"\n"+ String.valueOf(zip)+"\n"+"\n";
		
	}
}
