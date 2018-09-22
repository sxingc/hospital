package com.stylefeng.guns.modular.item.service.impl;

import com.stylefeng.guns.modular.system.model.Hospital;
import com.stylefeng.guns.modular.system.dao.HospitalMapper;
import com.stylefeng.guns.modular.item.service.IHospitalService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 医院表：为方便管理对医院信息的操作，包含医院编号、医院名称属性。 服务实现类
 * </p>
 *
 * @author chen
 * @since 2018-09-22
 */
@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements IHospitalService {

}
