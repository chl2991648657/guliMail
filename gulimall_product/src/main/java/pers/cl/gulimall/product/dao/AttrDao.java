package pers.cl.gulimall.product.dao;

import pers.cl.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 * 
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-24 15:33:43
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	
}
