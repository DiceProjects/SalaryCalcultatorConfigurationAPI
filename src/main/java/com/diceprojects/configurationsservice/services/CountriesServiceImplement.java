package com.diceprojects.configurationsservice.services;

import com.diceprojects.configurationsservice.persistences.models.dtos.CountrySaveDTO;
import com.diceprojects.configurationsservice.persistences.models.entities.Countries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.diceprojects.configurationsservice.persistences.repositories.CountriesRepository;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Service
public class CountriesServiceImplement implements CountriesService {

    private static final Logger logger = LoggerFactory.getLogger(CountriesServiceImplement.class);
    private final CountriesRepository repository;

    public CountriesServiceImplement(CountriesRepository repository) {
        this.repository = repository;
    }

    /**
     * Guarda un nuevo país en la base de datos de forma reactiva y no bloqueante.
     * <p>
     * Antes de guardar, este método verifica que los campos 'countryCode' y 'countryName'
     * no estén vacíos o sean nulos. Luego, realiza búsquedas en la base de datos para asegurarse
     * de que no existan países con el mismo 'countryCode' o 'countryName'.
     * </p>
     * <p>
     * Si se encuentra un país con el mismo código o nombre, o si los campos requeridos están vacíos,
     * el método devuelve un {@link Mono} de error. Si no hay conflictos y los campos son válidos,
     * el país se guarda y se devuelve un {@link Mono} que emite el país guardado. Se utiliza {@link Mono#cast(Class)}
     * para asegurar que el objeto emitido sea del tipo {@link Countries}.
     * </p>
     * <p>
     * Este método utiliza operadores reactivos para manejar de manera eficiente situaciones de error
     * como claves duplicadas y campos inválidos, asegurando una ejecución no bloqueante y reactivo.
     * Además, se manejan errores específicos y se transforman en {@link ResponseStatusException}
     * para proporcionar mensajes de error significativos y códigos de estado HTTP adecuados.
     * </p>
     * @param country El país a ser guardado, no debe tener 'countryCode' ni 'countryName' nulos o vacíos.
     * @return Un {@link Mono} que, si el guardado es exitoso, emite el país guardado, o un {@link Mono} de error
     *         si el país no puede ser guardado debido a campos inválidos o conflictos de clave única.
     */
    @Override
    public Mono<Countries> saveCountry(CountrySaveDTO countryDTO) {
        if (countryDTO.getCountryCode() == null || countryDTO.getCountryCode().trim().isEmpty()) {
            return Mono.error(new IllegalArgumentException("Country code must not be null or empty"));
        }
        if (countryDTO.getCountryName() == null || countryDTO.getCountryName().trim().isEmpty()) {
            return Mono.error(new IllegalArgumentException("Country name must not be null or empty"));
        }

        Countries country = new Countries();
        country.setCountryCode(countryDTO.getCountryCode());
        country.setCountryName(countryDTO.getCountryName());
        country.setCreatedBy("Admin");
        country.setCreatedDate(LocalDateTime.now());

        return repository.findByCountryCode(country.getCountryCode())
                .flatMap(existingCountry -> Mono.error(new IllegalStateException("Country with code " + country.getCountryCode() + " already exists.")))
                .switchIfEmpty(repository.findByCountryName(country.getCountryName()))
                .flatMap(existingCountry -> Mono.error(new IllegalStateException("Country with name " + country.getCountryName() + " already exists.")))
                .switchIfEmpty(repository.save(country))
                .cast(Countries.class)
                .doOnSuccess(savedCountry -> logger.info("Country saved successfully: {}", savedCountry.getCountryName()))
                .onErrorResume(e -> {
                    logger.error("Error saving country: {}", e.getMessage());
                    if (e instanceof IllegalArgumentException || e instanceof IllegalStateException) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e));
                    }
                    return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", e));
                });
    }

    @Override
    public Mono<Countries> deleteCountry(String Id) {
        return null;
    }

    @Override
    public Mono<Countries> getCountryById(String Id) {
        return null;
    }

    @Override
    public Mono<Countries> getCountryByName(String name) {
        return null;
    }

}
