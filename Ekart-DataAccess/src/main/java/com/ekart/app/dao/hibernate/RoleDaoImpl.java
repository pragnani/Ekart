package com.ekart.app.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.ekart.app.dao.RoleDao;
import com.ekart.app.model.Role;

@Repository
public class RoleDaoImpl extends AbstractHbnDao<Role> implements RoleDao{

}
