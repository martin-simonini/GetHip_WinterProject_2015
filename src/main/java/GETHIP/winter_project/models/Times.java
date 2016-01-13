package GETHIP.winter_project.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="times")
public class Times {
	
	@DatabaseField(columnName = "time")
	private String time;  //Min:sec:milli
	
	@DatabaseField(columnName = "event")
	private Event event;
	
	@DatabaseField(columnName = "swimmer")
	private Users user;
	
	@DatabaseField(columnName = "date")
	private Date date;
	
	public Times()
	{
		
	}
	
	//Getters
	public String getTime(){
		return time;
	}
	public Event getEvent(){
		return event;
	}
	public Users getUser(){
		return user;
	}
	public Date getDate(){
		return date;
	}
	
	//Setters
	public void setTime(String time){
		this.time = time;
	}
	public void setEvent(Event event){
		this.event = event;
	}
	public void setUser(Users user){
		this.user = user;
	}
	public void setDate(Date date){
		this.date = date;
	}

}
