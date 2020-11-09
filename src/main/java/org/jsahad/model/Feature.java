package org.jsahad.model;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.jsahad.api.deserializer.CustomFeatureDeserializer;

@JsonDeserialize(using = CustomFeatureDeserializer.class)
public class Feature {

    /**
     * Feature id.
     */
    private UUID id;

    /**
     * Feature's timestamp.
     */
    private long timestamp;

    /**
     * Feature's begin viewing date.
     */
    private long beginViewingDate;

    /**
     * Feature's end viewing date.
     */
    private long endViewingDate;

    /**
     * Name of the mission for the feature.
     */
    private String missionName;

    /**
     * Feature's image quicklook in base64.
     */
    private String quicklook;

    /**
     * Builds the feature.
     * 
     * @param id            id for the feature.
     * @param timestamp     feature's timestamp.
     * @param beginViewingDate  
     * @param endViewingDate
     * @param missionName
     * @param quicklook
     * 
     */
    public Feature(UUID id, long timestamp, long beginViewingDate, long endViewingDate, String missionName, String quicklook) {
        this.id = id;
        this.timestamp = timestamp;
        this.beginViewingDate = beginViewingDate;
        this.endViewingDate = endViewingDate;
        this.missionName = missionName;
        this.quicklook = quicklook;
    }

    /**
     * Retrieves the id for the feature.
     * 
     * @return feature id.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Retrieves Feature's timestamp.
     * 
     * @return feature's timestamp.
     */
    public long getTimestamp() {
        return this.timestamp;
    }

    /**
     * Retrieves Feature's begin viewing date.
     * 
     * @return feature's begin viewing date.
     */
    public long getBeginViewingDate() {
        return this.beginViewingDate;
    }

    /**
     * Retrieves Feature's end viewing date.
     * 
     * @return feature's end viewing date.
     */
    public long getEndViewingDate() {
        return this.endViewingDate;
    }

    /**
     * Retrieves Feature's mission name.
     * 
     * @return feature's mission name.
     */
    public String getMissionName() {
        return this.missionName;
    }

    /**
     * Retrieves the feature's image quicklook in base64.
     * 
     * @return image in base64.
     */
    public String getQuicklook() {
        return this.quicklook;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Feature feature = (Feature) o;
        return Objects.equals(this.id, feature.id)
                && Objects.equals(this.timestamp, feature.timestamp)
                && Objects.equals(this.beginViewingDate, feature.beginViewingDate)
                && Objects.equals(this.endViewingDate, feature.endViewingDate)
                && Objects.equals(this.missionName, feature.missionName)
                && Objects.equals(this.quicklook, feature.quicklook);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.timestamp, this.beginViewingDate, this.endViewingDate, this.missionName, this.quicklook);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Feature{"
                + "id=" + this.id
                + ", timestamp=" + this.timestamp
                + ", beginViewingDate='" + this.beginViewingDate
                + ", endViewingDate='" + this.endViewingDate
                + ", missionName='" + this.missionName
                + '}';
    }

}
