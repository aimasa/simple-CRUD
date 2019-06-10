package cn.exercise.demo.dao.mapper;


import cn.exercise.demo.pojo.po.tables.pojos.UserInfo;

public interface UserPersonMapper {
	
	/**
	 * 增加一条用户信息
	 * @param userInfo 用户信息（包括id:可为空，用户姓名，性别，年龄）
	 * @return 增加成功的用户信息
	 */
   UserInfo addUser(UserInfo userInfo);
   
   /**
    * 更新用户信息
    * @param userInfo(可以挑字段更新，但必须指明id数值)
    * @return 更新成功的用户信息
    */
   
   UserInfo updateUserInfo(UserInfo userInfo);
   
   /**
    * 查询一条用户信息
    * @param id 指定需要查询的用户的id
    * @return 该id的用户信息
    */
   
   UserInfo getUser(Integer id);
   
   
   /**
    * 根据用户id删除信息
    * @param id 需要删除用户信息的id
    * @return 删除成功返回true，没有该用户返回false
    */
   Boolean deleUserInfo(Integer id);
}
