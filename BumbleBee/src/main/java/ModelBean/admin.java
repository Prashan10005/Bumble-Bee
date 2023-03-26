package ModelBean;


public class admin {
	public String fName;
	public String lName;
	public String nic;	
	public String email;
	public int mobile;
	public String password;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public admin(String fName, String lName, String nic, String email, int mobile, String password) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.nic = nic;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	public admin(String nic, String password) {
		super();
		this.nic = nic;
		this.password = password;
	}
	public admin(String nic) {
		super();
		this.nic = nic;
	}
	public admin() {
		super();
	}
	
	
}
