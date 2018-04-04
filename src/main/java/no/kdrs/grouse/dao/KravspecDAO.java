package no.kdrs.grouse.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import no.kdrs.grouse.entity.Kravspec;
@Transactional
@Repository
public class KravspecDAO implements IKravspecDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Kravspec getKravspecById(int kravspecId) {
		return entityManager.find(Kravspec.class, kravspecId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Kravspec> getAllKravspecs() {
		String hql = "FROM kravspec as atcl ORDER BY atcl.kravspec_id";
		return (List<Kravspec>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addKravspec(Kravspec kravspec) {
		entityManager.persist(kravspec);
	}
	@Override
	public void updateKravspec(Kravspec kravspec) {
		Kravspec artcl = getKravspecById(kravspec.getKravspecId());
		artcl.setTitle(kravspec.getTitle());
		artcl.setCategory(kravspec.getCategory());
		entityManager.flush();
	}
	@Override
	public void deleteKravspec(int kravspecId) {
		entityManager.remove(getKravspecById(kravspecId));
	}
	@Override
	public boolean kravspecExists(String title, String category) {
		String hql = "FROM kravspec as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}
}
