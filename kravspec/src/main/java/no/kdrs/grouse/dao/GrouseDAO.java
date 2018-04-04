package no.kdrs.grouse.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import no.kdrs.grouse.entity.Grouse;
@Transactional
@Repository
public class GrouseDAO implements IGrouseDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Grouse getGrouseById(int grouseId) {
		return entityManager.find(Grouse.class, grouseId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Grouse> getAllGrouses() {
		String hql = "FROM grouse as atcl ORDER BY atcl.grouse_id";
		return (List<Grouse>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addGrouse(Grouse grouse) {
		entityManager.persist(grouse);
	}
	@Override
	public void updateGrouse(Grouse grouse) {
		Grouse artcl = getGrouseById(grouse.getGrouseId());
		artcl.setTitle(grouse.getTitle());
		artcl.setCategory(grouse.getCategory());
		entityManager.flush();
	}
	@Override
	public void deleteGrouse(int grouseId) {
		entityManager.remove(getGrouseById(grouseId));
	}
	@Override
	public boolean grouseExists(String title, String category) {
		String hql = "FROM grouse as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}
}
