package pers.cl.gulimall.member.dao;

import pers.cl.gulimall.member.entity.MemberStatisticsInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员统计信息
 * 
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-27 09:57:51
 */
@Mapper
public interface MemberStatisticsInfoDao extends BaseMapper<MemberStatisticsInfoEntity> {
	
}
