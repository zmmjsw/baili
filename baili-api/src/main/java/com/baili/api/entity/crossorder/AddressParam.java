package com.baili.api.entity.crossorder;
import lombok.Data;
/**
 * 地址列表
 */
@Data
public class AddressParam {

    private Long   addressId;
    private String  fullName;
    private String  mobile;
    private String  phone;
    private String  postCode;
    private String  cityText;
    private String   provinceText;
    private String   areaText;
    private String   townText;
    private String   address;
    private String    districtCode;

    public AddressParam(String purchaseid){
        this.phone="0517-88990077";
        this.postCode="200000";
        this.address="浙江省 义乌市 北苑街道柳青八区9幢2单元4楼（义乌市仕辰贸易有限公司）"+purchaseid;
    }
}
