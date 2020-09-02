package pers.cl.gulimall.product.service.impl;

import com.qiniu.util.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.cl.common.utils.PageUtils;
import pers.cl.common.utils.Query;

import pers.cl.gulimall.product.dao.AttrGroupDao;
import pers.cl.gulimall.product.entity.AttrGroupEntity;
import pers.cl.gulimall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        String key = (String) params.get("key");
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>();

        if (catelogId == 0){
            if (!StringUtils.isNullOrEmpty(key)){
                wrapper.and((obj) -> {
                    obj.eq("attr_group_id",key).or().like("attr_group_name",key);
                });
            }
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
            return new PageUtils(page);
        }else {
            wrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id",catelogId);
            if (!StringUtils.isNullOrEmpty(key)){
                wrapper.and((obj) -> {
                    obj.eq("attr_group_id",key).or().like("attr_group_name",key);
                });

            }
        }
        IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
        return new PageUtils(page);

    }

}