package cn.ruhubao.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ruhubao.website.mapper.ContentMapper;
import cn.ruhubao.website.pojo.Content;
import cn.ruhubao.website.pojo.DataGridResult;
import cn.ruhubao.website.service.ContentService;
import tk.mybatis.mapper.entity.Example;

@Service
public class ContentServiceImpl extends BaseServiceImpl<Content> implements ContentService {
	@Autowired
	private ContentMapper contentMapper;

	@Override
	public DataGridResult queryContentListByPage(Long categoryId, Integer page, Integer rows) {

		// 根据内容分类id分页查询该分类下的内容列表并根据更新时间降序排序
		Example example = new Example(Content.class);

		// 设置查询条件
		example.createCriteria().andEqualTo("categoryId", categoryId);

		// 设置排序
		example.orderBy("updated").desc();

		// 设置分页
		PageHelper.startPage(page, rows);

		List<Content> list = contentMapper.selectByExample(example);

		PageInfo<Content> pageInfo = new PageInfo<>(list);
		return new DataGridResult(pageInfo.getTotal(), pageInfo.getList());
	}

	

}
