package com.custanalytics.demo.clinicalmanager.entity;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by were on 8/3/2016.
 */
@MappedSuperclass
public class BaseEntity {

    Date created;
    Date updated;
    Long createdBy;
    Long updatedBy;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
}
