package cn.ruhubao.website.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.istack.NotNull;

import cn.ruhubao.website.pojo.ContentCategory;
import cn.ruhubao.website.pojo.DataGridResult;
import cn.ruhubao.website.service.ContentCategoryService;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService contentCategoryService;
	/**
	 * 保存内容分类
	 * @param contentCategroy 内容分类
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ContentCategory> saveContentCategory(ContentCategory contentCategory){
		
		try {
			//保存内容分类
			ContentCategory result=contentCategoryService.saveContentCategory( contentCategory);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		
	}
	
	/**
	 * 删除内容分类
	 * @param contentCategroy 内容分类
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Void> deleteContentCategory(ContentCategory contentCategroy){
		try {
			contentCategoryService.deleteContentCategory(contentCategroy);
			
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//返回500
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	/**
	 * 更新内容分类
	 * @param contentCategroy 内容分类
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Void> updateContentCategory(ContentCategory contentCategroy){
		try {
			contentCategoryService.updateSelective(contentCategroy);
			
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//返回500
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	/**
	 * 根据内容分类id查询该分类的所有子分类
	 * @param parentId 父节点分类id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ContentCategory>> queryContentCategoryListByParentId(
			@RequestParam(value = "id", defaultValue = "0")Long parentId){
		try {
			ContentCategory contentCategory = new ContentCategory();
			contentCategory.setParentId(parentId);
			
			List<ContentCategory> list = contentCategoryService.queryByWhere(contentCategory);
			
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//返回500
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	//查询类目的，根据需要的条目查询
	@RequestMapping(value="/queryContentCategoryListByPage",method = RequestMethod.GET)
	public ResponseEntity<DataGridResult>  queryContentCategoryListByPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "10") Integer rows) {
		try {
			DataGridResult dataGridResult = contentCategoryService.queryContentCategoryListByPage(page, rows);

			return ResponseEntity.ok(dataGridResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回500
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		
	}
	
	//根据对象字段查询。
	@RequestMapping(value="/queryContentCategoryByName")
	public ResponseEntity<List<ContentCategory>> queryContentCategoryByName(@RequestParam(value="name",required = true)String name){
		// String charName = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		
		try {
			ContentCategory category = new ContentCategory();
			System.out.println(name+"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
			category.setName(name);
			
			List<ContentCategory> list = contentCategoryService.queryByWhere(category);
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		
		
	}
	
}
