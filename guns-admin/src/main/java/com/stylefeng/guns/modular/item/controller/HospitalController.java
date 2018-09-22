package com.stylefeng.guns.modular.item.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Hospital;
import com.stylefeng.guns.modular.item.service.IHospitalService;

/**
 * 医院管理控制器
 *
 * @author fengshuonan
 * @Date 2018-09-22 23:23:29
 */
@Controller
@RequestMapping("/hospital")
public class HospitalController extends BaseController {

    private String PREFIX = "/item/hospital/";

    @Autowired
    private IHospitalService hospitalService;

    /**
     * 跳转到医院管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "hospital.html";
    }

    /**
     * 跳转到添加医院管理
     */
    @RequestMapping("/hospital_add")
    public String hospitalAdd() {
        return PREFIX + "hospital_add.html";
    }

    /**
     * 跳转到修改医院管理
     */
    @RequestMapping("/hospital_update/{hospitalId}")
    public String hospitalUpdate(@PathVariable Integer hospitalId, Model model) {
        Hospital hospital = hospitalService.selectById(hospitalId);
        model.addAttribute("item",hospital);
        LogObjectHolder.me().set(hospital);
        return PREFIX + "hospital_edit.html";
    }

    /**
     * 获取医院管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return hospitalService.selectList(null);
    }

    /**
     * 新增医院管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Hospital hospital) {
        hospitalService.insert(hospital);
        return SUCCESS_TIP;
    }

    /**
     * 删除医院管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer hospitalId) {
        hospitalService.deleteById(hospitalId);
        return SUCCESS_TIP;
    }

    /**
     * 修改医院管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Hospital hospital) {
        hospitalService.updateById(hospital);
        return SUCCESS_TIP;
    }

    /**
     * 医院管理详情
     */
    @RequestMapping(value = "/detail/{hospitalId}")
    @ResponseBody
    public Object detail(@PathVariable("hospitalId") Integer hospitalId) {
        return hospitalService.selectById(hospitalId);
    }
}
