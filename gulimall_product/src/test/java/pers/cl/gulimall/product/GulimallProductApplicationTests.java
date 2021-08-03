package pers.cl.gulimall.product;

import cn.hutool.core.util.HexUtil;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pers.cl.gulimall.product.entity.BrandEntity;
import pers.cl.gulimall.product.service.BrandService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class GulimallProductApplicationTests {

    @Resource
    BrandService brandService;

    @Test
    void contextLoads() {
        //System.out.println(StringUtils.isNullOrEmpty("key"));
//        BrandEntity brandEntity = new BrandEntity();
//
//        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("show_status",1));
//        System.out.println(list.toString());
      //  brandService.save(brandEntity);

    }

    public static void main(String[] args) {

    }
}
