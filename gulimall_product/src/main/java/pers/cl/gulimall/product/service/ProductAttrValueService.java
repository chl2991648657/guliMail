package pers.cl.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.cl.common.utils.PageUtils;
import pers.cl.gulimall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-24 15:33:43
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

