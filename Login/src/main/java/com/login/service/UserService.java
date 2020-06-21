/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.service;

import com.login.dao.UserDao;
import com.login.domen.Role;
import com.login.domen.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nenad
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserService {
    
    @Autowired
    UserDao userDao;
    
    public List<User> getUse(String chars){
        return userDao.getUse(chars);
    }
    
    public User login(String username, String password){
        try{
            User user = userDao.login(username, password);
            if(username == null || password == null)
                throw new Exception("Ime i sifra ne moze biti null");
            return user;
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
        
    }
    
    public boolean isSuperAdmin(User user){
        if(user!=null){
            for(Role r : user.getRoleCollection() ){
                if(r.getName().equals("superadmin")){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isDefault(User user){
        if(user!=null){
            for(Role r : user.getRoleCollection()){
                if(r.getName().equals("default")){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isUser(User user){
        if(user!=null){
            for(Role r : user.getRoleCollection()){
                if(r.getName().equals("others"))
                    return true;
            }
        }
        return false;
    }
    
    public List<User> getByCompany(int companyId){
        List<User> users = userDao.getByCompany(companyId);
        return users;
    }
    
    public void save(String username, String password, String name, String surname, String email, Integer companyId, Integer roleId){
        userDao.save(username, password, name, surname, email, companyId, roleId);
    }
    
    public void update(Integer userId, String username, String password, String name, String surname, String email, Integer companyId, Integer roleId){
        userDao.update(userId, username, password, name, surname, email, companyId, roleId);
    }
    
    public User getById(int userId){
        User user = userDao.getById(userId);
        return user;
    }
    
     public void updateDefaultUser(Integer userId, String username, String password, String name, String surname, String email, Integer companyId){
         userDao.updateDefaultUser(userId, username, password, name, surname, email, companyId);
         
     }
     
     public void delete(Integer userId){
         userDao.delete(userId);
     }
     
     public List<User> getAll(){
         List<User> users = userDao.getAll();
         return users;
     }
     
     public User searchUser(String username){
         User user = userDao.searchUser(username);
         return user;
     }
     
     public void saveUser(String username, String password, String name, String surname, String email, Integer companyId){
         userDao.saveUser(username, password, name, surname, email, companyId);
     }
     
     public List<User> findByPage(Integer page){
        List<User> users =  userDao.findByPage(page);
        return users;
     }
     
     public Long pages(){
         
         return userDao.pages();
     }
}
