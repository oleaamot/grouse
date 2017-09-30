package no.kdrs.grouse;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import no.kdrs.grouse.entity.Kravspec;

public class RestClientUtil {
    public void getKravspecByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/kravspec/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Kravspec> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Kravspec.class, 1);
        Kravspec kravspec = responseEntity.getBody();
        System.out.println("Id:"+kravspec.getKravspecId()+", Title:"+kravspec.getTitle()
                 +", Category:"+kravspec.getCategory());      
    }
	public void getAllKravspecsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/kravspecs";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Kravspec[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Kravspec[].class);
        Kravspec[] kravspecs = responseEntity.getBody();
        for(Kravspec kravspec : kravspecs) {
              System.out.println("Id:"+kravspec.getKravspecId()+", Title:"+kravspec.getTitle()
                      +", Category: "+kravspec.getCategory());
        }
    }
    public void addKravspecDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/kravspec";
	    Kravspec objKravspec = new Kravspec();
	    objKravspec.setTitle("Spring REST Security using Hibernate");
	    objKravspec.setCategory("Spring");
        HttpEntity<Kravspec> requestEntity = new HttpEntity<Kravspec>(objKravspec, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateKravspecDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/kravspec";
	    Kravspec objKravspec = new Kravspec();
	    objKravspec.setKravspecId(1);
	    objKravspec.setTitle("Update:Java Concurrency");
	    objKravspec.setCategory("Java");
        HttpEntity<Kravspec> requestEntity = new HttpEntity<Kravspec>(objKravspec, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteKravspecDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/kravspec/{id}";
        HttpEntity<Kravspec> requestEntity = new HttpEntity<Kravspec>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getKravspecByIdDemo();
    	util.getAllKravspecsDemo();
    	//util.addKravspecDemo();
    	//util.updateKravspecDemo();
    	//util.deleteKravspecDemo();
    }    
}
