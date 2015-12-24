package com.ekart.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractEntity implements IEntity {


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_ON", nullable = false)
	private Date lastUpdateOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON", nullable = false)
	private Date createdOn;

	public Date getLastUpdateOn() {
		return lastUpdateOn;
	}

	public void setLastUpdateOn(Date lastUpdateOn) {
		this.lastUpdateOn = lastUpdateOn;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	

}