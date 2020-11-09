package org.jsahad.test.unit.api.transformer;

import static org.junit.Assert.assertEquals;

import org.jsahad.api.response.FeatureResponse;
import org.jsahad.api.transformer.FeatureTransformer;
import org.jsahad.model.Feature;
import org.jsahad.test.TestUtils;
import org.junit.Before;
import org.junit.Test;

public class FeatureTransformerTest {
    
    private FeatureTransformer featureTransformer;

    @Before
    public void setup() {
        featureTransformer = new FeatureTransformer();
    }

    @Test
    public void testTransformFeature() {
        Feature feature = TestUtils.buildFeature("Sentinel1");

        FeatureResponse featureResponse = featureTransformer.transform(feature);
        assertEquals(feature.getId(), featureResponse.getId());
        assertEquals(feature.getTimestamp(), featureResponse.getTimestamp());
        assertEquals(feature.getBeginViewingDate(), featureResponse.getBeginViewingDate());
        assertEquals(feature.getEndViewingDate(), featureResponse.getEndViewingDate());
        assertEquals(feature.getMissionName(), featureResponse.getMissionName());
    }
}
