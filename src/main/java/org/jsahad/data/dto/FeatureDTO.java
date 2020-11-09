package org.jsahad.data.dto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.jsahad.data.access.StaticDatasetAccess;
import org.jsahad.model.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Component for Feature data access.
 */
@Component
public class FeatureDTO {
    
    /**
     * DatasetAccess object.
     */
    private final StaticDatasetAccess datasetAccess;

    /**
     * Builds the Feature DTO.
     * 
     * @param datasetAccess DatasetAccess dependency.
     */
    @Autowired
    public FeatureDTO(StaticDatasetAccess datasetAccess) {
        this.datasetAccess = datasetAccess;
    }

    /**
     * Returns all the features in the data in-memory storage.
     * 
     * @return all the features.
     */
    public List<Feature> getFeatures() {
        return this.datasetAccess.getDataMap().values().stream().collect(Collectors.toList());
    }

    /**
     * Returns a features for a given id.
     * 
     * @param featureId     Feature id.
     * @return Feature for a given id.
     */
    public Optional<Feature> getFeature(UUID featureId) {
        return Optional.ofNullable(datasetAccess.getDataMap().get(featureId));
    }
}
