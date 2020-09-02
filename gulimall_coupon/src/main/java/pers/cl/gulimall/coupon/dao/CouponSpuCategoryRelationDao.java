package pers.cl.gulimall.coupon.dao;

import pers.cl.gulimall.coupon.entity.CouponSpuCategoryRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券分类关联
 * 
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-27 09:44:37
 */
@Mapper
public interface CouponSpuCategoryRelationDao extends BaseMapper<CouponSpuCategoryRelationEntity> {
	
}
