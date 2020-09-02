package pers.cl.gulimall.coupon.dao;

import pers.cl.gulimall.coupon.entity.SkuFullReductionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品满减信息
 * 
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-27 09:44:38
 */
@Mapper
public interface SkuFullReductionDao extends BaseMapper<SkuFullReductionEntity> {
	
}
