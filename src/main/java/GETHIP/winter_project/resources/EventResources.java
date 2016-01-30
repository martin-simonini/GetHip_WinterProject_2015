package GETHIP.winter_project.resources;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import GETHIP.winter_project.DataSourceManager;
import GETHIP.winter_project.models.Event;
import GETHIP.winter_project.models.Users;

import com.j256.ormlite.dao.Dao;

public class EventResources {
	@GET
	@Produces("application/json")
	public Event getIt(@QueryParam("name") String name)
	{
		Event event = null;
		try{
			event = getDao().queryForId(name);
			if(event == null){
			}else{
				return event;
			}
		}catch(SQLException e){
			e.printStackTrace();

		}
		return event;
	}
	
	 @DELETE
	 @Produces("text/plain")
	 public String deleteEvent(@QueryParam("name") String name)
	 {
		 try{
			 int num = getDao().deleteById(name);
			 if(num == 1){
				 return "Delete successful";
			 }else{
				 return "Unable to delete";
			 }
		 }catch (SQLException e){
			 e.printStackTrace();
			 return "Error in SQL statement";
		 }
	 }
	 
	 @POST
	 @Produces("application/json")
	 @Consumes("application/json")
	 public Event createEvent(Event event)
	 {
		 try{
			 Event event1 = getDao().createIfNotExists(event);
			 if(event1 == null){
				 
			 }else{
				 return event1;
			 }
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 return null;
	 }
	 
	  @PUT
	  @Produces("application/json")
	  @Consumes("application/json")
	  public String updateUser(Event event)
	  {
		  try{
			  int num = getDao().update(event);
			  if(num == 1){
				  return "Update successful for Event "+ event.getName();
			  }else{
				  return "Could not update Event "+event.getName();
			  }
		  }catch(SQLException e){
			  e.printStackTrace();
			  return "There seems to be an error updating "+event.getName();
		  }
	  }
	  
	  private Dao<Event, String> getDao(){
	    	Dao<Event, String> dao = DataSourceManager.getInstance().getDao(Event.class);
	    	return dao;
	    }
}
