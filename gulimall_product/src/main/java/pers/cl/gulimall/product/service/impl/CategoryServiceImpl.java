package pers.cl.gulimall.product.service.impl;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.cl.common.utils.PageUtils;
import pers.cl.common.utils.Query;

import pers.cl.gulimall.product.dao.CategoryDao;
import pers.cl.gulimall.product.entity.CategoryEntity;
import pers.cl.gulimall.product.service.CategoryBrandRelationService;
import pers.cl.gulimall.product.service.CategoryService;

import javax.annotation.Resource;

@Slf4j
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Resource
    CategoryDao categoryDao;

    @Resource
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> treeList() {
        List<CategoryEntity> entities = categoryDao.selectList(null);

        //取出1级菜单
        return entities.stream().filter(categoryEntity -> {
            return categoryEntity.getCatLevel() == 1;
        }).map(menu->{
            menu.setChildren(getChildren(menu,entities));
            return menu;
        }).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))).collect(Collectors.toList());
    }

    @Override
    public void removeMenusByIds(List<Long> asList) {
        //TODO 检查要删除的节点是否被引用
        categoryDao.deleteBatchIds(asList);
    }

    private List<CategoryEntity> getChildren(CategoryEntity entity,List<CategoryEntity> entities){

        return entities.stream().filter(categoryEntity->{
                return categoryEntity.getParentCid().equals(entity.getCatId());
        }).map(menu -> {
            menu.setChildren(getChildren(menu,entities));
            return menu;
        }).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))).collect(Collectors.toList());
    }

    @Override
    public Long[] findCategroyPath(Long catelogId) {
        ArrayList<Long> path = new ArrayList<>();
        path.add(catelogId);
        CategoryEntity categoryEntity = this.getById(catelogId);
        while (categoryEntity.getParentCid() != 0 && categoryEntity.getParentCid() != null){
             path.add(categoryEntity.getParentCid());
             categoryEntity=this.getById(categoryEntity.getParentCid());
        }
        //排序规则
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Long num1 = (Long)o1;
                Long num2 = (Long)o2;
                if (num2 < num1) {
                    num1 = num1 + num2;
                    num2 = num1 - num2;
                    num1 = num1 - num2;
                    return 1;
                }else {
                    return -1;
                }
            }
        };
        log.info(path.toString());
        path.sort(c);
        log.info(path.toString());
        return (Long[])path.toArray(new Long[path.size()]);
    }

    /**
     * 级联更新数据(分类)
     * */
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);

        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());
    }
}