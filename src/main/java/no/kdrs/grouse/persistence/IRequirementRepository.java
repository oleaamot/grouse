package no.kdrs.grouse.persistence;

import no.kdrs.grouse.model.Requirement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IRequirementRepository extends CrudRepository<Requirement, String> {

    @Override
    Requirement save(Requirement Requirement);

    @Override
    Set<Requirement> findAll();

    // requirementNumber
    Requirement findByRequirementNumber(String requirementFirstName);

    // requirementType
    Set<Requirement> findByRequirementType(String requirementType);
}
