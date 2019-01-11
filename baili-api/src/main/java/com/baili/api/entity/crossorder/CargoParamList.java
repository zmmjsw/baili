package com.baili.api.entity.crossorder;
import lombok.Data;

/**
 * 创建订单信息
 */

@Data
public class CargoParamList {
    private Long offerId;
    private String specId;
    private Double quantity;

}
