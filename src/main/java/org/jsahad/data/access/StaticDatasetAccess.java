package org.jsahad.data.access;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jsahad.model.Feature;
import org.jsahad.model.FeatureCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * StaticDataAccess class. This is specialized for @org.jsahad.model.Feature to
 * enable the current use case. This is going to be initialized with the
 * corresponding JSON static data file.
 */
@Component
public class StaticDatasetAccess {

    private static Logger LOGGER = LoggerFactory.getLogger(StaticDatasetAccess.class);

    /**
     * In memory data.
     */
    Map<UUID, Feature> dataMap;

    /**
     * Builds the DatasetAccess.
     * 
     * @throws InvocationTargetException
     */
    public StaticDatasetAccess(@Value("${data.static.jsonFile}") String jsonDataFilePath)
            throws InvocationTargetException {
        ObjectMapper mapper = new ObjectMapper();
        List<FeatureCollection> featureCollectionList = new ArrayList<>();

        try {
            featureCollectionList = mapper.readValue(Paths.get(jsonDataFilePath).toFile(), new TypeReference<List<FeatureCollection>>(){});
        } catch (IOException e) {
            LOGGER.error("The data file {} was not processed correctly. Please check the path and configuration, and re-run the application", jsonDataFilePath);
            throw new InvocationTargetException(e);
        }

        dataMap = new HashMap<>();
        featureCollectionList.forEach(featureCollection -> {
            featureCollection.getFeatures().forEach(feature -> {
                dataMap.put(feature.getId(), feature);
            });
        });    
    }
    
    /**
     * Retrieves the data map.
     * 
     * @return the dataset.
     */
    public Map<UUID, Feature> getDataMap() {
        return dataMap;
    }
}
