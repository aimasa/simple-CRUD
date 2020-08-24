/*
 * This file is generated by jOOQ.
 */
package cn.aimasa.hetongfenglei.pojo.po.tables.daos;


import cn.aimasa.hetongfenglei.pojo.po.tables.File;
import cn.aimasa.hetongfenglei.pojo.po.tables.records.FileRecord;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FileDao extends DAOImpl<FileRecord, cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File, Integer> {

    /**
     * Create a new FileDao without any configuration
     */
    public FileDao() {
        super(File.FILE, cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File.class);
    }

    /**
     * Create a new FileDao with an attached configuration
     */
    public FileDao(Configuration configuration) {
        super(File.FILE, cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File.class, configuration);
    }

    @Override
    public Integer getId(cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(File.FILE.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File> fetchById(Integer... values) {
        return fetch(File.FILE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File fetchOneById(Integer value) {
        return fetchOne(File.FILE.ID, value);
    }

    /**
     * Fetch records that have <code>userid BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File> fetchRangeOfUserid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(File.FILE.USERID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>userid IN (values)</code>
     */
    public List<cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File> fetchByUserid(Integer... values) {
        return fetch(File.FILE.USERID, values);
    }

    /**
     * Fetch records that have <code>content BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File> fetchRangeOfContent(byte[] lowerInclusive, byte[] upperInclusive) {
        return fetchRange(File.FILE.CONTENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>content IN (values)</code>
     */
    public List<cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File> fetchByContent(byte[]... values) {
        return fetch(File.FILE.CONTENT, values);
    }

    /**
     * Fetch records that have <code>classfiy_field BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File> fetchRangeOfClassfiyField(String lowerInclusive, String upperInclusive) {
        return fetchRange(File.FILE.CLASSFIY_FIELD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>classfiy_field IN (values)</code>
     */
    public List<cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File> fetchByClassfiyField(String... values) {
        return fetch(File.FILE.CLASSFIY_FIELD, values);
    }

    /**
     * Fetch records that have <code>filename BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File> fetchRangeOfFilename(String lowerInclusive, String upperInclusive) {
        return fetchRange(File.FILE.FILENAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>filename IN (values)</code>
     */
    public List<cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File> fetchByFilename(String... values) {
        return fetch(File.FILE.FILENAME, values);
    }
}