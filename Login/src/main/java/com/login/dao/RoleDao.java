
package com.login.dao;

import com.login.domen.Role;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class RoleDao {
    
    @Autowired
    SessionFactory sessionFactory;

    
    public List<Role> getAll(){
        Session session = sessionFactory.getCurrentSession();
        List<Role> roles = session.createCriteria(Role.class).list();
        return roles;
    }
    
    public Role getById(Integer roleId){
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("SELECT r FROM Role r WHERE r.roleId = :roleId");
        query.setParameter("roleId", roleId);
        return (Role) query.list().get(0);
    } 
    
    
    
    
}
