package org.jsahad.model;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.jsahad.api.deserializer.CustomFeatureDeserializer;

@JsonDeserialize(using = CustomFeatureDeserializer.class)
public class Feature {

    private UUID id;

    private long timestamp;

    private long beginViewingDate;

    private long endViewingDate;

    private String missionName;

    private String quicklook;

    public Feature(UUID id, long timestamp, long beginViewingDate, long endViewingDate, String missionName, String quicklook) {
        this.id = id;
        this.timestamp = timestamp;
        this.beginViewingDate = beginViewingDate;
        this.endViewingDate = endViewingDate;
        this.missionName = missionName;
        this.quicklook = quicklook;
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

    public String getQuicklook() {
        return this.quicklook;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.timestamp, this.beginViewingDate, this.endViewingDate, this.missionName, this.quicklook);
    }

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
