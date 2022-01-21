package vn.shopthethao.Model;


public class UserModel {
	private int id;
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String gender;
	private String phone;
	private String email;
	private String address;
	int roleId;
	public UserModel(int id, String username, String password, String fname, String lname, String gender, String phone,
			String email, String address, int roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", roleId=" + roleId + "]";
	}
	public UserModel(String username, String password, String fname, String lname, String gender, String phone,
			String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	
}
