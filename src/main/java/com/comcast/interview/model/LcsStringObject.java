package com.comcast.interview.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LcsStringObject {

	@NotNull(message = "Please Provide LCS Strings")
	private List<SetOfStrings> setOfStrings;
	
}
