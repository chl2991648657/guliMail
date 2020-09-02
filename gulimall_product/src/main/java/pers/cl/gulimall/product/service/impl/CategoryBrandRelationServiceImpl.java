package pers.cl.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.cl.common.utils.PageUtils;
import pers.cl.common.utils.Query;

import pers.cl.gulimall.product.dao.BrandDao;
import pers.cl.gulimall.product.dao.CategoryBrandRelationDao;
import pers.cl.gulimall.product.dao.CategoryDao;
import pers.cl.gulimall.product.entity.BrandEntity;
import pers.cl.gulimall.product.entity.CategoryBrandRelationEntity;
import pers.cl.gulimall.product.entity.CategoryEntity;
import pers.cl.gulimall.product.service.CategoryBrandRelationService;

import javax.annotation.Resource;

@Slf4j
@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Resource
    CategoryDao categoryDao;

    @Resource
    BrandDao brandDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveDetail(CategoryBrandRelationEntity categoryBrandRelation) {
        Long brandId = categoryBrandRelation.getBrandId();
        Long catelogId = categoryBrandRelation.getCatelogId();

        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        BrandEntity brandEntity = brandDao.selectById(brandId);

        categoryBrandRelation.setBrandName(brandEntity.getName());
        categoryBrandRelation.setCatelogName(categoryEntity.getName());
        this.save(categoryBrandRelation);
    }

    @Override
    public void updateBrand(Long brandId, String name) {
        CategoryBrandRelationEntity relationEntity = new CategoryBrandRelationEntity();
        relationEntity.setBrandId(brandId);
        relationEntity.setBrandName(name);
        this.update(relationEntity,new UpdateWrapper<CategoryBrandRelationEntity>().eq("brand_id",brandId));
    }

    @Override
    public void updateCategory(Long catId, String name) {
        /*在CategoryBrandRelationDao.xml配置的sql语句*/
          this.baseMapper.updateCategory(catId,name);
//        CategoryBrandRelationEntity relationEntity = new CategoryBrandRelationEntity();
//        relationEntity.setCatelogId(catId);
//        relationEntity.setCatelogName(name);
//        this.update(relationEntity,new UpdateWrapper<CategoryBrandRelationEntity>().eq("catelog_id",catId));
    }

}