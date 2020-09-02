package pers.cl.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.cl.common.utils.PageUtils;
import pers.cl.gulimall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-27 10:23:15
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

