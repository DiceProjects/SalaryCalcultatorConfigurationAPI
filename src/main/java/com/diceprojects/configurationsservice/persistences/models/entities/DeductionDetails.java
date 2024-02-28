package com.diceprojects.configurationsservice.persistences.models.entities;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa las deducciones aplicables a un cálculo salarial,
 * incluyendo indicadores booleanos para la presencia de ciertas deducciones
 * y el porcentaje de contribución sindical si aplica.
 * Esta entidad se almacena en la colección 'Deductions' de MongoDB.
 */
@Data
@Document(collection = "Deductions")
public class Deductions {

    @Id
    private String id;
    private boolean retirement;
    private boolean healthInsurance;
    private boolean pami;
    private boolean unionContribution;
    private double unionContributionPercent;
    private boolean taxableIncomeCap;

}
