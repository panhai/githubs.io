package cn.ruhubao.website.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class PicUploadUtils {

	public static String getUploadPath(HttpServletRequest request,MultipartFile pictureFile) throws IllegalStateException, IOException {
		//获取文件的后缀名。
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		
		String uuidName = UUID.randomUUID().toString();

		String url = request.getSession().getServletContext().getRealPath("/uploadimg");
		String name = request.getServerName();
		int port = request.getServerPort();
		String servletPath = request.getServletPath();
		System.out.println(url);
		/// pic/upload
		System.out.println(name + ":" + port + "/" + servletPath);
		// 绝对路径
		String trueFilePath = url + "/" + uuidName + "." + ext;
		// 以绝对路径保存重名命后的图片
		pictureFile.transferTo(new File(trueFilePath));
		// pictureFile.transferTo(new File(trueFilePath));
		String returnPath = name + ":" + port + "/" + "uploadimg" + "/" + uuidName + "." + ext;
		return returnPath;
	}

	// 校验图片的真实有效

	public static boolean checkPic(MultipartFile pictureFile) {
		// 允许上传的图片类型
		String[] IMAGE_TYPE = { ".jpg", ".png", ".bmp", ".jpeg", ".gif" };
		boolean isLegal = false;
		// 校验图片
		for (String type : IMAGE_TYPE) {
			if (pictureFile.getOriginalFilename().lastIndexOf(type) > 0) {
				isLegal = true;

				break;
			}
		}
		return isLegal;
	}

}
