package com.campus2b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.campus2b.soap.GetStudentRequest;
import com.campus2b.soap.GetStudentResponse;



@Endpoint
public class StudentEndpoint {
//	private static final String NAMESPACE_URI = "http://concretepage.com/soap";
	@Autowired
	private StudentUtility studentUtility;	

	@PayloadRoot(namespace = AppConfig.TARGET_NAMESPACE, localPart = "getStudentRequest")
	@ResponsePayload
	public GetStudentResponse getCountry(@RequestPayload GetStudentRequest request) {
		GetStudentResponse response = new GetStudentResponse();
		response.setStudent(studentUtility.getStudent(request.getStudentId()));
		return response;
	}
}
