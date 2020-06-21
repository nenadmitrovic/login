/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.service;

import com.login.dao.DocumentDao;
import com.login.domen.Document;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nenad
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class DocumentService {
    
    @Autowired
    DocumentDao documentDao;
    
    
    public void deleteDocument(Integer id){
        documentDao.deleteDocument(id);
    }
    
    
    public int saveDocument(String mark, String name, String description){
        
        return documentDao.saveDocument(mark, name, description);
    }
    
    public List<Document> getAll(){
        
        return documentDao.getAll();
    }
    
    
    public Document getById(Integer documentId){
        return documentDao.getById(documentId);
    }
    
    public void editDocument(Integer documentId, String mark, String name, String description){
        
        documentDao.editDocument(documentId, mark, name, description);
        
    }
}
