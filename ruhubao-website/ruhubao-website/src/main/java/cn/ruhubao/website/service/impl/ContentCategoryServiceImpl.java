package cn.ruhubao.website.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ruhubao.website.mapper.ContentCategoryMapper;
import cn.ruhubao.website.pojo.ContentCategory;
import cn.ruhubao.website.pojo.DataGridResult;
import cn.ruhubao.website.service.ContentCategoryService;
@Service
public class ContentCategoryServiceImpl extends BaseServiceImpl<ContentCategory> implements ContentCategoryService{

	@Autowired
	private ContentCategoryMapper contentCategoryMapper;
	
	@Override
	public ContentCategory saveContentCategory(ContentCategory contentCategory) {

		//1、保存内容分类
		contentCategory.setSortOrder(100);
		contentCategory.setIsParent(false);//非父节点---叶子节点
		saveSelective(contentCategory);
		
		//更新父节点的isparent为true;
		ContentCategory parent =new ContentCategory();
		parent.setId(contentCategory.getParentId());
		parent.setIsParent(true);
		updateSelective(parent);
		
		//返回
		return contentCategory;
	}

	@Override
	public void deleteContentCategory(ContentCategory contentCategroy) {
		//删除当前的节点及其子孙节点
		ArrayList<Long> ids = new ArrayList<Long>();
		ids.add(contentCategroy.getId());
		//递归获取当前的节点的所有的子孙节点
		getCategoryIds(ids,contentCategroy.getId());
		//批量删除
		deleteByIds(ids.toArray(new Long[]{}));
		
		
		//判断当前的删除的节点的父节点是否为父节点（父节点是否还有其它子节点，如果没有其它子节点则更新父节点为叶子节点）
		ContentCategory param =new ContentCategory();
		param.setParentId(contentCategroy.getParentId());
		int count = queryCountByWhere(param);
		if (count==0) {
			//没有其它兄弟节点，也就是父节点没有其它子节点所以要更新父节点为叶子节点
			ContentCategory parent = new ContentCategory();
			parent.setIsParent(false);
			parent.setId(contentCategroy.getParentId());
			updateSelective(parent);
		}
		
	}

	private void getCategoryIds(ArrayList<Long> ids, Long categoryId) {
		//查询当前的节点的子节点
		ContentCategory param =new ContentCategory();
		param.setParentId(categoryId);
		List<ContentCategory> list = queryByWhere(param);
		if (list!=null &&list.size()>0) {
			for (ContentCategory cc : list) {
				ids.add(cc.getId());
				getCategoryIds(ids, categoryId);
			}
		}
		
		
	}

	@Override
	public DataGridResult queryContentCategoryListByPage(Integer page, Integer rows) {
		
		 PageHelper.startPage(page, rows);
		 List<ContentCategory> list = contentCategoryMapper.selectAll();
		 PageInfo<ContentCategory> pageInfo = new PageInfo<>(list);
		return new DataGridResult(pageInfo.getTotal(), pageInfo.getList());
		
	}
		
	

}
