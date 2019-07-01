package cn.exercise.demo.dao.mapper.impl;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import cn.exercise.demo.dao.mapper.UserPersonMapper;
import cn.exercise.demo.pojo.po.tables.pojos.UserInfo;
import cn.exercise.demo.pojo.po.tables.records.UserInfoRecord;

import static cn.exercise.demo.pojo.po.tables.UserInfo.USER_INFO;


@Repository
public class UserPersonMapperImpl implements UserPersonMapper {
	@Autowired
	private DSLContext dsl;

	/**
	 * 增加一条用户信息
	 * 
	 * @param userInfo 用户信息（包括id:可为空，用户姓名，性别，年龄）
	 * @return
	 */
	@Override
	public UserInfo addUser(UserInfo userInfo) {
		Assert.notNull(userInfo, "没有信息需要插入");
//		if (userInfo.getAge() == null || userInfo.getSex() == null || userInfo.getUserName() == null) {
//			return null;
//		}

		Assert.notNull(userInfo.getSex(),"性别不能为空");
		Assert.notNull(userInfo.getUserName(),"姓名不能为空");
		Assert.notNull(userInfo.getAge(),"年龄不能为空");
		userInfo.setId(null);
		UserInfoRecord userInfoRecord = dsl.newRecord(USER_INFO, userInfo);
//		userInfoRecord.from(userInfo);
		int result = userInfoRecord.store();
		if (result != 1) {
			return null;
		}
		return userInfoRecord.into(UserInfo.class);
	}

	/**
	 * 更新用户信息
	 * 
	 * @param userInfo(可以挑字段更新，但必须指明id数值)
	 * @return 更新成功的用户信息
	 */
	@Override
	public UserInfo updateUserInfo(UserInfo userInfo) {
		Assert.notNull(userInfo, "没有需要更新的信息");
		Assert.notNull(userInfo.getId(), "没有给出id");
		UserInfoRecord userInfoRecord = formatUpdateSelective(dsl.newRecord(USER_INFO, userInfo));
		int numResult = dsl.update(USER_INFO).set(userInfoRecord).where(USER_INFO.ID.eq(userInfo.getId())).execute();
		if(numResult == 0) {
			return null;
		}
		return getUser(userInfo.getId());
	}

	/**
	 * 查询一条用户信息
	 * 
	 * @param userInfo
	 * @return
	 */
	@Override
	public UserInfo getUser(Integer id) {
		Assert.notNull(id, "id没有输入");
		UserInfoRecord userInfoRecord = dsl.fetchOne(USER_INFO, USER_INFO.ID.eq(id));
		if (userInfoRecord == null) {
			return null;
		}
		return userInfoRecord.into(UserInfo.class);
	}

	/**
	 * 根据用户id删除信息
	 * 
	 * @param id 需要删除用户信息的id
	 * @return 删除成功返回true，没有该用户返回false
	 */
	@Override
	public Boolean deleUserInfo(Integer id) {
		Assert.notNull(id, "id没有输入");
		int result = dsl.deleteFrom(USER_INFO).where(USER_INFO.ID.eq(id)).execute();
		if (result == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 格式化非空更新的记录.
	 *
	 * @param record 待更新的记录
	 * @return 格式化后只允许非空更新的记录
	 * @author zhd
	 * @since 1.0.0
	 */
	protected <R extends Record> R formatUpdateSelective(R record) {
		for (Field<?> f : record.fields()) {
			if (record.getValue(f) == null) {
				record.changed(f, false);
			} else {
				record.changed(f, true);
			}
		}
		return record;
	}
}
