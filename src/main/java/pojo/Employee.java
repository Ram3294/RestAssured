package pojo;

public class Employee {

	/*
	 * 
{
"firstname": "anuja",
"lastname": "Pandit",
"city": "Mumbai",
"mobilenumber": 8888,
"email": "anuja2@gmail.com"
}
	 */
	
	String firstname;
	String	lastname;
	String city;
	int		mobilenumber;
	String	email;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(int mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
