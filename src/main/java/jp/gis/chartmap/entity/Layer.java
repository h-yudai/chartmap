package jp.gis.chartmap.entity;

import java.math.BigDecimal;

public class Layer {
    private String nodeId;

    private String nodeType;

    private String parentNodeId;

    private String layerId;

    private String layerName;

    private String layerType;

    private String layerUrl;

    private BigDecimal layerOpacity;

    private Integer layerOrder;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType == null ? null : nodeType.trim();
    }

    public String getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(String parentNodeId) {
        this.parentNodeId = parentNodeId == null ? null : parentNodeId.trim();
    }

    public String getLayerId() {
        return layerId;
    }

    public void setLayerId(String layerId) {
        this.layerId = layerId == null ? null : layerId.trim();
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName == null ? null : layerName.trim();
    }

    public String getLayerType() {
        return layerType;
    }

    public void setLayerType(String layerType) {
        this.layerType = layerType == null ? null : layerType.trim();
    }

    public String getLayerUrl() {
        return layerUrl;
    }

    public void setLayerUrl(String layerUrl) {
        this.layerUrl = layerUrl == null ? null : layerUrl.trim();
    }

    public BigDecimal getLayerOpacity() {
        return layerOpacity;
    }

    public void setLayerOpacity(BigDecimal layerOpacity) {
        this.layerOpacity = layerOpacity;
    }

    public Integer getLayerOrder() {
        return layerOrder;
    }

    public void setLayerOrder(Integer layerOrder) {
        this.layerOrder = layerOrder;
    }
}