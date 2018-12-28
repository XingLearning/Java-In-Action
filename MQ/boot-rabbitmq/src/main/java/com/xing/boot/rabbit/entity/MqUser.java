package com.xing.boot.rabbit.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * User实体
 *
 * @author weixing
 * @date 2018/12/28 16:02
 */
@Data
@Entity
public class MqUser implements Serializable{

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String username;

    private String password;

    private String eamil;

}
