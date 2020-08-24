package cn.aimasa.hetongfenglei.dao.mapper.impl;

import cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File;
import cn.aimasa.hetongfenglei.pojo.po.tables.records.FileRecord;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import static cn.aimasa.hetongfenglei.pojo.po.Tables.FILE;
import cn.aimasa.hetongfenglei.dao.mapper.FileMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Repository
public class FileMapperImpl implements FileMapper {
	@Autowired
	private DSLContext dsl;

	/**
	 * 增加一条用户信息
	 * 
	 * @param file 用户信息（包括id:可为空，用户姓名，性别，年龄）
	 * @return
	 */
	@Override
	public File addFile(File file) {
		Assert.notNull(file, "没有信息需要插入");
		Assert.notNull(file.getContent(),"内容不能为空");
		Assert.notNull(file.getUserid(),"姓名不能为空");
		Assert.notNull(file.getClassfiyField(),"分类类别不能为空");
		file.setId(null);
		FileRecord userInfoRecord = dsl.newRecord(FILE, file);
//		userInfoRecord.from(userInfo);
		int result = userInfoRecord.store();
		if (result != 1) {
			return null;
		}
		return userInfoRecord.into(File.class);
	}

	public List<File> addFiles(List<File> files){
		InsertQuery<FileRecord> insertQuery = dsl.insertQuery(FILE);
		for(File file : files){
			FileRecord record = dsl.newRecord(FILE, file);
			insertQuery.addRecord(record);
		}
		insertQuery.setReturning();
		if(insertQuery.execute() <=0 ) {
		    return Collections.emptyList();
		}
		return insertQuery.getReturnedRecords().into(File.class);
	}

	/**
	 * 更新用户信息
	 * 
	 * @param file(可以挑字段更新，但必须指明id数值)
	 * @return 更新成功的用户信息
	 */
	@Override
	public File updateFile(File file) {
		Assert.notNull(file, "没有需要更新的信息");
		Assert.notNull(file.getId(), "没有给出id");
		FileRecord userInfoRecord = formatUpdateSelective(dsl.newRecord(FILE, file));
		int numResult = dsl.update(FILE).set(userInfoRecord).where(FILE.ID.eq(file.getId())).execute();
		if(numResult == 0) {
			return null;
		}
		return getFile(file.getId());
	}

	public List<File> getFiles(String fields, Condition filters){

		SelectQuery<Record> records = buildSelectQuery(FILE, fields, filters);
		return records.fetchInto(File.class);
	}

	protected SelectQuery<Record> buildSelectQuery(Table<?> table, String fields, Condition conditions) {
		String tempFields = fields;
		SelectQuery<Record> selectQuery = dsl.selectQuery();
		if (tempFields != null && !tempFields.trim().isEmpty()) {
			for (String field : tempFields.split(",")) {
				if (table.field(field.trim()) != null) {
					selectQuery.addSelect(table.field(field.trim()));
				}
			}
		}
		selectQuery.addFrom(table);
		if (conditions != null) {
			selectQuery.addConditions(conditions);
		}
		return selectQuery;
	}

	/**
	 * 查询一条用户信息
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public File getFile(Integer id) {
		Assert.notNull(id, "id没有输入");
		FileRecord userInfoRecord = dsl.fetchOne(FILE, FILE.ID.eq(id));
		if (userInfoRecord == null) {
			return null;
		}
		return userInfoRecord.into(File.class);
	}

	/**
	 * 根据用户id删除信息
	 * 
	 * @param id 需要删除用户信息的id
	 * @return 删除成功返回true，没有该用户返回false
	 */
	@Override
	public Boolean deleFile(Integer id) {
		Assert.notNull(id, "id没有输入");
		int result = dsl.deleteFrom(FILE).where(FILE.ID.eq(id)).execute();
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
