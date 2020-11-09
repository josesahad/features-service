package org.jsahad.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureCollection {

    private List<Feature> features;

    /**
     * Default constructor. Used for serialization purposes.
     */
    public FeatureCollection() {

    }

    public FeatureCollection(List<Feature> features) {
        this.features = features;
    }

    public List<Feature> getFeatures() {
        return this.features;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(this.features);
    }
}
