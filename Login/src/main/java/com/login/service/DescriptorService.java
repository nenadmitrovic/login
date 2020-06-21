/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.service;

import com.login.dao.DescriptorDao;
import com.login.domen.Descriptor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nenad
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class DescriptorService{

    @Autowired
    DescriptorDao descriptorDao;
   
    
    public List<Class> types(){
        List<Class> types = new ArrayList();
        types.add(String.class);
        types.add(Integer.class);
        types.add(Double.class);
        return types;
    }
    
    public void makeDescriptors(String mark, String name, String type, List<Descriptor> descriptors){
        Descriptor desc = new Descriptor();
        desc.setMark(mark);
        desc.setName(name);
        desc.setType(type);
        descriptors.add(desc);
        
    }
    
    public void saveDescriptors(List<Descriptor> descriptors, Integer documentId){
        descriptorDao.saveDescriptors(descriptors, documentId);
    }
    
    
    public List<Descriptor> getDescriptorsByDocument(Integer documentId){
        return descriptorDao.getDescriptorsByDocument(documentId);
    }
    
    public void deleteDescriptor(Integer id){
        descriptorDao.deleteDescriptor(id);
    }
    
    public void editDescriptor(Integer id, String mark, String name, String type){
        descriptorDao.editDescriptor(id, mark, name, type);
    }
    
    public Descriptor getById(Integer id){
        return descriptorDao.getById(id);
    }
    
    public void addDescriptor(String mark, String name, String type, Integer documentId){
        descriptorDao.addDescriptor(mark, name, type, documentId);
    }
    
    
   
    
    
}
