package com.stylefeng.guns.modular.item.service.impl;

import com.stylefeng.guns.modular.system.model.Depart;
import com.stylefeng.guns.modular.system.dao.DepartMapper;
import com.stylefeng.guns.modular.item.service.IDepartService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 科室表：包含科室编号、科室名称属性 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-09-22
 */
@Service
public class DepartServiceImpl extends ServiceImpl<DepartMapper, Depart> implements IDepartService {

}
