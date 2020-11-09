package org.jsahad.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureCollection {

    /**
     * List of features.
     */
    private List<Feature> features;

    /**
     * Default constructor. Used for serialization purposes.
     */
    public FeatureCollection() {

    }

    /**
     * Builds the feature collection.
     * 
     * @param features  list of features.
     * 
     */
    public FeatureCollection(List<Feature> features) {
        this.features = features;
    }

    /**
     * Retrieves the list of features.
     * 
     * @return list of features.
     */
    public List<Feature> getFeatures() {
        return this.features;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FeatureCollection featureCollection = (FeatureCollection) o;
        return Objects.equals(this.features, featureCollection.features);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.features);
    }
}
