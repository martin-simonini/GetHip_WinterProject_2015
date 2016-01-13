package GETHIP.winter_project.models;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@XmlRootElement
@DatabaseTable(tableName="events")
public class Event {
	
	@DatabaseField(columnName = "name")
	private String name;
	
	@DatabaseField(columnName = "stroke")
	private String stroke; //IM is it's own stroke
	
	@DatabaseField(columnName = "distance")
	private int distance;
	
	@DatabaseField(columnName = "swimmer")
	private Users swimmer;
	
	@DatabaseField(columnName = "times")
	private ArrayList<Times> times;
	
	public Event(){
		
	}
	
	//getters
	public String getName(){
		return name;
	}
	public String getStoke(){
		return stroke;
	}
	public int getDistance(){
		return distance;
	}
	public Users getUser(){
		return swimmer;
	}
	public ArrayList<Times> getTimes(){
		return times;
	}
	
	//setters
	public void setName(String name){
		this.name = name;
	}
	public void setStroke(String stroke)
	{
		this.stroke = stroke;
	}
	public void setDistance(int distance){
		this.distance = distance;
	}
	public void setUser(Users swimmer){
		this.swimmer = swimmer;
	}
	
	public void setTimes(ArrayList<Times> times){
		this.times = times;
	}
	public void addTime(Times time){
		this.times.add(time);
	}
}
