package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tsodring 28/03/2018
 */

@Repository
public interface IRoleRepository
        extends CrudRepository<Role, String> {

}
