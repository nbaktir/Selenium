package com.class6;

import com.utils.CommonMethods;

public class FrameRecap extends CommonMethods{

	public static void main(String[] args) {
		//if there is a frame, after right click we see 
		//view frame source
		//we need to use switchTo().frame(framename) method
		
		setUp("chrome","http://jiravm.centralus.cloudapp.azure.com:8081/bootstrap-iframe.html");
		
		
	}

}
