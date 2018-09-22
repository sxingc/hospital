package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 医院表：为方便管理对医院信息的操作，包含医院编号、医院名称属性。
 * </p>
 *
 * @author chen
 * @since 2018-09-22
 */
@TableName("item_hospital")
public class Hospital extends Model<Hospital> {

    private static final long serialVersionUID = 1L;

    /**
     * 医院编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 医院名字
     */
    @TableField("hospital_name")
    private String hospitalName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Hospital{" +
        "id=" + id +
        ", hospitalName=" + hospitalName +
        "}";
    }
}
