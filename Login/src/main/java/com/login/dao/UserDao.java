
package com.login.dao;

import com.login.domen.Role;
import com.login.domen.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Autowired
    RoleDao roleDao;
    
            

                    
    public List<User> getUse(String chars){
         Session session = sessionFactory.getCurrentSession();
         Query query = session.createSQLQuery("SELECT * FROM users WHERE username LIKE '%"+chars+"%'");
         return query.list();
    }                
    
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User login(String username, String password){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (User) query.list().get(0);
        
    }
    
    
    
    
    // Ovde superadmin cuva user-a sa sve rolom
    public void save(String username, String password, String name, String surname, String email, Integer companyId, Integer roleId){
        Session session = sessionFactory.getCurrentSession();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setCompanyId(companyId);
        Role role = roleDao.getById(roleId);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoleCollection(roles);
        session.save(user); 
    }
    
    // Ovde default korisnik cuva user-a bez role
    public void saveUser(String username, String password, String name, String surname, String email, Integer companyId){
        Session session = sessionFactory.getCurrentSession();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setCompanyId(companyId);
        Role role = roleDao.getById(3);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoleCollection(roles);
        session.save(user);
    }
    
    public List<User> getAll(){
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createCriteria(User.class).list();
        return users;
    }
    
    public List<User> getByCompany(int companyId){
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.getNamedQuery("User.findByCompanyId").setInteger("companyId", companyId).list();
        return users;
    }
    
    public User getById(Integer userId){
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, userId);
        return user;
    }
    
    public void update(int userId, String username, String password, String name, String surname, String email, Integer companyId, Integer roleId){
        Session session = sessionFactory.getCurrentSession();
        User user = getById(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setCompanyId(companyId);
        Role role = roleDao.getById(roleId);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoleCollection(roles);
        session.update(user);
    }
    
    public void updateDefaultUser(Integer userId, String username, String password, String name, String surname, String email, Integer companyId){
        Session session = sessionFactory.getCurrentSession();
        User user = getById(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setCompanyId(companyId);
    }
    
    public void delete(Integer userId){
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, userId);
        List<Role> roles = (List<Role>) user.getRoleCollection();
        user.getRoleCollection().removeAll(roles);
        session.delete(user);
    }
    
    public User searchUser(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        return (User) query.list().get(0);
        
    }
    
    public List<User> findByPage(Integer page){
        int perpage = 3;
        Session session = sessionFactory.getCurrentSession();
        List<User> result = session.createQuery("from User").setFirstResult(page*perpage).setMaxResults(perpage).list();
        return result;
    }
    
    public Long pages(){
        return ((Double)Math.ceil((Long)sessionFactory.getCurrentSession().createQuery("select count(userId) from User").uniqueResult()/3.0)).longValue();
    }
    
    
    
    

}
