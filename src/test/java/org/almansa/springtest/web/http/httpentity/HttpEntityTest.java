package org.almansa.springtest.web.http.httpentity;

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

		// Http바디, Http헤더로 구성된다.
		HttpEntity<String> httpEntity = new HttpEntity<>("Hello World", headers);
		
		assertEquals("Hello World", httpEntity.getBody());		
		assertEquals(true, httpEntity.hasBody());
		
	}

	/**
	 * 주로 RestController의 핸들러 메소드에서 리턴하는 형태이다.
	 */
	@Test
	public void responseEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setLocation(URI.create("http://test.com"));

		// HttpEntity - ResponseEntity
		// Http바디, Http헤더, Http응답코드로 구성된다.
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Hello World", headers, HttpStatus.OK);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());	
		assertEquals("Hello World", responseEntity.getBody());		
		assertEquals(true, responseEntity.hasBody());
	}
	
	@Test
	public void responseEntity_builder() {
		ResponseEntity<String> responseEntity = ResponseEntity
		.ok()
		.header("header1", "value1")
		.body("Hello"); // body로 build한다.
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());	
		assertEquals("Hello", responseEntity.getBody());		
		assertEquals(true, responseEntity.hasBody());
	}
}
