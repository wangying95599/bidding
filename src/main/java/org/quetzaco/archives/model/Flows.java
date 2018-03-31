package org.quetzaco.archives.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Flows {
    private Long id;

    private String type;

    private String status ;

    private String result = "";

    private Date createdDt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadLine;

    private Date endDt;

    private Long createdBy;

    private Boolean recordFlag = true;

    private List<FlowNodes> nodes;

    private List<FlowNodeHistories> nodeHistories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getRecordFlag() {
        return recordFlag;
    }

    public void setRecordFlag(Boolean recordFlag) {
        this.recordFlag = recordFlag;
    }

    public List<FlowNodeHistories> getNodeHistories() {
        return nodeHistories;
    }

    public void setNodeHistories(List<FlowNodeHistories> nodeHistories) {
        this.nodeHistories = nodeHistories;
    }

    public List<FlowNodes> getNodes() {
        return nodes;
    }

    public void setNodes(List<FlowNodes> nodes) {
        this.nodes = nodes;
    }
}