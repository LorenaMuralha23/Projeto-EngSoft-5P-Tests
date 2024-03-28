package com.mycompany.demo.entities.enums;

/**
 *
 * @author alunolages
 */
public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getCodeString(){
        switch (this.code) {
            case 1:
                return "Waiting Payment";
            case 2:
                return "Paid";
            case 3:
                return "Shipped";
            case 4:
                return "Delivered";
            case 5:
                return "Canceled";
        }
        return null;
    }
    
    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code!");
    }

}
