package edu.java.inheritance06;

public class User {
	
	// field
	private String userId;
	private String password;
	
	// constructor
	public User() {
		
	}
	
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	// getters & setters
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// toString() override: "User(userId=..., password=...)"
	@Override
	public String toString() {
		return String.format("User(userId=%s, password=%s)", this.userId, this.password);
	}
	
	// equals() override: 두 객체의 userId가 같으면 true, 그렇지 않으면 false
	// hashCode() override
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			User other = (User) obj;
			return (other.userId).equals(this.userId);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (userId == null ? 0 : userId.hashCode());
		return hash;
	}

}
