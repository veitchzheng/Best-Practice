package com.example.springbootdemo.service;

import com.example.springbootdemo.repositories.entity.BrowseRecord;
import com.example.springbootdemo.repositories.BrowseRecordDao;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author zhengweichao  2022-02-22 7:46 下午
 **/
@Service
public class BrowseRecordService {

    @Resource
    private BrowseRecordDao browseRecordDao;

    public List<BrowseRecord> findAll(){
        return browseRecordDao.findAll();
    }
}
