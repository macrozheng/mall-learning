package com.macro.mall.tiny;

import com.macro.mall.tiny.dao.EsProductDao;
import com.macro.mall.tiny.easyes.document.EsProduct;
import com.macro.mall.tiny.easyes.mapper.EsProductMapper;
import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MallTinyApplicationTests {

    @Autowired
    private EsProductDao productDao;
    @Autowired
    private EsProductMapper esProductMapper;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testGetAllEsProductList(){
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        System.out.print(esProductList);
    }
    @Test
    public void testEsProductMapping(){
        Map<String, MappingMetadata> mappings = esProductMapper.getIndex().getMappings();
        System.out.println(mappings);
    }

}
