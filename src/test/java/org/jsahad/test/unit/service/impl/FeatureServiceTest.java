package org.jsahad.test.unit.service.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jsahad.data.dto.FeatureDTO;
import org.jsahad.model.Feature;
import org.jsahad.model.exception.FeatureNotFoundException;
import org.jsahad.service.impl.FeatureService;
import org.jsahad.test.TestUtils;

public class FeatureServiceTest {
    
    FeatureDTO featureDTO;

    private FeatureService featureService;

    @Before
    public void setup() {
        this.featureDTO = mock(FeatureDTO.class);
        this.featureService = new FeatureService(featureDTO);
    }

    @Test
    public void listFeaturesTest() {
        when(this.featureDTO.getFeatures()).thenReturn(TestUtils.buildFeatureList());

        List<Feature> features = featureService.listFeatures();
        assertEquals(2, features.size());
    }

    @Test
    public void getFeatureTest() {
        UUID featureUUID = UUID.fromString("39c2f29e-c0f8-4a39-a98b-deed547d6aea");
        String missionName = "mission-1";
        Feature feature = TestUtils.buildFeature(featureUUID, missionName);
        when(this.featureDTO.getFeature(any(UUID.class))).thenReturn(Optional.ofNullable(feature));

        Feature featureFromService = this.featureService.getFeature(featureUUID);

        assertEquals(feature.getId(), featureFromService.getId());
        assertEquals(feature.getTimestamp(), featureFromService.getTimestamp());
        assertEquals(feature.getBeginViewingDate(), featureFromService.getBeginViewingDate());
        assertEquals(feature.getEndViewingDate(), featureFromService.getEndViewingDate());
        assertEquals(feature.getMissionName(), featureFromService.getMissionName());
        assertEquals(feature.getQuicklook(), featureFromService.getQuicklook());
    }

    @Test(expected = FeatureNotFoundException.class)
    public void getFeatureNonExistentTest() {
        when(this.featureDTO.getFeature(any(UUID.class))).thenReturn(Optional.ofNullable(null));

        this.featureService.getFeature(UUID.randomUUID());
    }

    @Test
    public void getFeatureQuicklookTest() {
        UUID featureUUID = UUID.fromString("39c2f29e-c0f8-4a39-a98b-deed547d6aea");
        String missionName = "mission-1";
        String quicklook = TestUtils.buildImageQuicklookString();
        Feature feature = TestUtils.buildFeature(featureUUID, missionName, quicklook);

        when(this.featureDTO.getFeature(any(UUID.class))).thenReturn(Optional.ofNullable(feature));

        byte[] image = this.featureService.getImage(UUID.randomUUID());

        assertEquals(Base64.getDecoder().decode(quicklook).length, image.length);
    }

    @Test(expected = FeatureNotFoundException.class)
    public void getFeatureNonExistentQuicklookTest() {
        when(this.featureDTO.getFeature(any(UUID.class))).thenReturn(Optional.ofNullable(null));

        this.featureService.getImage(UUID.randomUUID());
    }
}
