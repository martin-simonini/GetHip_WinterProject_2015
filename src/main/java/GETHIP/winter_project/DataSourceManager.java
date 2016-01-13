package GETHIP.winter_project;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import GETHIP.winter_project.DataSourceManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

public class DataSourceManager {

	private static DataSourceManager manager = new DataSourceManager();
	private static HashMap<String, Dao> daoMap = new HashMap<String, Dao>();
	private static ConnectionSource source;
	
	private DataSourceManager()
	{

	}
	
	public static DataSourceManager getInstance( ) {
		return manager;
	}
	
	protected static void addDao(Class daoClass) throws SQLException{
		daoMap.put(daoClass.getName(), DaoManager.createDao(source, daoClass));
	}
	
	public static Dao getDao(Class c){
		return daoMap.get(c.getName());
	}
	
	protected static void setConnectionSource(ConnectionSource s){
		source = s;
	}
	
}
