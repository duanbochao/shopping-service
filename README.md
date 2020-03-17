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
+ 根据用户传递过来的idPage,type（‘0’为查询全部，以此分类为’1’, ’2’...分类查询）
+ 请求的controller中的path为getSharePagesByType

## 图片点击次数&&图片详情
+ 点击次数的添加放在了请求缩略图的时候
+ 给评论添加标志&&根据评论标志获取评论数据
+ 完善新闻详情和图片分享中的评论功能


## 构建后台管理系统2020年3月15日
### 完成权限认证&& 登录模块
+ 将客户端显示的接口前面添加/web/
+ 放行前端接口
+ RBAC权限数据库设计
+ 配置登录权限认证

### 完成加载菜单显示栏目

## 完成新闻资讯分页查询功能


## 新闻资讯添加
+ 数据库中的时间类型是Tiemstap
+ 对应的java中的时间类型是String类型
+ 前端的传递的时间格式是YYYY-MM-DD HH:MM:SS
+ 或者通过后台进行处理



