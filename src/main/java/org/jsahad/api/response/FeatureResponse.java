package org.jsahad.api.response;

import java.util.UUID;

public class FeatureResponse {

    private UUID id;

    private long timestamp;

    private long beginViewingDate;

    private long endViewingDate;

    private String missionName;

    public FeatureResponse(UUID id, long timestamp, long beginViewingDate, long endViewingDate, String missionName) {
        this.id = id;
        this.timestamp = timestamp;
        this.beginViewingDate = beginViewingDate;
        this.endViewingDate = endViewingDate;
        this.missionName = missionName;
    }

    public UUID getId() {
        return this.id;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getBeginViewingDate() {
        return this.beginViewingDate;
    }

    public long getEndViewingDate() {
        return this.endViewingDate;
    }

    public String getMissionName() {
        return this.missionName;
    }
}
