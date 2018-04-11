package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.domain.Classes;

/**
 * 班级管理的DAO接口
 * @author Mr_lang
 *
 */
public interface ClassesDao extends BaseDao<Classes> {

	List<Classes> findAllNotEnd();

}
