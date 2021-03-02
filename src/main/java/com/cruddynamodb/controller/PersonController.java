package com.cruddynamodb.controller;

import com.cruddynamodb.dto.PersonDTO;
import com.cruddynamodb.model.Person;
import com.cruddynamodb.service.PersonService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * Controller class for Person API
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 25/02/21
 */
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "Person API")
@RestController
@RequestMapping("/v1")
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @ApiOperation(value = "Create a person")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The person was created with success"),
            @ApiResponse(code = 500, message = "An exception was thrown"),
    })
    @PostMapping("person")
    public ResponseEntity<Person> newPerson(@ApiParam("Person information to be created. Cannot be empty.")
                                                  @Valid @RequestBody PersonDTO personDTO) {
        logger.info("[PersonController - newPerson] - Starting with PersonDTO: {}", personDTO);

        Person save = service.save(personDTO);

        logger.info("[PersonController - newPerson] - Ending with Person saved: {}", save);
        return new ResponseEntity(save, HttpStatus.OK);
    }

    @ApiOperation(value = "Returns a list of people")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the person list"),
            @ApiResponse(code = 500, message = "An exception was thrown"),
    })
    @GetMapping("person")
    public ResponseEntity<List<Person>> allPerson() {
        logger.info("[PersonController - allPerson] - Starting...");

        List<Person> all = service.findAll();

        logger.info("[PersonController - allPerson] - Ending with person list with size: {}", (CollectionUtils.isEmpty(all) ? null : all.size()));

        return ResponseEntity.ok(all);
    }

    @ApiOperation(value = "Returns a person by document number of people")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the person"),
            @ApiResponse(code = 500, message = "An exception was thrown"),
    })
    @GetMapping("person/{documentNumber}")
    public ResponseEntity<Person> findByDocumentNumber(@ApiParam("Document number of the person to be udpated. Cannot be empty.")
                                                           @PathVariable("documentNumber") String documentNumber) {
        logger.info("[PersonController - findByDocumentNumber] - Starting with documentNumber: {}", documentNumber);

        Person byDocumentNumber = service.findByDocumentNumber(documentNumber);

        logger.info("[PersonController - findByDocumentNumber] - Ending with person: {}", byDocumentNumber);

        return ResponseEntity.ok(byDocumentNumber);
    }

    @ApiOperation(value = "Update a person by document number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Person updated with success"),
            @ApiResponse(code = 500, message = "An exception was thrown"),
    })
    @PutMapping("person/{documentNumber}")
    public ResponseEntity<Person> updatePerson(@ApiParam("Document number of the person to be udpated. Cannot be empty.")
                                                     @PathVariable("documentNumber") String documentNumber,
                                                 @ApiParam("Person information to be updated. Cannot be empty.") @Valid @RequestBody PersonDTO personDTO) {
        logger.info("[PersonController - updatePerson] - Starting with documentNumber: {} and PersonDTO: {}", documentNumber, personDTO);

        Person update = service.update(documentNumber, personDTO);

        logger.info("[PersonController - updatePerson] - Ending with person updated: {}", update);

        return ResponseEntity.ok(update);
    }

    @ApiOperation(value = "Disable a person by document number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Person disabled with success"),
            @ApiResponse(code = 500, message = "An exception was thrown"),
    })
    @DeleteMapping("person/{documentNumber}")
    public ResponseEntity disablePerson(@ApiParam("Document number of the person to be disable. Cannot be empty.")
                                              @PathVariable("documentNumber") String documentNumber) {

        logger.info("[PersonController - disablePerson] - Starting with documentNumber: {}", documentNumber);

        service.delete(documentNumber);

        logger.info("[PersonController - disablePerson] - Ending...");

        return ResponseEntity.ok().build();
    }
}
