package com.example.springbootdemo.repositories.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author zhengweichao  2022-02-22 7:45 下午
 **/
@Data
@Entity
public class BrowseRecord {

    @Id
    private Integer id;

}
