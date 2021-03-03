package com.cruddynamodb.dto;

import com.cruddynamodb.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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

    @ApiModelProperty(notes = "The first name", example = "João Lucas", required = true, position = 0)
    @NotBlank
    @NotNull(message = "The first_name field is required!")
    @JsonProperty("firstName")
    private String firstName;

    @ApiModelProperty(notes = "The last name", example = "Araújo Leite", required = true, position = 1)
    @NotBlank(message = "The last_name field can't be blank!")
    @NotNull(message = "The last_name field is required!")
    @JsonProperty("lastName")
    private String lastName;

    @ApiModelProperty(notes = "Current age", example = "28", required = true, position = 2)
    @NotNull(message = "The age field is required!")
    private Integer age;

    @ApiModelProperty(notes = "Document number", example = "12345678900", required = true, position = 3)
    @NotBlank(message = "The document_number field can't be blank!")
    @NotNull(message = "The document_number is required!")
    @JsonProperty("documentNumber")
    private String documentNumber;

    @ApiModelProperty(notes = "Gender", example = "male", required = true, position = 4)
    @NotNull(message = "The gender is required!")
    private GenderEnum gender;
}
