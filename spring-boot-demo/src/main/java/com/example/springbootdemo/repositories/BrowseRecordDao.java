package com.example.springbootdemo.repositories;

import com.example.springbootdemo.repositories.entity.BrowseRecord;
import javax.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhengweichao  2022-02-22 7:44 下午
 **/
@Table(name = "browse_record")
public interface BrowseRecordDao extends JpaRepository<BrowseRecord, Integer> {

}
