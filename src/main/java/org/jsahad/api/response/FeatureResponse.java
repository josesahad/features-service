package org.jsahad.api.response;

import java.util.UUID;

public class FeatureResponse {

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

    public FeatureResponse(UUID id, long timestamp, long beginViewingDate, long endViewingDate, String missionName) {
        this.id = id;
        this.timestamp = timestamp;
        this.beginViewingDate = beginViewingDate;
        this.endViewingDate = endViewingDate;
        this.missionName = missionName;
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
}
