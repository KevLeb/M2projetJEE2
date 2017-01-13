package fr.services;

import javax.ejb.Remote;

import fr.beans.Activity;

@Remote
public interface ActivitySCRUD {

	public void searchActivity(Activity a);
	public void createActivity(Activity a);
	public void readActivity(Activity a);
	public void updateActivity(Activity a);
	public void deleteActivity(Activity a);
	
}
