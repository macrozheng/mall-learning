package com.macro.mall.tiny.stream;

import com.macro.mall.tiny.mbg.mapper.UmsMenuMapper;
import com.macro.mall.tiny.mbg.model.UmsMenu;
import com.macro.mall.tiny.mbg.model.UmsMenuExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class StreamApiTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamApiTest.class);
    @Autowired
    private UmsMenuMapper menuMapper;
    private List<UmsMenu> menuList;

    @BeforeEach
    void eachInit(){
        menuList = menuMapper.selectByExample(new UmsMenuExample());
        LOGGER.info("eachInit()：在测试方法前执行，每个测试方法前都执行");
    }

    @Test
    public void filterTest(){
        //filter操作：获取所有一级菜单
        List<UmsMenu> oneLevelList = menuList.stream()
                .filter(menu -> menu.getParentId() == 0L)
                .collect(Collectors.toList());
        LOGGER.info("filter操作：{}",oneLevelList);
    }

    @Test
    public void mapTest(){
        //map操作：获取所有菜单的id
        List<Long> idList = menuList.stream()
                .map(menu -> menu.getId())
                .collect(Collectors.toList());
        LOGGER.info("map操作：{}",idList);
    }

    @Test
    public void limitTest(){
        //limit操作：获取前5个菜单
        List<UmsMenu> firstFiveList = menuList.stream()
                .limit(5)
                .collect(Collectors.toList());
        LOGGER.info("limit操作：{}",firstFiveList);
    }

    @Test
    public void countTest(){
        //count操作：获取所有一级菜单的个数
        long count = menuList.stream()
                .filter(menu -> menu.getParentId() == 0L)
                .count();
        LOGGER.info("count操作：{}",count);
    }

    @Test
    public void sortedTest(){
        //sorted操作：将所有菜单按照sort字段进行排序
        List<UmsMenu> sortedList = menuList.stream()
                .sorted((menu1,menu2)->{return menu2.getSort().compareTo(menu1.getSort());})
                .collect(Collectors.toList());
        LOGGER.info("sorted操作：{}",sortedList);
    }

    @Test
    public void skipTest(){
        //skip操作：跳过前5个元素，返回后面的
        List<UmsMenu> skipList = menuList.stream()
                .skip(5)
                .collect(Collectors.toList());
        LOGGER.info("skip操作：{}",skipList);
    }

    @Test
    public void collect2mapTest(){
        //collect转map操作：将菜单列表以id为key，以菜单对象为值转换成map
        Map<Long, UmsMenu> menuMap = menuList.stream()
                .collect(Collectors.toMap(menu -> menu.getId(), menu -> menu));
        LOGGER.info("collect转map操作：{}",menuMap);
    }

    @Test
    public void forEachTest(){
        //forEach操作，对集合中的元素进行迭代
        menuList.stream().forEach(menu-> LOGGER.info("forEach操作{}",menu));
    }
}
