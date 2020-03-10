>项目搭建&&轮播图
``` bash
1、配置Pom.xml文件，注意mybatis-spring问题
2、配置数据库信息，注意url后面的问题
3、整理包结构
4、创建数据库，注意enabled设置问题
5、配置springboot热部署
```


>新闻资讯列表和详情
``` bash
1、创建新闻资讯列表和详情页面接口
2、注意cotroller请求参数中的默认值@RequestParam设置
    @RequestMapping(value = "/getNewsListById",method = RequestMethod.GET)
    public List<News> getNewsListById(@RequestParam(defaultValue = "",value = "id", required = false)Integer id){
        return newsService.getNewsListById(id);
    }
```

>加载评论&&发表评论
``` bash
1、通过分页进行评论加载，步长固定为5，并根据最新时间进行排序
2、添加评论，按照正常的add操作即可
3、创建RespBean格式统一返回类，state=0表示失败，state=1表示成功
```
## 滑动导航
>| 分页查询