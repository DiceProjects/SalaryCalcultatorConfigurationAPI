package com.diceprojects.configurationsservice.persistences.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class CountrySaveDTO {

    @Indexed(unique = true)
    @Field("countryCode")
    @NotBlank(message = "Country code is required")
    private String countryCode;
    @NotBlank(message = "Country Name is required")
    @Field("countryName")
    @Indexed(unique = true)
    private String countryName;

}
