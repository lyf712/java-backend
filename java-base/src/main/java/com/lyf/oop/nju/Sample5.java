package com.lyf.oop.nju;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liyunfei
 */
class Commodity {
    
    private int commodityId;
    
    double price;
    
    public Commodity(int commodityId, double price) {
        this.commodityId = commodityId;
        this.price = price;
    }
    
    public int getCommodityId() {
        return commodityId;
    }
    
    public double getPrice() {
        return price;
    }
}

class CommodityList {
    
    private static ArrayList<Commodity> commodities = new ArrayList<>();
    
    static {
        // load all commodity
    }
    
    public static Commodity findCommodityById(int id) {
        AtomicReference<Commodity> commodity = null;
        commodities.forEach(c -> {
            if (c.getCommodityId() == id) {
                commodity.set(c);
            }
        });
        return commodity.get();
    }
}

class OrderLineItem {
    
    int num;
    
    int commodityId;
    
    public OrderLineItem(int num, int commodityId) {
        this.num = num;
        this.commodityId = commodityId;
    }
    
    public double sum() {
        return CommodityList.
                findCommodityById(commodityId).getPrice() * num;// -
    }
}

class Order {
    
    ArrayList<OrderLineItem> orderLineItems = new ArrayList<>();
    
    public double total() {
        return orderLineItems.stream()
                .mapToDouble(OrderLineItem::sum)
                .sum();
    }
}

public class Sample5 {

}
