package cn.itcast.web;
/**
 * 文件上传工具类
 * @author Mr_lang
 *
 */
public class UploadUtils {
	/**
	 * 根据唯一值，获取二级目录
	 * @param fileName
	 * @return
	 */
	public static String getDir(String fileName){
		int code = fileName.hashCode();
		int dir1 = code & 0xf;
		int dir2 = (code >>> 4) & 0xf;
		return "/"+dir1+"/"+dir2;
	}
}
