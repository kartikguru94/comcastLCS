package com.comcast.interview.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.comcast.interview.exception.BadRequestLcsException;
import com.comcast.interview.model.LcsStringObject;
import com.comcast.interview.model.LcsStringResponse;
import com.comcast.interview.model.SetOfStrings;
import com.comcast.interview.model.lcs;

@Service
public class LcsServiceImpl implements LcsService {

	@Override
	public LcsStringResponse validateLcs(LcsStringObject obj) {
		if (obj.getSetOfStrings().size() > 0) {
			List<String> array = obj.getSetOfStrings().stream()
					.map(setofstring -> setofstring.getValue())
					.filter(item -> item != null)
					.collect(Collectors.toList());
			
			Set<String> uniqueString = new HashSet<String>(array);
			
			if (uniqueString.size() != array.size()) {
				throw new BadRequestLcsException("Values cannot be same!");
			}
			
			if (array.size() > 0) {
				LcsStringResponse lcsResponse = new LcsStringResponse();
				lcs lcs = new lcs();
				SetOfStrings sos = new SetOfStrings();
				
				// Finding the Longest Common Substring
				String lcsString = getLongestSubstring(array.toArray(new String[array.size()]));
				
				sos.setValue(lcsString);
				List<SetOfStrings> sosList = new ArrayList<SetOfStrings>();
				sosList.add(sos);
				lcs.setLcs(sosList);
				lcsResponse.setFormat(lcs);
				return lcsResponse;
				
			} else {
				throw new BadRequestLcsException("Empty Value cannot be allowed!");				
			}
			
		} else {
			throw new BadRequestLcsException("Empty Array cannot be allowed!");
		}
	}
	
	private String getLongestSubstring(String[] lcsStrings) {
		
        int n = lcsStrings.length;
        String firstString = lcsStrings[0];
        int len = firstString.length();
 
        String res = "";
 
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String stem = firstString.substring(i, j);
                int k = 1;
                for (k = 1; k < n; k++)
                    if (!lcsStrings[k].contains(stem))
                        break;

                if (k == n && res.length() < stem.length())
                    res = stem;
            }
        }
 
        return res;
	}

	
	
}
