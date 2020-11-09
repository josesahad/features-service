package org.jsahad.model.exception;

import java.util.UUID;

/**
 * Exception representing an attempt to retrieve a non existent Feature.
 */
public class FeatureNotFoundException extends RuntimeException {

    /**
     * Default SerialVersionId.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new EntityNotFoundException with the type and id of the entity that
     * failed to be retrieved.
     *
     * @param id The id of the feature that failed to be retrieved.
     */
    public FeatureNotFoundException(UUID id) {
        super(String.format("The feature with id %s could not be found", id));
    }
}
