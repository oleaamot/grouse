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

import no.kdrs.grouse.entity.Grouse;
import no.kdrs.grouse.service.IGrouseService;

@Controller
@RequestMapping("user")
public class GrouseController {
	@Autowired
	private IGrouseService grouseService;
	@GetMapping("grouse/{id}")
	public ResponseEntity<Grouse> getGrouseById(@PathVariable("id") Integer id) {
		Grouse grouse = grouseService.getGrouseById(id);
		return new ResponseEntity<Grouse>(grouse, HttpStatus.OK);
	}
	@GetMapping("grouse")
	public ResponseEntity<List<Grouse>> getAllGrouses() {
		List<Grouse> list = grouseService.getAllGrouses();
		return new ResponseEntity<List<Grouse>>(list, HttpStatus.OK);
	}
	@PostMapping("grouse")
	public ResponseEntity<Void> addGrouse(@RequestBody Grouse grouse, UriComponentsBuilder builder) {
        boolean flag = grouseService.addGrouse(grouse);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/grouse/{id}").buildAndExpand(grouse.getGrouseId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("grouse")
	public ResponseEntity<Grouse> updateGrouse(@RequestBody Grouse grouse) {
		grouseService.updateGrouse(grouse);
		return new ResponseEntity<Grouse>(grouse, HttpStatus.OK);
	}
	@DeleteMapping("grouse/{id}")
	public ResponseEntity<Void> deleteGrouse(@PathVariable("id") Integer id) {
		grouseService.deleteGrouse(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
