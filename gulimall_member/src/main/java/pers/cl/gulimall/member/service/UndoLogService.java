package pers.cl.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.cl.common.utils.PageUtils;
import pers.cl.gulimall.member.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-27 09:57:51
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

