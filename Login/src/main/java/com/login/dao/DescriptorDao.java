/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.dao;

import com.login.domen.Descriptor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nenad
 */

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class DescriptorDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    
    public List<Descriptor> getDescriptorsByDocument(Integer documentId){
        Session session = sessionFactory.getCurrentSession();
        List<Descriptor> descriptors = session.getNamedQuery("Descriptor.findByDocumentId").setInteger("documentId", documentId).list();
        return descriptors;
    }
    
    public void saveDescriptors(List<Descriptor> descriptors, Integer documentId){
        Session session = sessionFactory.getCurrentSession();
        for(Descriptor d : descriptors){
            d.setDocumentId(documentId);
            session.save(d);
        }
        
    }
    
    public void deleteDescriptor(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Descriptor desc = (Descriptor) session.get(Descriptor.class, id);
        session.delete(desc);
    }
    
    public void editDescriptor(Integer id, String mark, String name, String type){
        Session session = sessionFactory.getCurrentSession();
        Descriptor descriptor = (Descriptor) session.get(Descriptor.class, id);
        descriptor.setMark(mark);
        descriptor.setName(name);
        descriptor.setType(type);
        session.saveOrUpdate(descriptor);
    }
    
    public Descriptor getById(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Descriptor desc = (Descriptor) session.get(Descriptor.class, id);
        return desc;
    }
    
    public void addDescriptor(String mark, String name, String type, Integer documentId){
        Session session = sessionFactory.getCurrentSession();
        Descriptor descriptor = new Descriptor();
        descriptor.setMark(mark);
        descriptor.setName(name);
        descriptor.setType(type);
        descriptor.setDocumentId(documentId);
        session.save(descriptor);
    }
    
    
   
    
}
