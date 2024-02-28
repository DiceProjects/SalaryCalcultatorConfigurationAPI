package com.diceprojects.configurationsservice.persistences.repositories;

import com.diceprojects.configurationsservice.persistences.models.entities.Countries;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Repositorio Reactivo de MongoDB para la entidad {@link Countries}.
 * <p>
 * Este repositorio proporciona una interfaz reactiva para operaciones CRUD básicas
 * y consultas personalizadas sobre la colección de países en MongoDB. Al extender
 * {@link ReactiveMongoRepository}, hereda métodos para operaciones como encontrar,
 * guardar, y eliminar entidades de países de forma reactiva.
 * </p>
 * <p>
 * La utilización de este repositorio facilita la integración de la base de datos MongoDB
 * con el enfoque reactivo de la aplicación, permitiendo operaciones asincrónicas y no bloqueantes
 * sobre los datos de países.
 * </p>
 */
@Repository
public interface CountriesRepository extends ReactiveMongoRepository<Countries, String> {
    Mono<Countries> findByCountryCode(String countryCode);
    Mono<Countries> findByCountryName(String name);

}
