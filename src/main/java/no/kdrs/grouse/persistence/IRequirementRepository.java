package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.Requirement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRequirementRepository
        extends CrudRepository<Requirement, String> {

    // requirementNumber
    Requirement findByRequirementNumber(String requirementFirstName);

    // requirementType
    List<Requirement> findByRequirementType(String requirementType);
}
