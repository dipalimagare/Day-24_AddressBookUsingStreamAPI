package addressBook;

public class Contact {
	 public String firstName;
	    public String lastName;
	    public String address;
	    public String city;
	    public String state;
	    public int zip;
	    public long phoneNo;
	    public String email;

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
	    public String getAddress() {
	        return address;
	    }
	    public void setAddress(String address) {
	        this.address = address;
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
	    public int getZip() {
	        return zip;
	    }
	    public void setZip(int zip) {
	        this.zip = zip;
	    }

	    public long getPhoneNo() {
	        return phoneNo;
	    }
	    public void setPhoneNo(long phoneNo) {
	        this.phoneNo = phoneNo;
	    }

	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }


	    public Contact(String f,String l,String a,String c,String s,int z,long p,String e) {
	        // TODO Auto-generated constructor stub
	        setFirstName(f);
	        setLastName(l);
	        setAddress(a);
	        setCity(c);
	        setState(s);
	        setZip(z);
	        setPhoneNo(p);
	        setEmail(e);
	    }


	    @Override
	    public String toString() {
	        return "Contact Details: "+firstName +" "+ lastName+ ", "+address+", "+city+", " +state+ ", "+zip+", "+ phoneNo + ", "+email+" ";
	    }
}

