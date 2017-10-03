package no.kdrs.grouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.kdrs.grouse.dao.IGrouseDAO;
import no.kdrs.grouse.entity.Grouse;
@Service
public class GrouseService implements IGrouseService {
	@Autowired
	private IGrouseDAO grouseDAO;
	@Override
	public Grouse getGrouseById(int grouseId) {
		Grouse obj = grouseDAO.getGrouseById(grouseId);
		return obj;
	}	
	@Override
	public List<Grouse> getAllGrouses(){
		return grouseDAO.getAllGrouses();
	}
	@Override
	public synchronized boolean addGrouse(Grouse grouse){
       if (grouseDAO.grouseExists(grouse.getTitle(), grouse.getCategory())) {
    	   return false;
       } else {
    	   grouseDAO.addGrouse(grouse);
    	   return true;
       }
	}
	@Override
	public void updateGrouse(Grouse grouse) {
		grouseDAO.updateGrouse(grouse);
	}
	@Override
	public void deleteGrouse(int grouseId) {
		grouseDAO.deleteGrouse(grouseId);
	}
}
