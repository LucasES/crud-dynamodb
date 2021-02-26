package com.cruddynamodb.controller;

import com.cruddynamodb.dto.PersonDTO;
import com.cruddynamodb.model.Person;
import com.cruddynamodb.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller class for Person API
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 25/02/21
 */
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping("person")
    public ResponseEntity<Person> newCostumer(@Valid @RequestBody PersonDTO personDTO) {
        return new ResponseEntity(service.save(personDTO), HttpStatus.OK);
    }

    @GetMapping("person")
    public ResponseEntity<List<Person>> allCostumers() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("person/{documentNumber}")
    public ResponseEntity<Person> updateCostumer(@PathVariable("documentNumber") String documentNumber,
                                                 @Valid @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(service.update(documentNumber, personDTO));
    }

    @DeleteMapping("person/{documentNumber}")
    public ResponseEntity disableCostumer(@PathVariable("documentNumber") String documentNumber) {

        service.delete(documentNumber);

        return ResponseEntity.ok().build();
    }
}
