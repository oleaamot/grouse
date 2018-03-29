package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.GrouseUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tsodring 28/03/2018
 * <p>
 * Repository for GrouseUser. Empty as we are just using from CrudRepository.
 */
@Repository
public interface IGrouseUserRepository
        extends CrudRepository<GrouseUser, String> {

}
