package com.autism.AutismAppServer.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.autism.AutismAppServer.dto.ChildRegisterRequestDTO;
import com.autism.AutismAppServer.dto.ParentRegisterRequestDTO;
import com.autism.AutismAppServer.dto.ResponseDTO;
import com.autism.AutismAppServer.service.RegisterationService;

@CrossOrigin
@RestController
@RequestMapping(value = "/autism")
public class RegisterationController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RegisterationService registerationService;

	@RequestMapping(value = "/parent/register", method = RequestMethod.POST)
	public ResponseEntity<Object> parentRegisterUser(HttpServletRequest request,
			@RequestBody ParentRegisterRequestDTO parentRegisterRequestDTO) {
		try {

			int id = registerationService.registerParentUser(parentRegisterRequestDTO);

			ResponseDTO responseDTO = new ResponseDTO();
			responseDTO.setId(id);
			responseDTO.setMessage("User Created Successfully");

			return new ResponseEntity<>(responseDTO, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception parentRegisterUser", ex);
			return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "/child/register", method = RequestMethod.POST)
	public ResponseEntity<Object> childRegisterUser(HttpServletRequest request,
			@RequestBody ChildRegisterRequestDTO childRegisterRequestDTO) {
		try {

			int id = registerationService.registerChildUser(childRegisterRequestDTO);
			ResponseDTO responseDTO = new ResponseDTO();
			responseDTO.setId(id);
			responseDTO.setMessage("User Created Successfully");

			return new ResponseEntity<>(responseDTO, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception childRegisterUser", ex);
			return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);

		}

	}

}
