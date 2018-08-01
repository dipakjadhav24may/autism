package com.autism.AutismAppServer.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin
@RestController
@RequestMapping(value = "/organization")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header", defaultValue = "bearer ") })
	@RequestMapping(value = "/assumptions", method = RequestMethod.POST)
	public ResponseEntity<Object> createAssumptions(HttpServletRequest request) {
		try {

			return new ResponseEntity<>("Hello World", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception createAssumptions", ex);
			return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);

		}

	}

}
