/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.service;

import com.login.dao.RoleDao;
import com.login.domen.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nenad
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class RoleService {
    
    @Autowired
    RoleDao roleDao;
    
    public List<Role> getAll(){
        List<Role> roles = roleDao.getAll();
        return roles;
    }
    
    
    
}
