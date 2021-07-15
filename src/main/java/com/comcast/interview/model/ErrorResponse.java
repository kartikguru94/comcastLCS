package com.comcast.interview.model;

import lombok.Data;

@Data
public class ErrorResponse {
	 private final int status;
	 private final String message;
}
