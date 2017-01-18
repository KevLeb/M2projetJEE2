package fr.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;


import fr.beans.Activity;
import fr.services.ActivitySCRUD;

@Stateless(name = "act", description = "Representation d'une activitee")
public class ActivitySCRUDImpl implements ActivitySCRUD{

	@Resource(name = "myDS")
	private DataSource ds;

	@Override
	public ArrayList<Activity> searchActivity(String search) throws SQLException {
		String query =  "SELECT * FROM Activity WHERE cv LIKE " + "'%"+ search + "%'" +
				" OR year LIKE " + "'%"+ search + "%'" +
				" OR nature    LIKE " + "'%"+ search + 
				" OR title LIKE " + "'%"+ search + "%'" +
				" OR website LIKE " + "'%"+ search + "%'" +"%' ORDER BY title";
		Connection c = ds.getConnection();
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		ArrayList<Activity> activities = new ArrayList<>();
		
		while (rs.next()) {
			Activity act = new Activity();
			
			//act.setCV(  rs.getInt(1) ); TODO a changer quand on aura réglé le pb pour l'id de cv dans une activité
			act.setNature(rs.getString(2));
			act.setTitle( rs.getString(3));
			act.setWebSite(rs.getString(4));
			act.setYear(rs.getInt(5));
			act.setDescription(rs.getString(6));
			activities.add(act);
		}
		
		return activities.size() == 0 ? null : activities;
	}

	@Override
	public void createActivity(Activity a) throws SQLException {
		String query = "INSERT INTO Activity (cv, nature, title, website, "
				+ "year, description) VALUES( ?, ?, ?, ?, ?, ?);";
		Connection c = ds.getConnection();
		PreparedStatement ps = c.prepareStatement(query);
		prepareQuery(ps, a.getCv(), a.getNature(), a.getTitle(), a.getWebSite(), a.getYear(), a.getDescription());
		ps.execute();
		//TODO mettre peut etre un ResultSet
	}

	@Override
	public Activity readActivity(Activity a) throws SQLException {
		String query =  "SELECT * FROM Activity WHERE cv="+a.getCv();
		Connection c = ds.getConnection();
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(query);

		if (! rs.next())
			return null;

		Activity act = new Activity();
		
		//act.setCV(  rs.getInt(1) ); TODO a changer quand on aura réglé le pb pour l'id de cv dans une activité
		act.setNature(rs.getString(2));
		act.setTitle( rs.getString(3));
		act.setWebSite(rs.getString(4));
		act.setYear(rs.getInt(5));
		act.setDescription(rs.getString(6));

		return act;
	}

	@Override
	public void updateActivity(Activity a, String id) throws SQLException {
		String query = "UPDATE personne SET cv = ?, nature = ?, title = ?, website = ? ,"
				+ "year = ?, description = ? " + " WHERE id = ?";
		Connection c = ds.getConnection();
		PreparedStatement ps = c.prepareStatement(query);
		prepareQuery(ps, a.getCv(), a.getNature(), a.getTitle(), a.getWebSite(), a.getYear(), a.getDescription(), id);
		ps.execute();
	}

	@Override
	public void deleteActivity(Activity a) throws SQLException {
		String query =  "DELETE FROM Activity WHERE cv="+a.getCv();
		Connection c = ds.getConnection();
		Statement st = c.createStatement();
		st.execute(query);

	}

	private void prepareQuery(PreparedStatement st, Object ... parameters) throws SQLException{
		for ( int i=0; i< parameters.length ; i++){
			if(parameters[i] instanceof String)
				st.setString(i+1, (String) parameters[i]);
			else if(parameters[i] instanceof Integer)
				st.setInt(i+1, (Integer) parameters[i]);
			else if(parameters[i] instanceof java.math.BigDecimal)
				st.setBigDecimal(i+1, (java.math.BigDecimal) parameters[i]);
		}
	}

}
