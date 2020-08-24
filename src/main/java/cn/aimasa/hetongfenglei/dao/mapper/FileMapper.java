package cn.aimasa.hetongfenglei.dao.mapper;


import cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File;
import org.jooq.Condition;

import java.util.List;

public interface FileMapper {
	
	/**
	 * 增加一条用户信息
	 * @param file 用户信息（包括id:可为空，用户姓名，性别，年龄）
	 * @return 增加成功的用户信息
	 */
    File addFile(File file);
   /**
    * 更新用户信息
    * @param file(可以挑字段更新，但必须指明id数值)
    * @return 更新成功的用户信息
    */
   
   File updateFile(File file);
   
   /**
    * 查询一条用户信息
    * @param id 指定需要查询的用户的id
    * @return 该id的用户信息
    */

   File getFile(Integer id);
   
   
   /**
    * 根据用户id删除信息
    * @param id 需要删除用户信息的id
    * @return 删除成功返回true，没有该用户返回false
    */
   Boolean deleFile(Integer id);

   List<File> getFiles(String fields, Condition filters);
}
