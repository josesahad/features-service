package org.jsahad.service.impl;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.jsahad.data.dto.FeatureDTO;
import org.jsahad.model.Feature;
import org.jsahad.model.exception.FeatureNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeatureService {

    private final FeatureDTO featureDTO;

    @Autowired
    public FeatureService(FeatureDTO featureDTO) {
        this.featureDTO = featureDTO;
    }

	public List<Feature> listFeatures() {
		return this.featureDTO.getFeatures();
    }
    
    public Feature getFeature(UUID featureId) {
        return this.featureDTO.getFeature(featureId).orElseThrow(() -> new FeatureNotFoundException(featureId));
    }

    public byte[] getImage(UUID featureId) {
        return decodeBase64Image(this.featureDTO.getFeature(featureId).orElseThrow(() -> new FeatureNotFoundException(featureId)).getQuicklook());
    }

    private byte[] decodeBase64Image(String base64Image) {
        return Base64.getDecoder().decode(base64Image);
    }
}
