package org.jsahad.api.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.jsahad.api.response.FeatureResponse;
import org.jsahad.model.Feature;
import org.springframework.stereotype.Component;

@Component
public class FeatureTransformer {
    
    /**
     * Transforms the feature data to a particular API Response.
     *
     * @param feature The feature to transform.
     * @return The Feature transformed response.
     */
    public FeatureResponse transform(Feature feature) {
        return new FeatureResponse(feature.getId(), feature.getTimestamp(), feature.getBeginViewingDate(), feature.getEndViewingDate(),
            feature.getMissionName());
    }

    /**
     * Transforms a list of features to an API response.
     *
     * @param features The list of features to transform.
     * @return The trasnformed API response representing the features.
     */
    public List<FeatureResponse> transform(List<Feature> features) {
        return features.stream().map(this::transform).collect(Collectors.toList());
    }
}
