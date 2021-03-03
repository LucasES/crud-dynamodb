package com.cruddynamodb.repository;

import com.cruddynamodb.model.Person;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Repository class for Person model.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 25/02/21
 */
@EnableScan
public interface PersonRepository extends CrudRepository<Person, String> {

    /**
     * Query to find a Person by document number.
     *
     * @param documentNumber
     * @return Optional Person
     */
    Optional<Person> findByDocumentNumber(String documentNumber);
}
