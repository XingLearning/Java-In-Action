package com.xing.boot.rabbit.entity;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * UserRepository
 *
 * @author weixing
 * @date 2018/12/28 16:02
 */
public interface MqUserRepository extends JpaRepository<MqUser,Long> {
}
