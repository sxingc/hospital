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
import com.stylefeng.guns.modular.system.model.Depart;
import com.stylefeng.guns.modular.item.service.IDepartService;

/**
 * 科室管理控制器
 *
 * @author fengshuonan
 * @Date 2018-09-22 21:21:14
 */
@Controller
@RequestMapping("/depart")
public class DepartController extends BaseController {

    private String PREFIX = "/item/depart/";

    @Autowired
    private IDepartService departService;

    /**
     * 跳转到科室管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "depart.html";
    }

    /**
     * 跳转到添加科室管理
     */
    @RequestMapping("/depart_add")
    public String departAdd() {
        return PREFIX + "depart_add.html";
    }

    /**
     * 跳转到修改科室管理
     */
    @RequestMapping("/depart_update/{departId}")
    public String departUpdate(@PathVariable Integer departId, Model model) {
        Depart depart = departService.selectById(departId);
        model.addAttribute("item",depart);
        LogObjectHolder.me().set(depart);
        return PREFIX + "depart_edit.html";
    }

    /**
     * 获取科室管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return departService.selectList(null);
    }

    /**
     * 新增科室管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Depart depart) {
        departService.insert(depart);
        return SUCCESS_TIP;
    }

    /**
     * 删除科室管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer departId) {
        departService.deleteById(departId);
        return SUCCESS_TIP;
    }

    /**
     * 修改科室管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Depart depart) {
        departService.updateById(depart);
        return SUCCESS_TIP;
    }

    /**
     * 科室管理详情
     */
    @RequestMapping(value = "/detail/{departId}")
    @ResponseBody
    public Object detail(@PathVariable("departId") Integer departId) {
        return departService.selectById(departId);
    }
}
