package org.almansa.springtest.http.httpentity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HttpEntityTest {

	@Test
	public void httpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setLocation(URI.create("http://test.com"));
		
		HttpEntity<String> httpEntity = new HttpEntity<>("Hello World", headers);
		
		assertEquals(true, httpEntity.hasBody());		
	}
	
	public void responseEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setLocation(URI.create("http://test.com"));
		
		// HttpEntity - ResponseEntity 
		// Http헤더, Http바디, Http응답코드로 구성된다.
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Hello World", headers, HttpStatus.OK);		
		
		assertEquals(true, responseEntity.hasBody());
	}
}
