/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.service;

import com.login.dao.CompanyDao;
import com.login.domen.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nenad
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class CompanyService {
    
    @Autowired
    CompanyDao companyDao;
    
    public List<Company> getAll(){
        List<Company> companies = companyDao.getAll();
        return companies;
    }
    
    public Company getById(Integer companyId){
        Company company = companyDao.getById(companyId);
        return company;
    }
    
    public void save(String name, String adress, String id_number){
        companyDao.save(name, adress, id_number);
    }
    
    public void update(int companyId, String name, String adress, String idNumber){
        companyDao.update(companyId, name, adress, idNumber);
    }
    public void delete(int companyId){
        companyDao.delete(companyId);
    }
    
    public Company search(String name){
        Company company = companyDao.search(name);
        return company;
    }
    
    public List<Company> findByPage(int page){
        return companyDao.findByPage(page);
    }
    
    public Long pages(){
        return companyDao.pages();
    }
    
}
