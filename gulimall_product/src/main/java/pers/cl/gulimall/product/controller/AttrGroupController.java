package pers.cl.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pers.cl.gulimall.product.entity.AttrEntity;
import pers.cl.gulimall.product.entity.AttrGroupEntity;
import pers.cl.gulimall.product.service.AttrGroupService;
import pers.cl.common.utils.PageUtils;
import pers.cl.common.utils.R;
import pers.cl.gulimall.product.service.AttrService;
import pers.cl.gulimall.product.service.CategoryService;
import pers.cl.gulimall.product.vo.AttrRelationVo;
import pers.cl.gulimall.product.vo.AttrVo;


/**
 * 属性分组
 *
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-24 16:25:37
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    AttrService attrService;

    @RequestMapping("/attr/relation/delete")
    public R deleteRelation(AttrRelationVo[] attrRelationVos){
        attrService.removeRelation(attrRelationVos);
        return R.ok();
    }

    @GetMapping("/{Id}/attr/relation")
    public R attrRelation(@PathVariable("Id") Long attrGroupId){
        List<AttrEntity> entities = attrService.getRelationAttr(attrGroupId);
        return R.ok().put("data", entities);
    }

    @GetMapping("/{attrGroupId}/noattr/relation")
    public R attrNoRelation(@PathVariable("attrGroupId") Long attrGroupId,@RequestParam Map<String, Object> params){
        PageUtils page = attrService.getNoRelationAttr(params,attrGroupId);
        return R.ok().put("page", page);
    }
    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    public R list(@PathVariable("catelogId")Long catelogId,@RequestParam Map<String, Object> params){
//        PageUtils page = attrGroupService.queryPage(params);
        PageUtils page = attrGroupService.queryPage(params,catelogId);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
		Long catelogId = attrGroup.getCatelogId();
        Long[] path = categoryService.findCategroyPath(catelogId);

        attrGroup.setCatelogPath(path);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
