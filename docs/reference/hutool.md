mall项目全套学习教程连载中，[关注公众号](#公众号)第一时间获取。

# Hutool中那些常用的工具类和方法 

> Hutool是一个Java工具包，它帮助我们简化每一行代码，避免重复造轮子。如果你有需要用到某些工具方法的时候，不妨在Hutool里面找找，可能就有。本文将对Hutool中的常用工具类和方法进行介绍。

## 安装

maven项目在pom.xml添加以下依赖即可：

```xml
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>4.6.3</version>
</dependency>
```

## 常用工具类

### Convert
类型转换工具类，用于各种类型数据的转换。

```java 
//转换为字符串
int a = 1;
String aStr = Convert.toStr(a);
//转换为指定类型数组
String[] b = {"1", "2", "3", "4"};
Integer[] bArr = Convert.toIntArray(b);
//转换为日期对象
String dateStr = "2017-05-06";
Date date = Convert.toDate(dateStr);
//转换为列表
String[] strArr = {"a", "b", "c", "d"};
List<String> strList = Convert.toList(String.class, strArr);
```

### DateUtil
日期时间工具类，定义了一些常用的日期时间操作方法。

```java 
//Date、long、Calendar之间的相互转换
//当前时间
Date date = DateUtil.date();
//Calendar转Date
date = DateUtil.date(Calendar.getInstance());
//时间戳转Date
date = DateUtil.date(System.currentTimeMillis());
//自动识别格式转换
String dateStr = "2017-03-01";
date = DateUtil.parse(dateStr);
//自定义格式化转换
date = DateUtil.parse(dateStr, "yyyy-MM-dd");
//格式化输出日期
String format = DateUtil.format(date, "yyyy-MM-dd");
//获得年的部分
int year = DateUtil.year(date);
//获得月份，从0开始计数
int month = DateUtil.month(date);
//获取某天的开始、结束时间
Date beginOfDay = DateUtil.beginOfDay(date);
Date endOfDay = DateUtil.endOfDay(date);
//计算偏移后的日期时间
Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
//计算日期时间之间的偏移量
long betweenDay = DateUtil.between(date, newDate, DateUnit.DAY);
```

### StrUtil
字符串工具类，定义了一些常用的字符串操作方法。

```java 
//判断是否为空字符串
String str = "test";
StrUtil.isEmpty(str);
StrUtil.isNotEmpty(str);
//去除字符串的前后缀
StrUtil.removeSuffix("a.jpg", ".jpg");
StrUtil.removePrefix("a.jpg", "a.");
//格式化字符串
String template = "这只是个占位符:{}";
String str2 = StrUtil.format(template, "我是占位符");
LOGGER.info("/strUtil format:{}", str2);
```

### ClassPathResource

获取classPath下的文件，在Tomcat等容器下，classPath一般是WEB-INF/classes。

```java 
//获取定义在src/main/resources文件夹中的配置文件
ClassPathResource resource = new ClassPathResource("generator.properties");
Properties properties = new Properties();
properties.load(resource.getStream());
LOGGER.info("/classPath:{}", properties);
```

### ReflectUtil
Java反射工具类，可用于反射获取类的方法及创建对象。

```java 
//获取某个类的所有方法
Method[] methods = ReflectUtil.getMethods(PmsBrand.class);
//获取某个类的指定方法
Method method = ReflectUtil.getMethod(PmsBrand.class, "getId");
//使用反射来创建对象
PmsBrand pmsBrand = ReflectUtil.newInstance(PmsBrand.class);
//反射执行对象的方法
ReflectUtil.invoke(pmsBrand, "setId", 1);
```

### NumberUtil
数字处理工具类，可用于各种类型数字的加减乘除操作及判断类型。

```java 
double n1 = 1.234;
double n2 = 1.234;
double result;
//对float、double、BigDecimal做加减乘除操作
result = NumberUtil.add(n1, n2);
result = NumberUtil.sub(n1, n2);
result = NumberUtil.mul(n1, n2);
result = NumberUtil.div(n1, n2);
//保留两位小数
BigDecimal roundNum = NumberUtil.round(n1, 2);
String n3 = "1.234";
//判断是否为数字、整数、浮点数
NumberUtil.isNumber(n3);
NumberUtil.isInteger(n3);
NumberUtil.isDouble(n3);
```

### BeanUtil

JavaBean的工具类，可用于Map与JavaBean对象的互相转换以及对象属性的拷贝。

```java 
PmsBrand brand = new PmsBrand();
brand.setId(1L);
brand.setName("小米");
brand.setShowStatus(0);
//Bean转Map
Map<String, Object> map = BeanUtil.beanToMap(brand);
LOGGER.info("beanUtil bean to map:{}", map);
//Map转Bean
PmsBrand mapBrand = BeanUtil.mapToBean(map, PmsBrand.class, false);
LOGGER.info("beanUtil map to bean:{}", mapBrand);
//Bean属性拷贝
PmsBrand copyBrand = new PmsBrand();
BeanUtil.copyProperties(brand, copyBrand);
LOGGER.info("beanUtil copy properties:{}", copyBrand);
```

### CollUtil
集合操作的工具类，定义了一些常用的集合操作。

```java 
//数组转换为列表
String[] array = new String[]{"a", "b", "c", "d", "e"};
List<String> list = CollUtil.newArrayList(array);
//join：数组转字符串时添加连接符号
String joinStr = CollUtil.join(list, ",");
LOGGER.info("collUtil join:{}", joinStr);
//将以连接符号分隔的字符串再转换为列表
List<String> splitList = StrUtil.split(joinStr, ',');
LOGGER.info("collUtil split:{}", splitList);
//创建新的Map、Set、List
HashMap<Object, Object> newMap = CollUtil.newHashMap();
HashSet<Object> newHashSet = CollUtil.newHashSet();
ArrayList<Object> newList = CollUtil.newArrayList();
//判断列表是否为空
CollUtil.isEmpty(list);
```

### MapUtil
Map操作工具类，可用于创建Map对象及判断Map是否为空。

```java 
//将多个键值对加入到Map中
Map<Object, Object> map = MapUtil.of(new String[][]{
    {"key1", "value1"},
    {"key2", "value2"},
    {"key3", "value3"}
});
//判断Map是否为空
MapUtil.isEmpty(map);
MapUtil.isNotEmpty(map);
```

### AnnotationUtil

注解工具类，可用于获取注解与注解中指定的值。

```java 
//获取指定类、方法、字段、构造器上的注解列表
Annotation[] annotationList = AnnotationUtil.getAnnotations(HutoolController.class, false);
LOGGER.info("annotationUtil annotations:{}", annotationList);
//获取指定类型注解
Api api = AnnotationUtil.getAnnotation(HutoolController.class, Api.class);
LOGGER.info("annotationUtil api value:{}", api.description());
//获取指定类型注解的值
Object annotationValue = AnnotationUtil.getAnnotationValue(HutoolController.class, RequestMapping.class);
```

### SecureUtil
加密解密工具类，可用于MD5加密。

```java 
//MD5加密
String str = "123456";
String md5Str = SecureUtil.md5(str);
LOGGER.info("secureUtil md5:{}", md5Str);
```

### CaptchaUtil
验证码工具类，可用于生成图形验证码。

```java 
//生成验证码图片
LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
try {
    request.getSession().setAttribute("CAPTCHA_KEY", lineCaptcha.getCode());
    response.setContentType("image/png");//告诉浏览器输出内容为图片
    response.setHeader("Pragma", "No-cache");//禁止浏览器缓存
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expire", 0);
    lineCaptcha.write(response.getOutputStream());
} catch (IOException e) {
    e.printStackTrace();
}
```

### 其他工具类

Hutool中的工具类很多，可以参考：[https://www.hutool.cn/](https://www.hutool.cn/)

## 项目源码地址

[https://github.com/macrozheng/mall-learning/tree/master/mall-tiny-hutool](https://github.com/macrozheng/mall-learning/tree/master/mall-tiny-hutool)

## 公众号

![公众号图片](http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg)

