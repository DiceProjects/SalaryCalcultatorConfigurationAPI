package com.diceprojects.configurationsservice.services;

import com.diceprojects.configurationsservice.persistences.models.dtos.CountrySaveDTO;
import com.diceprojects.configurationsservice.persistences.models.entities.Countries;
import reactor.core.publisher.Mono;

/**
 * Servicio para la gestión de países dentro del sistema de configuración.
 * <p>
 * Este servicio define las operaciones de alto nivel que pueden ser realizadas
 * sobre la entidad {@link Countries}. Proporciona funcionalidades para guardar,
 * eliminar, y recuperar información de países utilizando un enfoque reactivo.
 * </p>
 */
public interface CountriesService {

    /**
     * Guarda un país en la base de datos.
     *
     * @param country El país a ser guardado.
     * @return Un {@link Mono} que emite el país guardado.
     */
    Mono<Countries> saveCountry(CountrySaveDTO country);

    /**
     * Elimina un país de la base de datos basándose en su identificador.
     *
     * @param id El identificador único del país a ser eliminado.
     * @return Un {@link Mono} que completa normalmente si la operación es exitosa.
     */
    Mono<Countries> deleteCountry(String id);

    /**
     * Recupera un país basándose en su identificador.
     *
     * @param id El identificador único del país a ser recuperado.
     * @return Un {@link Mono} que emite el país encontrado o vacío si no se encuentra ninguno.
     */
    Mono<Countries> getCountryById(String id);

    /**
     * Recupera un país basándose en su nombre.
     *
     * @param name El nombre del país a ser recuperado.
     * @return Un {@link Mono} que emite el país encontrado o vacío si no se encuentra ninguno.
     */
    Mono<Countries> getCountryByName(String name);
}
