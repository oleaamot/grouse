package no.kdrs.grouse.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import no.kdrs.grouse.entity.Kravspec;
import no.kdrs.grouse.service.IKravspecService;

@Controller
@RequestMapping("user")
public class KravspecController {
	@Autowired
	private IKravspecService kravspecService;
	@GetMapping("kravspec/{id}")
	public ResponseEntity<Kravspec> getKravspecById(@PathVariable("id") Integer id) {
		Kravspec kravspec = kravspecService.getKravspecById(id);
		return new ResponseEntity<Kravspec>(kravspec, HttpStatus.OK);
	}
	@GetMapping("kravspec")
	public ResponseEntity<List<Kravspec>> getAllKravspecs() {
		List<Kravspec> list = kravspecService.getAllKravspecs();
		return new ResponseEntity<List<Kravspec>>(list, HttpStatus.OK);
	}
	@PostMapping("kravspec")
	public ResponseEntity<Void> addKravspec(@RequestBody Kravspec kravspec, UriComponentsBuilder builder) {
        boolean flag = kravspecService.addKravspec(kravspec);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/kravspec/{id}").buildAndExpand(kravspec.getKravspecId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("kravspec")
	public ResponseEntity<Kravspec> updateKravspec(@RequestBody Kravspec kravspec) {
		kravspecService.updateKravspec(kravspec);
		return new ResponseEntity<Kravspec>(kravspec, HttpStatus.OK);
	}
	@DeleteMapping("kravspec/{id}")
	public ResponseEntity<Void> deleteKravspec(@PathVariable("id") Integer id) {
		kravspecService.deleteKravspec(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
