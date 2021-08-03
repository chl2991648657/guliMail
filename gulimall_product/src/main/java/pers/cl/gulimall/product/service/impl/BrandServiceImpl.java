package pers.cl.gulimall.product.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiniu.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.cl.common.utils.PageUtils;
import pers.cl.common.utils.Query;
import pers.cl.gulimall.product.dao.BrandDao;
import pers.cl.gulimall.product.entity.BrandEntity;
import pers.cl.gulimall.product.service.BrandService;
import pers.cl.gulimall.product.service.CategoryBrandRelationService;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Resource
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<BrandEntity>();

        if (!StrUtil.isBlank(key)){
            queryWrapper.eq("brand_id",key).or().like("name",key);
            IPage<BrandEntity> page =this.page(new Query<BrandEntity>().getPage(params),queryWrapper);

            return new PageUtils(page);
        }else {
            IPage<BrandEntity> page = this.page(
                    new Query<BrandEntity>().getPage(params),
                    new QueryWrapper<BrandEntity>()
            );
            return new PageUtils(page);
        }
    }

    @Override
    public void updateDetail(BrandEntity brand) {
        this.updateById(brand);

        if(!StringUtils.isNullOrEmpty(brand.getName())){
            categoryBrandRelationService.updateBrand(brand.getBrandId(),brand.getName());
            //TODO 更新其它关联
        }
    }

}