package com.cruddynamodb.service;

import com.cruddynamodb.dto.PersonDTO;
import com.cruddynamodb.model.Person;

import java.util.List;

/**
 * Interface responsible in centralize all methods for Person.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 25/02/21
 */
public interface PersonService {

    /**
     * Save a new Person.
     *
     * @param person
     * @return Person
     */
    Person save(PersonDTO person);

    /**
     * Find all Person.
     *
     * @return List Person
     */
    List<Person> findAll();

    /**
     * Find a Person by document number.
     *
     * @param documentNumber
     * @return Person
     */
    Person findByDocumentNumber(String documentNumber);
    /**
     * Update a Person by CPF.
     *
     * @param documentNumber
     * @param person
     * @return Person updated
     */
    Person update(String documentNumber, PersonDTO person);


    /**
     * Delete a person by documentNumber.
     *
     * @param documentNumber
     */
    void delete(String documentNumber);
}
