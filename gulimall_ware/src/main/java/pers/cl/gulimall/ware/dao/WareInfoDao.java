package pers.cl.gulimall.ware.dao;

import pers.cl.gulimall.ware.entity.WareInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-27 10:23:15
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
