package com.autism.AutismAppServer.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.autism.AutismAppServer.entity.ChildUser;

@Transactional
public interface ChildUserDao extends CrudRepository<ChildUser, Integer> {

}
