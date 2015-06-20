package pl.edu.agh.soa.ba.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Piotr Konsek
 * 
 * Contains method to handle http request.
 * Manages rest connection 
 *
 */
@Controller
public abstract class BaseController {
	private RestTemplate restTemplate;
	ObjectMapper objectMapper;

	public static final String BASE_URL = "http://localhost:8080/core";
//	public static final String BASE_URL = "http://soahotelcore-hotelcore.rhcloud.com/core-0.1";


	public BaseController() {
		objectMapper = new ObjectMapper();
		restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
				restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
					@Override
					protected boolean hasError(HttpStatus statusCode) {
						return false;
					}
		
					@Override
					public boolean hasError(ClientHttpResponse response)
							throws IOException {
						return false;
					}
					
				});
	}

	/**
	 * put object to given url
	 * @param url
	 * @param request
	 */
	protected void put(String url, Object request) {		
		try{
			restTemplate.put(url, request);
		} catch (HttpClientErrorException e){
			e.printStackTrace();
		}	
	}

	/**
	 *  post for entity
	 * @param url
	 * @param request
	 * @return
	 */
	protected ResponseEntity<String> post(String url, Object request) {
		ResponseEntity<String> response = null;
		try{
			response = restTemplate.postForEntity(url, request, String.class);
//			response = restTemplate.exchange(url, HttpMethod.POST, request, )
		} catch (HttpClientErrorException e){
			e.printStackTrace();
		}	
		return response;
	}

	protected ResponseEntity<String> get(String url) {
		ResponseEntity<String> response = null;
		try{
			response = restTemplate.getForEntity(url, String.class);
		} catch (HttpClientErrorException e){
			e.printStackTrace();
		}	
		return response;
	}
	
	protected ResponseEntity<byte[]> getFile(String url) {
		ResponseEntity<byte[]> response = null;
		try{
			response = restTemplate.getForEntity(url, byte[].class);
		} catch (HttpClientErrorException e){
			e.printStackTrace();
		}	
		return response;
	}
	
	private HttpHeaders getHeadersWithAuth(String token){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		return headers;
	}
}
