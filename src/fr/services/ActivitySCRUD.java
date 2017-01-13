package fr.services;

import java.sql.SQLException;

import javax.ejb.Remote;

import fr.beans.Activity;

@Remote
public interface ActivitySCRUD {

	public void searchActivity(String search) throws SQLException;
	public void createActivity(Activity a)    throws SQLException;
	public Activity readActivity(Activity a)      throws SQLException;
	public void updateActivity(Activity a, String id)    throws SQLException;
	public void deleteActivity(Activity a)    throws SQLException;

}
