package com.diceprojects.configurationsservice.persistences.models.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

/**
 * Representa los detalles de una deducción específica aplicable a un cálculo salarial.
 * <p>
 * Esta entidad se almacena en la colección 'Deduction_Details' de MongoDB y se utiliza
 * para detallar las diferentes deducciones que se aplican a un salario, como las
 * contribuciones a la seguridad social, impuestos, entre otros. Cada instancia de
 * `DeductionDetails` puede estar asociada a un país específico, lo que permite aplicar
 * diferentes normativas según la ubicación.
 * </p>
 */
@Data
@Document(collection = "Deduction_Details")
public class DeductionDetails {

    @Id
    private String id;
    private String deductionName;
    private Double value;
    private String countryId;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

}
