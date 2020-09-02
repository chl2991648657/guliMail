package pers.cl.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.cl.common.utils.PageUtils;
import pers.cl.gulimall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-27 09:57:51
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

