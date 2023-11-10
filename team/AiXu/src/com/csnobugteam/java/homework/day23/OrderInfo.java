package com.csnobugteam.java.homework.day23;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单信息
 *
 * @author aixu
 * @since 2023/11/10
 */
public class OrderInfo {
    private String orderPlacer;
    private String orderAmount;
    private Date orderTime;

    public String getOrderPlacer() {
        return orderPlacer;
    }

    public void setOrderPlacer(String orderPlacer) {
        this.orderPlacer = orderPlacer;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
/**
 * 有一批订单信息，订单信息包括 下单人，下单金额，下单时间
 * 1.现在想找出最大的下单金额对应的下单人
 * 2.想找出2022-2023年下单的所有订单信息
 * 3.删除低于平均下单金额的账单
 */

class OrderInfoUtil{

    // 1.现在想找出最大的下单金额对应的下单人
    public String findOrderAmountMax(List<OrderInfo> orderInfos) {
        OrderInfo temp = new OrderInfo();
        temp.setOrderAmount("-1");
        for (OrderInfo orderInfo : orderInfos) {
            int amount = Integer.parseInt(orderInfo.getOrderAmount());
            int tempAmount = Integer.parseInt(temp.getOrderAmount());
            if (amount > tempAmount) {
                temp = orderInfo;
            }
        }
        return temp.getOrderPlacer();
    }

    // 2.想找出2022-2023年下单的所有订单信息
    public List<OrderInfo> findOrderTimeBetween2022And2023(List<OrderInfo> orderInfos) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        List<OrderInfo> tempList = new ArrayList<>();
        for (OrderInfo orderInfo : orderInfos) {
            // 得到Date中的年
            int year = Integer.parseInt(sdf.format(orderInfo.getOrderTime()));
            // 符合2022-2023年下单的所有订单信息
            if (year >= 2022 && year<= 2023) {
                tempList.add(orderInfo);
            }
        }

        return tempList;
    }

    // 3.删除低于平均下单金额的账单
    public List<OrderInfo> delOrderByAverDown(List<OrderInfo> orderInfos) {
        double aver = getAverAmount(orderInfos);
        // 临时订单
        List<OrderInfo> tempOrders = new ArrayList<>();
        // 筛选出，低于平均下单金额的账单，放入临时订单中
        for (OrderInfo orderInfo : orderInfos) {
            double amount = Double.parseDouble(orderInfo.getOrderAmount());
            if (amount < aver) {
                tempOrders.add(orderInfo);
            }
        }
        if (!tempOrders.isEmpty()) {
            for (OrderInfo tempOrder : tempOrders) {
                // 移除满足条件的订单
                orderInfos.remove(tempOrder);
            }
        }

        return orderInfos;
    }

    private Double getAverAmount(List<OrderInfo> orderInfos) {
        double sum = 0.0;
        int count = 0;
        for (OrderInfo orderInfo : orderInfos) {
            sum += Double.parseDouble(orderInfo.getOrderAmount());
            count++;
        }
        return sum / count;
    }
}