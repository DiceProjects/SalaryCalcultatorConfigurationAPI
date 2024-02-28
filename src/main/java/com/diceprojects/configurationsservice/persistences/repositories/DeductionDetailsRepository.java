package com.diceprojects.configurationsservice.persistences.repositories;

import com.diceprojects.configurationsservice.persistences.models.entities.DeductionDetails;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio Reactivo de MongoDB para la entidad {@link DeductionDetails}.
 * Este repositorio permite la gestión reactiva de los detalles de las deducciones asociadas
 * a los cálculos salariales, como pueden ser las contribuciones a la seguridad social, impuestos,
 * entre otros. Al estar basado en el modelo reactivo, facilita operaciones no bloqueantes
 * y asincrónicas para una gestión eficiente de los datos.
 *
 * Extiende la interfaz {@link ReactiveMongoRepository}, proporcionando métodos CRUD reactivos
 * predeterminados que permiten la creación, actualización, recuperación y eliminación de los
 * detalles de las deducciones de manera asincrónica, mejorando el rendimiento y la escalabilidad
 * de las aplicaciones que utilizan este repositorio.
 *
 * Además, se pueden añadir métodos de consulta personalizados para adaptar las consultas a las
 * necesidades específicas de la aplicación, como buscar detalles de deducciones por nombre,
 * valor o cualquier otro criterio relevante.
 */
@Repository
public interface DeductionDetailsRepository extends ReactiveMongoRepository<DeductionDetails, String> {
}