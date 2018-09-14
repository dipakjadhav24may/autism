package com.autism.AutismAppServer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autism.AutismAppServer.dao.ChildUserDao;
import com.autism.AutismAppServer.dao.ParentUserDao;
import com.autism.AutismAppServer.dto.ChildRegisterRequestDTO;
import com.autism.AutismAppServer.dto.ParentRegisterRequestDTO;
import com.autism.AutismAppServer.entity.ChildUser;
import com.autism.AutismAppServer.entity.ParentUser;

@Component
public class RegisterationService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ChildUserDao childUserDao;

	@Autowired
	ParentUserDao parentUserDao;

	public int registerParentUser(ParentRegisterRequestDTO parentRegisterRequestDTO) {
		int ret = 0;

		try {

			ParentUser parentUser = new ParentUser();
			parentUser.setFirstName(parentRegisterRequestDTO.getFirstName());
			parentUser.setLastName(parentRegisterRequestDTO.getLastName());
			parentUser.setEmail(parentRegisterRequestDTO.getEmail());
			parentUser.setChildRelation(parentRegisterRequestDTO.getChildRelation());
			parentRegisterRequestDTO.getCountry();
			parentUser.setGender(parentRegisterRequestDTO.getGender());
			parentUser.setMobileNumber(parentRegisterRequestDTO.getMobileNumber());
			parentUser.setOccupation(parentRegisterRequestDTO.getOccupation());
			parentUser.setStatus(parentRegisterRequestDTO.getStatus());

			ParentUser createdUser = parentUserDao.save(parentUser);
			ret = createdUser.getParentUserId();
		} catch (Exception e) {
			logger.error("Exception registerUser", e);
			e.printStackTrace();
		}

		return ret;

	}

	public int registerChildUser(ChildRegisterRequestDTO childRegisterRequestDTO) {
		int ret = 0;

		try {

			ChildUser childUser = new ChildUser();
			childUser.setAge(childRegisterRequestDTO.getAge());
			childUser.setFirstName(childRegisterRequestDTO.getFirstName());
			childUser.setGender(childRegisterRequestDTO.getGender());
			childUser.setNote(childRegisterRequestDTO.getNote());
			childUser.setStatus(childRegisterRequestDTO.getStatus());

			ChildUser createdUser = childUserDao.save(childUser);
			ret = createdUser.getChildUserId();
		} catch (Exception e) {
			logger.error("Exception registerChildUser", e);
			e.printStackTrace();
		}

		return ret;

	}

}
