package no.kdrs.grouse.service;


import no.kdrs.grouse.model.GrouseUser;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by tsodring on 28/03/18.
 */
public interface IGrouseUserService {
    List<GrouseUser> findAll();

    GrouseUser findById(String id);

    GrouseUser save(GrouseUser requirement);

    GrouseUser update(String requirementId, GrouseUser requirement)
            throws EntityNotFoundException;

    void delete(String id);
}
