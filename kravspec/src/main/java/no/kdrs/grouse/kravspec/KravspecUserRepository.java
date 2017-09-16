package no.kdrs.grouse.kravspec;

import org.springframework.data.repository.CrudRepository;

import no.kdrs.grouse.kravspec.KravspecUser;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface KravspecUserRepository extends CrudRepository<KravspecUser, Long> {

}
