package com.cruddynamodb.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.cruddynamodb.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Person data transfer object.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 24/02/21
 */
@Data
@NoArgsConstructor
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = -3645736556301663275L;

    @NotBlank
    @NotNull(message = "The first_name field is required!")
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank(message = "The last_name field can't be blank!")
    @NotNull(message = "The last_name field is required!")
    @JsonProperty("first_name")
    private String lastName;

    @NotBlank(message = "The age field can't be blank!")
    @NotNull(message = "The age field is required!")
    private Integer age;

    @NotBlank(message = "The document_number field can't be blank!")
    @NotNull(message = "The document_number is required!")
    @JsonProperty("document_number")
    private String documentNumber;

    private GenderEnum gender;
}
