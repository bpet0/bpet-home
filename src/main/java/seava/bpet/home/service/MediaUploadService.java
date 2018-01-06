package seava.bpet.home.service;

import java.io.File;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seava.image.meta.Result;
import com.seava.image.util.FileUploadUtil;

import seava.bpet.home.appConf;

/**
 * 多媒体上传工具
 * 
 * @author water
 *
 */
@IocBean
public class MediaUploadService {

	private static Log log = Logs.getLog(MediaUploadService.class);
	
	/**
	 * 上传多媒体
	 * 
	 * @param file               文件 
	 * @param type               类型 1图片 2视频
	 * @param smallImageWidth    缩略图的宽度
	 * @param smallImageLength   缩略图的长度
	 * @return
	 */
	public ResultV uploadMedia(File file, int type, int smallImageWidth, int smallImageLength) {
		try {
			Result result = FileUploadUtil.uploadMedia(appConf.appProp.get("media.url"), file, 
					appConf.appProp.get("media.namespace"), 
					appConf.appProp.get("media.project"), 
					appConf.appProp.get("media.module"), 
					appConf.appProp.get("media.user"), type, smallImageWidth, smallImageLength);
			if (result.isSuccess()) {
				ResultV v = new ResultV();
				v.setSourceUrl(result.getData().get("mediaUrl").toString());
				v.setThumbnailUrl(result.getData().get("thumbnailUrl").toString());
				return v;
			}
			return null;
		} catch (Exception e) {
			log.error("上传多媒体出错", e);
			return null;
		}
	}
	
	/**
	 * 结果数据
	 * 
	 * @author water
	 *
	 */
	public class ResultV {
		
		/**
		 * 原始的url
		 */
		public String sourceUrl;
		
		/**
		 * 缩略图的url
		 */
		public String thumbnailUrl;

		public String getSourceUrl() {
			return sourceUrl;
		}

		public void setSourceUrl(String sourceUrl) {
			this.sourceUrl = sourceUrl;
		}

		public String getThumbnailUrl() {
			return thumbnailUrl;
		}

		public void setThumbnailUrl(String thumbnailUrl) {
			this.thumbnailUrl = thumbnailUrl;
		}
	}
}
