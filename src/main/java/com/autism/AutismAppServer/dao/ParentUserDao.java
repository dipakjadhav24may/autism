package com.autism.AutismAppServer.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.autism.AutismAppServer.entity.ParentUser;

@Transactional
public interface ParentUserDao extends CrudRepository<ParentUser, Integer> {

}
