package link.codegen.salesforce.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public abstract class AbstractSObject<T extends SObjectType> implements SObjectInterface {
    protected AbstractSObject(T type) {
        this.attributes = new SObjectAttributes<>(type, null);
    }

    @JsonProperty("Id") public String id;
    SObjectAttributes<T> attributes;

    @JsonProperty("CreatedById") public String createdById;
    public String getCreatedById() {
        return createdById;
    }
    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    @JsonProperty("CreatedDate") public ZonedDateTime createdDate;
    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("IsDeleted") public Boolean isDeleted;
    public Boolean getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonProperty("LastModifiedById") public String lastModifiedById;
    public String getLastModifiedById() {
        return lastModifiedById;
    }
    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    @JsonProperty("LastModifiedDate") public ZonedDateTime lastModifiedDate;
    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @JsonProperty("OwnerId") public String ownerId;
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @JsonProperty("SystemModstamp") public ZonedDateTime systemModstamp;
    public ZonedDateTime getSystemModstamp() {
        return systemModstamp;
    }
    public void setSystemModstamp(ZonedDateTime systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    @JsonProperty("UserRecordAccessId") public String userRecordAccessId;
    public String getUserRecordAccessId() {
        return userRecordAccessId;
    }
    public void setUserRecordAccessId(String userRecordAccessId) {
        this.userRecordAccessId = userRecordAccessId;
    }
}
