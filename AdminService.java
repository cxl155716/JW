package com.qdu.service;

import com.qdu.dao.AdminDAO;
import com.qdu.pojo.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//事务的使用可以在dao层，也可以在Service层，建议在Service
//@Transactional:该注解用于指定事务，
//可以用在类之前，如果用在类前，说明该类中的所有方法使用该事务
//也可以用在方法前，说明事务使用在该方法中

@Service
public class AdminService{
 
    @Autowired
    private AdminDAO dao;
    
    @Transactional
    public Administrator getAdminById(String id) {
        return dao.getOneById(id);
    }

    @Transactional
    public void updateAdmin(Administrator admin) {
        dao.update(admin);
    }

    @Transactional
    public Administrator validateLogin(String Id, String PSD) {
        Administrator s=dao.getOneById(Id);
        if(s!=null && s.getPassword().equals(PSD)){
            System.err.println("111111111111111111111111111111111111111111");
           return s;
        }else{
            System.err.println("22222222222222222222222222222222222222222");
            return null;
        }
    }
}
