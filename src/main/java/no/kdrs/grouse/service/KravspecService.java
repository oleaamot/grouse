package no.kdrs.grouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.kdrs.grouse.dao.IKravspecDAO;
import no.kdrs.grouse.entity.Kravspec;
@Service
public class KravspecService implements IKravspecService {
	@Autowired
	private IKravspecDAO kravspecDAO;
	@Override
	public Kravspec getKravspecById(int kravspecId) {
		Kravspec obj = kravspecDAO.getKravspecById(kravspecId);
		return obj;
	}	
	@Override
	public List<Kravspec> getAllKravspecs(){
		return kravspecDAO.getAllKravspecs();
	}
	@Override
	public synchronized boolean addKravspec(Kravspec kravspec){
       if (kravspecDAO.kravspecExists(kravspec.getTitle(), kravspec.getCategory())) {
    	   return false;
       } else {
    	   kravspecDAO.addKravspec(kravspec);
    	   return true;
       }
	}
	@Override
	public void updateKravspec(Kravspec kravspec) {
		kravspecDAO.updateKravspec(kravspec);
	}
	@Override
	public void deleteKravspec(int kravspecId) {
		kravspecDAO.deleteKravspec(kravspecId);
	}
}
