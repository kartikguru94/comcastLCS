package com.comcast.interview.service;

import com.comcast.interview.model.LcsStringObject;
import com.comcast.interview.model.LcsStringResponse;

public interface LcsService {
	
	LcsStringResponse validateLcs(LcsStringObject obj);
	
}
