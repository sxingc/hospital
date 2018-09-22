package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 科室表：包含科室编号、科室名称属性
 * </p>
 *
 * @author stylefeng
 * @since 2018-09-22
 */
@TableName("item_depart")
public class Depart extends Model<Depart> {

    private static final long serialVersionUID = 1L;

    /**
     * 科室编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 科室名称
     */
    @TableField("depart_name")
    private String departName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Depart{" +
        "id=" + id +
        ", departName=" + departName +
        "}";
    }
}
