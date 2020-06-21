/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.dao;

import com.login.domen.Descriptor;
import com.login.domen.Document;
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
public class DocumentDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Autowired
    DescriptorDao descriptorDao;
    
    public void deleteDocument(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Document document = (Document) session.get(Document.class, id);
        session.delete(document);
        
    }
    
    public void editDocument(Integer documentId, String mark, String name, String description){
        Session session = sessionFactory.getCurrentSession();
        Document document = (Document) session.get(Document.class, documentId);
        document.setMark(mark);
        document.setName(name);
        document.setDescription(description);
        session.save(document);
        
    }
    
    
    
    
    public int saveDocument(String mark, String name, String description){
        
        Session session = sessionFactory.getCurrentSession();
        Document doc = new Document();
        doc.setMark(mark);
        doc.setName(name);
        doc.setDescription(description);
        Integer id = (Integer) session.save(doc);
        
        return id;
    }
    
    
    
    public List<Document> getAll(){
        Session session = sessionFactory.getCurrentSession();
        List<Document> documents = session.createCriteria(Document.class).list();
        return documents;
    }
    
    public Document getById(Integer documentId){
        Session session = sessionFactory.getCurrentSession();
        Document document = (Document) session.get(Document.class, documentId);
        return document;
    }
    
}
