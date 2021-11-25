package stepDefinitions;

import java.util.List;

public class AddPlace {
	
	private int Accuracy;
	private String Address;
	private String Language;
	private String Phone_number;
	private String Website;
	private String name;
	private List<String> Types;
	private Location Location;
	
	public int getAccuracy() {
		return Accuracy;
	}
	public void setAccuracy(int accuracy) {
		Accuracy = accuracy;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getPhone_number() {
		return Phone_number;
	}
	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}
	public String getWebsite() {
		return Website;
	}
	public void setWebsite(String website) {
		Website = website;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTypes() {
		return Types;
	}
	public void setTypes(List<String> types) {
		Types = types;
	}
	public Location getLocation() {
		return Location;
	}
	public void setLocation(Location location) {
		Location = location;
	}
	
	
	

}
