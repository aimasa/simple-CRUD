# 简单的CRUD项目

- spring boot + jooq完成的简单的增删查改。

# 相关方法参数

## 增

postman 输入地址：

    localhost:8080/adduser

输入参数：

    {
	    "userName":"nuonuo",
	    "age":23,
	    "sex":"男"
    }

输出参数：

    {
        "info": "添加信息成功",
        "voGetUserInfoResp": {
            "id": 50,
            "userName": "nuonuo",
            "sex": "男",
            "age": 23
        }
    }

# 删
postman 输入地址：

    localhost:8080/deleuser/50

无返回值

# 查

postman  输入地址：

    localhost:8080/getuser/47

返回值：

    {
        "info": "获取用户信息成功",
        "voGetUserInfoResp": {
            "id": 47,
            "userName": "nani",
            "sex": "女",
            "age": 12
        }
    }

# 改

postman  输入地址

    localhost:8080/updateuser

输入参数：

    {
	    "id":47,
	    "userName":"丫丫",
	    "sex":"女"
    }

返回值：

    {
        "info": "更新信息成功",
        "voGetUserInfoResp": {
            "id": 47,
            "userName": "丫丫",
            "sex": "女",
            "age": 12
        }
    }  