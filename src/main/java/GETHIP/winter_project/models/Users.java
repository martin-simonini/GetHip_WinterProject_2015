package GETHIP.winter_project.models;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="user")
public class Users {
	@DatabaseField(generatedId = true, columnName = "userId")
	private int userId;
	
	@DatabaseField(columnName = "first_name")
	private String firstName;
	
	@DatabaseField(columnName = "last_name")
	private String lastName;
	
	@DatabaseField(columnName = "birth_date")
	private Date birthDate;
	
	@DatabaseField(columnName = "gender")
	private String gender;
	
	@DatabaseField(columnName = "school")
	private String school;
	
	@DatabaseField(columnName = "location")
	private String location; //like what city or state that the user resides in
	
	@DatabaseField(columnName = "email")
	private String email;
	
		
	@DatabaseField(columnName = "events")
	private ArrayList<Event> event;
	
	public Users()
	{
		
	}
	
	//Getters
	public int getID(){
		return userId;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public Date getBirthgetDate(){
		return birthDate;
	}
	public String getGender(){
		return gender;
	}
	public String getSchool(){
		return school;
	}
	public String getLocation()
	{
		return location;
	}
	public String getEmail(){
		return email;
	}
	public ArrayList<Event> getEvents(){
		return event;
	}
	
	//setters
	public void setID(int userId){
		this.userId = userId;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public void setBirthDate(Date birthDate){
		this.birthDate = birthDate;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public void setSchool(String school){
		this.school = school;
	}
	public void setLocation(String location){
		this.location = location;
	}
	public void getEmail(String email){
		this.email = email;
	}
	public void setEvents(ArrayList<Event> events){
		this.event = events;
	}
	public void addEvent(Event event){
		this.event.add(event);
	}
}
