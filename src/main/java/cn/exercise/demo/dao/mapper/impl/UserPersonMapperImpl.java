package cn.exercise.demo.dao.mapper.impl;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.UpdateQuery;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.exercise.demo.dao.mapper.UserPersonMapper;
import cn.exercise.demo.pojo.po.tables.pojos.UserInfo;
import cn.exercise.demo.pojo.po.tables.records.UserInfoRecord;

import static cn.exercise.demo.pojo.po.tables.UserInfo.USER_INFO;

@Repository
public class UserPersonMapperImpl implements UserPersonMapper {
	@Autowired
	private DSLContext dsl;

	@Override
	public UserInfo addUser(UserInfo userInfo) {
		if (userInfo.getAge() == null || userInfo.getSex() == null || userInfo.getUserName() == null) {
			return null;
		}

		UserInfoRecord userInfoRecord = dsl.newRecord(USER_INFO);
		userInfoRecord.from(userInfo);
		int result = userInfoRecord.store();
		if (result != 1) {
			return null;
		}
		return userInfoRecord.into(UserInfo.class);
	}

	@Override
	public UserInfo updateUserInfo(UserInfo userInfo) {
		if (userInfo.getId() == null) {
			return null;
		}
		UserInfoRecord userInfoRecord = dsl.fetchOne(USER_INFO, USER_INFO.ID.eq(userInfo.getId()));
		if (userInfoRecord == null) {
			return null;
		}
		UpdateQuery<UserInfoRecord> updateQuery = dsl.updateQuery(USER_INFO);
		if (userInfo.getAge() != null) {
			updateQuery.addValue(DSL.field("age"), userInfo.getAge());
		}
		if (userInfo.getSex() != null) {
			updateQuery.addValue(DSL.field("sex"), userInfo.getSex());
		}
		if (userInfo.getUserName() != null) {
			updateQuery.addValue(DSL.field("user_name"), userInfo.getUserName());
		}
		Condition condition = DSL.field("id").eq(userInfo.getId());
		updateQuery.addConditions(condition);
		int result = updateQuery.execute();
		System.out.println(result);
		if(result == 0) {
			return null;
		}
		
		return getUser(userInfo.getId().toString());
	}

	@Override
	public UserInfo getUser(String id) {

		UserInfoRecord userInfoRecord = dsl.fetchOne(USER_INFO, USER_INFO.ID.eq(Integer.valueOf(id)));
		if (userInfoRecord == null) {
			return null;
		}
		return userInfoRecord.into(UserInfo.class);
	}

	@Override
	public Boolean deleUserInfo(String id) {
		int result = dsl.deleteFrom(USER_INFO).where(USER_INFO.ID.eq(Integer.valueOf(id))).execute();
		if(result == 0) {
			return false;
		}
		return true;
	}

}
