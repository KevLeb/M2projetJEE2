package fr.beans;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="projetjee2")
public class CV {

	@Id 
	@GeneratedValue
	private int id;
	
	@OneToMany
	Set<Activity> activities;
	
	public CV(){
		
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivitees(Set<Activity> activities) {
		this.activities = activities;
	}
}
