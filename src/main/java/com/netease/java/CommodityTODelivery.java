package com.netease.java;

import java.util.List;

public class CommodityTODelivery {
    private String commodityId;
    private List<String> deliveryCommodityId;
    public String getCommodityId() {
        return commodityId;
    }
    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }
    public List<String> getDeliveryCommodityId() {
        return deliveryCommodityId;
    }
    public void setDeliveryCommodityIds(List<String> deliveryCommodityId) {
        this.deliveryCommodityId = deliveryCommodityId;
    }
    @Override
    public String toString() {
        return "CommodityTODelivery [commodityId=" + commodityId + ", deliveryCommodityId=" + deliveryCommodityId + "]";
    }
}
