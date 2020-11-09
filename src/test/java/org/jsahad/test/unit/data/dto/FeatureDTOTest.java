package org.jsahad.test.unit.data.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.jsahad.data.access.StaticDatasetAccess;
import org.jsahad.data.dto.FeatureDTO;
import org.jsahad.model.Feature;

public class FeatureDTOTest {
    
    StaticDatasetAccess datasetAccess;

    private FeatureDTO featureDTO;

    @Before
    public void setup() {
        this.datasetAccess = mock(StaticDatasetAccess.class);
        this.featureDTO = new FeatureDTO(this.datasetAccess);
    }

    @Test
    public void listEmptyDataAccess() {
        when(this.datasetAccess.getDataMap()).thenReturn(new HashMap<UUID, Feature>());

        List<Feature> features = this.featureDTO.getFeatures();
        assertEquals(0, features.size());
    }
}
