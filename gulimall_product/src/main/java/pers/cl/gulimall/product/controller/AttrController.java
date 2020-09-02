package pers.cl.gulimall.product.controller;

import org.springframework.web.bind.annotation.*;
import pers.cl.common.utils.PageUtils;
import pers.cl.common.utils.R;
import pers.cl.gulimall.product.service.AttrService;
import pers.cl.gulimall.product.vo.AttrResponseVo;
import pers.cl.gulimall.product.vo.AttrVo;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;


/**
 * 商品属性
 *
 * @author chenlin
 * @email chenlin@congine.cn
 * @date 2020-07-24 16:25:37
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Resource
    private AttrService attrService;

    /**
     * 查询基础列表
     * */
    @GetMapping("/{attr_type}/list/{catelogId}")
    public R baseList(@RequestParam Map<String, Object> params,
                      @PathVariable("catelogId") Long catelogId,
                      @PathVariable("attr_type") String attrType){
        PageUtils page = attrService.queryBaseAttrPage(params,catelogId,attrType);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
		AttrResponseVo attrResponseVo = attrService.getResponseVoById(attrId);

        return R.ok().put("attr", attrResponseVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrVo attr){
		//attrService.updateById(attr);
        attrService.updateAttrVo(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
