
package com.login.dao;

import com.login.domen.Company;
import com.login.domen.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class CompanyDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    public void save(String name, String adress, String id_number){
        Session session = sessionFactory.getCurrentSession();
        Company c = new Company();
        c.setName(name);
        c.setAdress(adress);
        c.setIdNumber(id_number);
        session.save(c);
        
    }
    
    public List<Company> getAll(){
        Session session = sessionFactory.getCurrentSession();
        List<Company> companies = session.createCriteria(Company.class).list();
        return companies;
    }
    public Company getById(int companyId){
        Session session = sessionFactory.getCurrentSession();
        return (Company) session.get(Company.class, companyId);
    }
    
    public void update(int companyId, String name, String adress, String idNumber){
        Session session = sessionFactory.getCurrentSession();
        Company company = getById(companyId);
        company.setName(name);
        company.setAdress(adress);
        company.setIdNumber(idNumber);
        session.update(company);
        
    }
    
    public void delete(int companyId){
        Session session = sessionFactory.getCurrentSession();
        Company company = (Company) session.get(Company.class, companyId);
        session.delete(company);
    }
    
   
    
    public Company search(String name){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT c FROM Company c WHERE c.name = :name");
        query.setParameter("name", name);
        return (Company) query.list().get(0);
       
    }
    
    public List<Company> findByPage(int page){
        int perpage = 3;
        Session session = sessionFactory.getCurrentSession();
        List<Company> result = session.createQuery("from Company").setFirstResult(page*perpage).setMaxResults(perpage).list();
        return result;
    }
    
    public Long pages(){
        return ((Double)Math.ceil((Long)sessionFactory.getCurrentSession().createQuery("select count(companyId) from Company").uniqueResult()/3.0)).longValue();
    }

}
