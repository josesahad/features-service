package org.jsahad.test.unit.api.deserializer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.assertj.core.util.Lists;
import org.jsahad.model.Feature;
import org.jsahad.model.FeatureCollection;
import org.junit.Before;
import org.junit.Test;

public class CustomFeatureDeserializerTest {

    private ObjectMapper objectMapper;

    private static final String JSON_SIMPLE_DATA_FILE = "src/test/resources/simple-data-test.json";
    private static final String JSON_SIMPLE_MISSING_ATTR_DATA_FILE = "src/test/resources/simple-data-missing-attr-test.json";
    private static final String JSON_DATA_FILE = "src/test/resources/source-data-test.json";

    @Before
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void simpleFeatureStaticDataTest() throws JsonParseException, JsonMappingException, IOException {
        Feature feature = this.objectMapper.readValue(Paths.get(JSON_SIMPLE_DATA_FILE).toFile(), new TypeReference<Feature>(){});

        assertEquals(UUID.fromString("39c2f29e-c0f8-4a39-a98b-deed547d6aea"), feature.getId());
        assertEquals(1554831167697L, feature.getTimestamp());
        assertEquals(1554831167697L, feature.getBeginViewingDate());
        assertEquals(1554831202043L, feature.getEndViewingDate());
        assertEquals("Sentinel-1B", feature.getMissionName());
        assertEquals("iVBORw0KGgoAAAANSUhEUgAAAgAAAAHRCAIAAACTkJa6AAEAAElEQVR4nOz9SZMkSZImivEmIqpm5ktE5FZZW1d3T/dMD703jwDCDSDccMNf", feature.getQuicklook());
    }

    @Test
    public void simpleFeatureMissingAttributesStaticDataTest() throws JsonParseException, JsonMappingException, IOException {
        Feature feature = this.objectMapper.readValue(Paths.get(JSON_SIMPLE_MISSING_ATTR_DATA_FILE).toFile(), new TypeReference<Feature>(){});

        assertEquals(UUID.fromString("39c2f29e-c0f8-4a39-a98b-deed547d6aea"), feature.getId());
        assertEquals(1554831167697L, feature.getTimestamp());
        assertEquals(0L, feature.getBeginViewingDate());
        assertEquals(0L, feature.getEndViewingDate());
        assertEquals("Sentinel-1B", feature.getMissionName());
        assertEquals(null, feature.getQuicklook());
    }

    @Test
    public void FeatureCollectionStaticDataTest() throws JsonParseException, JsonMappingException, IOException {
        Feature feature1 = new Feature(UUID.fromString("39c2f29e-c0f8-4a39-a98b-deed547d6aea"), 1554831167697L, 1554831167697L, 1554831202043L, "Sentinel-1B", "quicklook1"); 
        Feature feature2 = new Feature(UUID.fromString("cf5dbe37-ab95-4af1-97ad-2637aec4ddf0"), 1556904743783L, 1556904743783L, 1556904768781L, "Sentinel-1A", "quicklook2");
     
        List<FeatureCollection> featureCollectionList = Lists.newArrayList(new FeatureCollection(Lists.newArrayList(feature1)), 
            new FeatureCollection(Lists.newArrayList(feature2))); 
        
        List<FeatureCollection> featureCollectionFromFile = this.objectMapper.readValue(Paths.get(JSON_DATA_FILE).toFile(),
                new TypeReference<List<FeatureCollection>>() {
                });

        assertEquals(featureCollectionList, featureCollectionFromFile);
    }

}
