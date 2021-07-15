package com.comcast.interview.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.comcast.interview.exception.BadRequestLcsException;
import com.comcast.interview.model.LcsStringObject;
import com.comcast.interview.model.LcsStringResponse;
import com.comcast.interview.model.SetOfStrings;
import com.comcast.interview.model.lcs;

@RunWith(SpringRunner.class)
public class LcsServiceTest {
			
	// Check for valid result
	@Test
	public void testValidateLcs() {
		
		LcsService lcsService = new LcsServiceImpl();
		
		// Request
		LcsStringObject obj = new LcsStringObject();
		List<SetOfStrings> sos = new ArrayList<SetOfStrings>();
		SetOfStrings value1 = new SetOfStrings("comcast");
		SetOfStrings value2 = new SetOfStrings("comcastic");
		SetOfStrings value3 = new SetOfStrings("broadcaster");
		sos.add(value1);
		sos.add(value2);
		sos.add(value3);
		obj.setSetOfStrings(sos);
		
		// Response
		LcsStringResponse lcsResponse = new LcsStringResponse();
		lcs lcs = new lcs();
		List<SetOfStrings> sosList = new ArrayList<SetOfStrings>();
		sosList.add(new SetOfStrings("cast"));
		lcs.setLcs(sosList);
		lcsResponse.setFormat(lcs);
		
		assertEquals(lcsResponse, lcsService.validateLcs(obj));
	}
	
	// Bad Request exception check
	@Test()
	public void testValidateExceptionLcs() {
		
		LcsService lcsService = new LcsServiceImpl();
		
		// Request
		LcsStringObject obj = new LcsStringObject();
		List<SetOfStrings> sos = new ArrayList<SetOfStrings>();
		obj.setSetOfStrings(sos);
		
		// Request
		LcsStringObject obj1 = null;
		
		// Check for Value string not set
		assertThrows(BadRequestLcsException.class, () -> lcsService.validateLcs(obj));
		
		// Check for SetofString string not set		
		assertThrows(NullPointerException.class, () -> lcsService.validateLcs(obj1));
	}
	
	// Duplicate String Request exception check
	@Test()
	public void testValidateDuplicateLcs() {
		
		LcsService lcsService = new LcsServiceImpl();
		
		// Request
				LcsStringObject obj = new LcsStringObject();
				List<SetOfStrings> sos = new ArrayList<SetOfStrings>();
				SetOfStrings value1 = new SetOfStrings("comcast");
				SetOfStrings value2 = new SetOfStrings("comcast");
				SetOfStrings value3 = new SetOfStrings("comcast");
				sos.add(value1);
				sos.add(value2);
				sos.add(value3);
				obj.setSetOfStrings(sos);
		
		// Check for Value string not set
		assertThrows(BadRequestLcsException.class, () -> lcsService.validateLcs(obj));
		
	}

}
