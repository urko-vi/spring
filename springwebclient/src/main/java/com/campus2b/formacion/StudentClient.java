package com.campus2b.formacion;



import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.campus2b.formacion.wsdl.GetStudentRequest;
import com.campus2b.formacion.wsdl.GetStudentResponse;

public class StudentClient extends WebServiceGatewaySupport  {
	
	public static final String URIWS = "http://localhost:8080/springwebservice/soapws/getStudentResponse";
	
	public GetStudentResponse getStudentById(int studentId) {
		GetStudentRequest request = new GetStudentRequest();
		request.setStudentId(studentId);
		GetStudentResponse response = (GetStudentResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(URIWS));
		return response;
	}
}
