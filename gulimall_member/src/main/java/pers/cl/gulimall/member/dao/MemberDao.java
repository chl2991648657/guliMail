package pers.cl.gulimall.member.dao;

import pers.cl.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-27 09:57:51
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
