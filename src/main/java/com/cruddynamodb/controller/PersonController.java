package com.cruddynamodb.controller;

import com.cruddynamodb.dto.PersonDTO;
import com.cruddynamodb.model.Person;
import com.cruddynamodb.service.PersonService;
import io.swagger.annotations.*;
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
@Api(value = "Person API")
@RestController
@RequestMapping("/v1")
public class PersonController {

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
    public ResponseEntity<Person> newCostumer(@ApiParam("Person information to be created. Cannot be empty.")
                                                  @Valid @RequestBody PersonDTO personDTO) {
        return new ResponseEntity(service.save(personDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Returns a list of people")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns the person list"),
            @ApiResponse(code = 500, message = "An exception was thrown"),
    })
    @GetMapping("person")
    public ResponseEntity<List<Person>> allCostumers() {
        return ResponseEntity.ok(service.findAll());
    }

    @ApiOperation(value = "Update a person by document number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Person updated with success"),
            @ApiResponse(code = 500, message = "An exception was thrown"),
    })
    @PutMapping("person/{documentNumber}")
    public ResponseEntity<Person> updateCostumer(@ApiParam("Document number of the person to be udpated. Cannot be empty.")
                                                     @PathVariable("documentNumber") String documentNumber,
                                                 @ApiParam("Person information to be updated. Cannot be empty.") @Valid @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(service.update(documentNumber, personDTO));
    }

    @ApiOperation(value = "Disable a person by document number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Person disabled with success"),
            @ApiResponse(code = 500, message = "An exception was thrown"),
    })
    @DeleteMapping("person/{documentNumber}")
    public ResponseEntity disableCostumer(@ApiParam("Id of the person to be disable. Cannot be empty.")
                                              @PathVariable("documentNumber") String documentNumber) {

        service.delete(documentNumber);

        return ResponseEntity.ok().build();
    }
}
