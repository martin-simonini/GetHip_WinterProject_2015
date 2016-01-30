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
import GETHIP.winter_project.models.Users;
import com.j256.ormlite.dao.Dao;

@Path("/Users")
public class UsersResources {
	
	@GET
	@Produces("application/json")
	public Users getIt(@QueryParam("userId") String userId)
	{
		Users user = null;
		try{
			user = getDao().queryForId(userId);
			if(user == null){
			}else{
				return user;
			}
		}catch(SQLException e){
			e.printStackTrace();

		}
		return user;
	}
	
	 @DELETE
	 @Produces("text/plain")
	 public String deleteUser(@QueryParam("userId") String userId)
	 {
		 try{
			 int num = getDao().deleteById(userId);
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
	 public Users createUser(Users user)
	 {
		 try{
			 Users user1 = getDao().createIfNotExists(user);
			 if(user1 == null){
				 
			 }else{
				 return user1;
			 }
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 return null;
	 }
	 
	  @PUT
	  @Produces("application/json")
	  @Consumes("application/json")
	  public String updateUser(Users user)
	  {
		  try{
			  int num = getDao().update(user);
			  if(num == 1){
				  return "Update successful for User "+ user.getID();
			  }else{
				  return "Could not update User "+user.getID();
			  }
		  }catch(SQLException e){
			  e.printStackTrace();
			  return "There seems to be an error updating "+user.getID();
		  }
	  }
	  
	  private Dao<Users, String> getDao(){
	    	Dao<Users, String> dao = DataSourceManager.getInstance().getDao(Users.class);
	    	return dao;
	    }

}
