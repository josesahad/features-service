package org.jsahad.api.controller;

import org.jsahad.api.response.FeatureResponse;
import org.jsahad.api.transformer.FeatureTransformer;
import org.jsahad.service.impl.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/features")
public class FeatureController {
    
    /**
     * Feature Service.
     */
    private final FeatureService featureService;

    /**
     * Feature API Response Transformer.
     */
    private final FeatureTransformer featureTransformer;

    /**
     * Constructor for FeatureController.
     * @param featureService the Feature Service.
     * @param featureTransformer Feature API Response Transformer.
     */
    @Autowired
    public FeatureController(FeatureService featureService, FeatureTransformer featureTransformer) {
        this.featureService = featureService;
        this.featureTransformer = featureTransformer;
    }

    /**
     * Lists all the existing features.
     * 
     * @return List of existing features.
     */
    @RequestMapping(method = GET, produces = "application/json")
    public ResponseEntity<List<FeatureResponse>> listFeatures() {
        return ResponseEntity.ok(this.featureTransformer.transform(this.featureService.listFeatures()));
    }

    /**
     * Retrieves a single feature for a given id.
     *
     * @param featureId The id of the feature to retrieve.
     * @return Feature data for the given id.
     */
    @RequestMapping(path = "/{featureId}", method = GET, produces = "application/json")
    public ResponseEntity<FeatureResponse> getFeature(@PathVariable("featureId") UUID featureId) {
        return ResponseEntity.ok(this.featureTransformer.transform(this.featureService.getFeature(featureId)));
    }

    /**
     * Retrieves an image for a particular feature.
     *
     * @param featureId The id of the feature to retrieve.
     * @return Image for the given feature id.
     */
    @RequestMapping(path = "/{featureId}/quicklook", method = GET, produces = {"image/png", "application/json"})
    public ResponseEntity<byte[]> getImage(@PathVariable("featureId") UUID featureId) {
        return ResponseEntity.ok(this.featureService.getImage(featureId));
    }
}
