package org.jsahad.api.deserializer;

import java.io.IOException;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import org.jsahad.model.Feature;

public class CustomFeatureDeserializer extends StdDeserializer<Feature> {

    /**
     * Default SerialVersionId.
     */
    private static final long serialVersionUID = 1L;

    public CustomFeatureDeserializer() {
        this(null);
    }

    public CustomFeatureDeserializer(Class<?> vc) {
        super(vc);
    }

    /**
     * @{inheritDoc}
     */
    @Override
    public Feature deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        UUID id = UUID.fromString(node.get("properties").get("id").asText());
        long timestamp = 0;
        long beginViewingDate = 0;
        long endViewingDate = 0;
        String missionName = null;
        String quicklook = null;

        if (node.has("properties")) {
            if (node.get("properties").has("timestamp")) timestamp = node.get("properties").get("timestamp").asLong();

            if (node.get("properties").has("acquisition")) {
                if (node.get("properties").get("acquisition").has("beginViewingDate")) beginViewingDate = node.get("properties").get("acquisition").get("beginViewingDate").asLong(0);
                if (node.get("properties").get("acquisition").has("endViewingDate")) endViewingDate = node.get("properties").get("acquisition").get("endViewingDate").asLong(0);
                if (node.get("properties").get("acquisition").has("missionName")) missionName = node.get("properties").get("acquisition").get("missionName").asText("");
            }
        
            if (node.get("properties").has("quicklook")) quicklook = node.get("properties").get("quicklook").asText("");
        }

        return new Feature(id, timestamp, beginViewingDate, endViewingDate, missionName, quicklook);
    }
}
