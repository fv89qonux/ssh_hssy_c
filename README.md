## 本项目实现的最终作用是基于SSH在线婚纱摄影网站系统
## 分为3个角色
### 第1个角色为普通管理员角色，实现了如下功能：
 - 客照管理
 - 样片管理
 - 登陆页面
 - 评论管理
### 第2个角色为超级管理员角色，实现了如下功能：
 - 客照管理
 - 样片管理
 - 登录页面
 - 管理员管理
 - 评论管理
### 第3个角色为用户角色，实现了如下功能：
 - 个人资料修改
 - 客照欣赏
 - 样片欣赏
 - 用户留言
 - 用户登录注册
 - 用户群聊
 - 用户首页
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_hssy

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [comment](#comment) | 评价表 |
| [kz](#kz) |  |
| [manage](#manage) |  |
| [message](#message) | 留言信息表 |
| [t_message](#t_message) |  |
| [t_user_message](#t_user_message) |  |
| [user](#user) | 用户表 |
| [user_message](#user_message) |  |
| [yp](#yp) |  |

**表名：** <a id="comment">comment</a>

**说明：** 评价表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | content |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | comuser_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="kz">kz</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | content |   text   | 65535 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | dzNum |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  4   | isDelete |   int   | 10 |   0    |    Y     |  N   |   NULL    | 是否删除  |
|  5   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  6   | urls |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="manage">manage</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  4   | realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 真实名字  |
|  5   | type |   int   | 10 |   0    |    N     |  N   |       | 类型  |

**表名：** <a id="message">message</a>

**说明：** 留言信息表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | content |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | isRead |   int   | 10 |   0    |    N     |  N   |       |   |
|  5   | senduser_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_message">t_message</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | content |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | isRead |   int   | 10 |   0    |    N     |  N   |       |   |
|  5   | senduser_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_user_message">t_user_message</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  3   | isRead |   int   | 10 |   0    |    N     |  N   |       |   |
|  4   | message_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  5   | resiveruser_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  6   | sendser_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="user">user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  4   | phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  5   | realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 真实名字  |
|  6   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |

**表名：** <a id="user_message">user_message</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  3   | isRead |   int   | 10 |   0    |    N     |  N   |       |   |
|  4   | message_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  5   | resiveruser_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  6   | sendser_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="yp">yp</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | content |   text   | 65535 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | isDelete |   int   | 10 |   0    |    Y     |  N   |   NULL    | 是否删除  |
|  4   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  5   | urls |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

