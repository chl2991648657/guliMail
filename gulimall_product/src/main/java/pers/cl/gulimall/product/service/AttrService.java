package pers.cl.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.cl.common.utils.PageUtils;
import pers.cl.gulimall.product.entity.AttrEntity;
import pers.cl.gulimall.product.vo.AttrRelationVo;
import pers.cl.gulimall.product.vo.AttrResponseVo;
import pers.cl.gulimall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-24 15:33:43
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String attrType);

    AttrResponseVo getResponseVoById(Long attrId);

    void updateAttrVo(AttrVo attr);

    List<AttrEntity> getRelationAttr(Long attrGroupId);

    void removeRelation(AttrRelationVo[] attrVos);

    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrGroupId);

}

