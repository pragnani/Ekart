package com.ekart.app.model;

import java.util.Date;

 public interface IEntity {

	 void setLastUpdateOn(Date lastUpdateOn);

	 Date getLastUpdateOn();

	 Date getCreatedOn();

	 void setCreatedOn(Date createdOn);

}
