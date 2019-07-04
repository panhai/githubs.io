package cn.ruhubao.website.service;

import java.io.Serializable;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public interface BaseService<T> {

		//查询全部
		public List<T> queryAll();
		
		//根据id查询
		public T queryById(Serializable id);
		
		//根据条件查询
		public List<T> queryByWhere(T t);
		
		//根据条件统计总数
		public int queryCountByWhere(T t);
		
		//根据分页查询
		public List<T> queryByPage(Integer page, Integer rows);
		
		//选择性新增
		public int saveSelective(T t);
		
		//选择性更新
		public int updateSelective(T t);
		
		//根据id删除
		public void deleteById(Serializable id);
		
		//批量删除
		public void deleteByIds(Serializable[] ids);
		
		//获取到对象的id
		//public T getOne(T t);
	
}
