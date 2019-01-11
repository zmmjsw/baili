package com.baili.dao.mysql.menu.entity;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
* @ClassName: BlMenu 
* @Description: TODO(百里菜单) 
* @author Yuanquan
* @date 2018年5月14日 下午4:02:45
 */
@Data
public class BlMenu implements Serializable {
	// @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String id;

    private String parentid;

    private String parentname;

    private String linkid;
    
    private String linkname;

    private String pageurl;

    private String filename;

    private List<BlMenu> children;
    /**
     * 排序
     */
    private Integer sort;

    private Integer type;

    private Integer flag;
    
    private String   icon;//个性标识
}