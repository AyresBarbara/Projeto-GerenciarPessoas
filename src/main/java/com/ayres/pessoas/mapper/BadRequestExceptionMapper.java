package com.ayres.pessoas.mapper;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadRequestExceptionMapper extends ResponseStatusException {

	
	public BadRequestExceptionMapper(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }

}