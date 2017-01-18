package fr.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema="projetjee2")
public class CV {

	@Id 
	@GeneratedValue
	@NotNull
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
