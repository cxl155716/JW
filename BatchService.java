package com.qdu.service;

import com.qdu.dao.BatchDAO;
import com.qdu.pojo.Batch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//事务的使用可以在dao层，也可以在Service层，建议在Service
//@Transactional:该注解用于指定事务，
//可以用在类之前，如果用在类前，说明该类中的所有方法使用该事务
//也可以用在方法前，说明事务使用在该方法中

@Service
public class BatchService{
 
    @Autowired
    private BatchDAO dao;
    
    @Transactional
    public Batch getBatchByName(String name) {
        return dao.getOneByName(name);
    }
    
    @Transactional
    public List getBatchList() {
        return dao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED,timeout = 10)
    public void addBatch(Batch batch) {
         dao.insert(batch);
    }
    
    @Transactional
    public void updateBatch(Batch batch) {
        dao.update(batch);
    }
    
    @Transactional
    public void deleteBatch(String name) {
        dao.deleteByName(name);
    }
    
    @Transactional
    public List getListByPageNumberAndSize(int pageNumber, int pageSize) {
        return dao.getListByPageNumberAndSize(pageNumber, pageSize);
    }

}