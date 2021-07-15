package com.comcast.interview.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comcast.interview.model.LcsStringObject;
import com.comcast.interview.model.LcsStringResponse;
import com.comcast.interview.service.LcsService;

@RestController
@RequestMapping("/lcs")
public class LcsController {
	
	@Autowired
	private LcsService lcsService;

	@PostMapping()
	public LcsStringResponse getLcs(@RequestBody @Valid LcsStringObject setOfStrings) {				
		return lcsService.validateLcs(setOfStrings);
	}
}
