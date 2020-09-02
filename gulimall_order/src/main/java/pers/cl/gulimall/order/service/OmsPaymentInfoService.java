package pers.cl.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.cl.common.utils.PageUtils;
import pers.cl.gulimall.order.entity.OmsPaymentInfoEntity;

import java.util.Map;

/**
 * 支付信息表
 *
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-27 10:14:19
 */
public interface OmsPaymentInfoService extends IService<OmsPaymentInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

