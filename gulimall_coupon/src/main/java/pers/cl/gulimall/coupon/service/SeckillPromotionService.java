package pers.cl.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.cl.common.utils.PageUtils;
import pers.cl.gulimall.coupon.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-27 09:44:38
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

