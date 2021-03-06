# Easyweb-boke&shop
A Easyweb-boke&shop for my web course design

### 简介

演示地址: http://www.leigd.cn/logins
- 全部基于ajax实现的含验证码（滑块）两个验证方式的登录
- 密码使用了MD5加密，可以点击logo下载图片，介绍页面的的轮播
- 博客分类，内容，评论，评分（二级联动），用户的管理(JDBCTemplate's CRUD)
- 简单的月度及年度博客量与购物车订单量统计模块（Mybaits）
- 用两个页面实现的简易商品浏览+购物车订单的购物模块
- 使用Redis缓存数据库对不常修改的数据进行查询优化
- 基于Springboot+EasyWeb前端模板(LayUI)+Shiro+JWT Token+Redis+(OSS+Nginx)实现的博客购物学习系统

开发工具:IDEA(2021.1.3),Mysql(8.0.25),Redis(5.0.10)

### 更新日志
- V3.3.0 简单部署上线  2022-2-7~9
  - 修复-增加用户permission
  - 修复购物车条数bug
  - 实现用nginx反向代理网站80端口
  - 进行了域名购买，解析，简单备案以及上线
- V3.2.0 完善了购物体验  2021-12-8~10
  - 实现了商品选购的搜索功能
  - 实现了购物车的搜索功能
  - 添加了购物车订单的统计月度与年度功能
  - 使用Redis优化了一些不怎么改动数据的查询效率
- V3.0.0 丰富了评分，增加了购物模块  2021-12-2~4
  - 增加了二级联动技术
  - 在增加页面，选择了博客类别后会增加对应博客标题的显示
  - 增加了欢迎页面的轮播
  - 增加了MD5方式的单项加密，提高相对安全
  - 实现了商品与购物车数据库设计，后端基本功能，框架及页面显示
  - 完成了商品的购买与购物车的清理
- V2.3.0 完善了评分的机制  2021-11-23~25
  - 一个人只能评论一个博客
  - 自己只能改自己的评论分数
  - 增加了验证码版本的登录页面
  - 修复了评论板块修改功能中富文本框的数据未回显的bug
  - 增加了点击logo图标下载logo的功能
- V2.2.0 增加了统计模块与学习模块 2021-11-19
  - 统计全站每月与每年的博客量
  - 找到想要的官方文档
- V2.1.1 修饰了一下页面 2021-11-18
  - 新增二级标题的图标
  - 新增时间标签
  - 丰富个人页面
- V2.1.0 增加了评分模块 2021-11-17
  - 评分的insert,delete,update
  - 页面基本功能实现
- V2.0.0 完善了评论模块 2021-11-13
  - 与分类相同的评论的insert,delete,update
  - 页面基本功能实现
- ………………Web课程设计默默开发中...
