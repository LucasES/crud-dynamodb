package com.cruddynamodb.service.impl;

import com.cruddynamodb.dto.PersonDTO;
import com.cruddynamodb.model.Person;
import com.cruddynamodb.repository.PersonRepository;
import com.cruddynamodb.service.PersonService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation class that contains all business logic for Person.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 25/02/21
 */
@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private ModelMapper modelMapper;

    @Override
    public Person save(PersonDTO person) {
        Optional<Person> byDocumentNumber = personRepository.findByDocumentNumber(person.getDocumentNumber());

        if(byDocumentNumber.isPresent()) {
            throw new RuntimeException("There is already a Person with this document number");
        }

        Person personModel = modelMapper.map(person, Person.class);

        return personRepository.save(personModel);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person findByDocumentNumber(String documentNumber) {
        return personRepository.findByDocumentNumber(documentNumber).orElse(null);
    }

    @Override
    public Person update(String documentNumber, PersonDTO person) {
        Optional<Person> byDocumentNumber = personRepository.findByDocumentNumber(person.getDocumentNumber());

        if(byDocumentNumber.isEmpty()) {
            throw new RuntimeException("There is not Person with this document number");
        }

        Person personModel = modelMapper.map(person, Person.class);

        return personRepository.save(personModel);
    }

    @Override
    public void delete(String documentNumber) {
        Optional<Person> byDocumentNumber = personRepository.findByDocumentNumber(documentNumber);

        if(byDocumentNumber.isEmpty()) {
            throw new RuntimeException("There is not Person with this document number");
        }

        personRepository.delete(byDocumentNumber.get());
    }
}
