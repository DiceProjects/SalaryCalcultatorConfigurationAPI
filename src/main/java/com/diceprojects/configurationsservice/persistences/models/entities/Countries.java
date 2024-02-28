package com.diceprojects.configurationsservice.persistences.models.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

/**
 * Representa un país en el sistema de configuración.
 * <p>
 * Esta entidad se utiliza para almacenar información relevante sobre los países,
 * como su código y nombre. Esta información puede ser utilizada en diferentes partes
 * del sistema, como asociaciones con deducciones, impuestos y otros parámetros específicos
 * de cada país.
 * </p>
 */
@Data
@Document(collection = "Countries")
public class Countries {

    @Id
    private String id;
    @Indexed(unique = true)
    @Field("countryCode")
    @NotBlank(message = "Country code is required")
    private String countryCode;
    @NotBlank(message = "Country Name is required")
    @Field("countryName")
    @Indexed(unique = true)
    private String countryName;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

}
