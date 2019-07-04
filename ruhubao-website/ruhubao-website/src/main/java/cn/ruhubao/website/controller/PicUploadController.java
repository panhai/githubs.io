package cn.ruhubao.website.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.ruhubao.website.utils.UrlRequestUtils;

@RequestMapping("/pic")
@Controller
public class PicUploadController {

	// 这是一个java对象与jason格式字符串互转的工具lei

	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static HashMap<String, Object> result =new HashMap<String, Object>();
	
	
	@Value("${PIC_PATH}")
	private String PIC_PATH;
	
	@Value("${PIC_REQUEST_URL}")
	private String PIC_REQUEST_URL;
	
	
	//@RequestMapping(value = "/uploadimage", produces = MediaType.TEXT_HTML_VALUE)
	@RequestMapping(value = "/uploadFile")
	public ResponseEntity<HashMap<String, Object>> upload(HttpServletRequest request,HttpServletResponse response,@RequestParam("pictureFile")MultipartFile pictureFile) throws Exception {
		
		/*//成功时
		{
		        "error" : 0,
		        "url" : "http://www.example.com/path/to/file.ext"
		}
		//失败时
		{
		        "error" : 1,
		        "message" : "错误信息"
		}*/
		
		//把文件保存到服务器的硬盘(位置:项目根目录/upload)
		//获取upload目录的绝对路径 ； e:/xxx/bos-web/upload  ServletContext.getRealPath():获取web项目下的某个目录绝对路径
		//String uploadPath=request.getSession().getServletContext().getRealPath("/content/uploadimg");
		//System.out.println(uploadPath);
		//生成随机文件名称  uuid.jpg
		String uuid = UUID.randomUUID().toString();
		//获取文件后缀名
		
		     
		String extName = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		String fileName = uuid+"."+extName;
		
		//FileUtils.copyFile( pictureFile, new File(uploadPath+"/"+fileName));
		
		// 以相对路径保存重名命后的图片
		//pictureFile.transferTo(new File(uploadPath+File.separator+fileName));
		pictureFile.transferTo(new File(PIC_PATH+File.separator+fileName));
		HashMap<String, Object> map = new HashMap<String, Object>();
		//返回去的是相对路径
		String url =PIC_REQUEST_URL+File.separator+fileName;	
		//String url1=UrlRequestUtils.getContextUrl(request)+"content/uploadimg/"+fileName;
		//pictureFile.transferTo(new File(url));
			
		map.put("error", 0);
		map.put("url", url);
		
				
		return ResponseEntity.ok(map);

	}
	@RequestMapping("/manage")
	public ResponseEntity<HashMap<String, Object>> manage(HttpServletRequest request,HttpServletResponse response){
		//获取uploadimg的绝对路径
		String uploadPath =request.getSession().getServletContext().getRealPath("/content/uploadimg");
		//1.读取upload目录
		File uploadFile = new File(uploadPath);
		//图片扩展名
		String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};
		//2.把upload目录的所有文件解析出来
				//遍历目录取的文件信息
		List<Hashtable> fileList = new ArrayList<Hashtable>();
		if(uploadFile.listFiles() != null) {
			for (File file : uploadFile.listFiles()) {
				Hashtable<String, Object> hash = new Hashtable<String, Object>();
				String fileName = file.getName();
				if(file.isDirectory()) {
					hash.put("is_dir", true);
					hash.put("has_file", (file.listFiles() != null));
					hash.put("filesize", 0L);
					hash.put("is_photo", false);
					hash.put("filetype", "");
				} else if(file.isFile()){
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					hash.put("is_dir", false);
					hash.put("has_file", false);
					hash.put("filesize", file.length());
					hash.put("is_photo", Arrays.<String>asList(fileTypes).contains(fileExt));
					hash.put("filetype", fileExt);
				}
				hash.put("filename", fileName);
				hash.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
				fileList.add(hash);
			}
		}

		
		//3.把文件信息转为KindEditor固定json格式返回
		//加上文件存放的路径
		result.put("current_url",request.getContextPath()+"/content/upload/");
		result.put("file_list", fileList);
		return ResponseEntity.ok(result);


	}
	
}
