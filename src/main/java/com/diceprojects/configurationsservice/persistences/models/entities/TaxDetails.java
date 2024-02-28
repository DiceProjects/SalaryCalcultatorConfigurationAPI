package com.diceprojects.configurationsservice.persistences.models.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

/**
 * <p>
 * Representa los detalles de un impuesto específico aplicable a un cálculo salarial.
 * Esta entidad se almacena en la colección 'Tax_Details' de MongoDB y se utiliza
 * para detallar los diferentes tipos de impuestos que pueden aplicarse a un salario,
 * como el impuesto sobre la renta, el IVA, etc. Cada instancia de `TaxDetails`
 * puede estar asociada a un país específico, lo que permite aplicar diferentes
 * regímenes fiscales según la ubicación.
 * </p>
 */
@Data
@Document(collection = "Tax_Details")
public class TaxDetails {

    @Id
    private String id;
    private String taxName;
    private Double amount;
    private String countryId;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

}
