package seava.bpet.home;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;


/**
 * 配置相关的类
 * 
 * @author WaterHsu@xiu8.com
 * @version 2014年10月10日
 */
@IocBean
public class appConf {
	
	public static Ioc ioc;//IOC容器
	public static PropertiesProxy appProp = new PropertiesProxy();
	public static PropertiesProxy config = new PropertiesProxy();  //读取conf下面的配置文件
	
	/**
	 * 文件配置的信息
	 */
	public void run(Ioc ioc) {
		initPro(ioc);
	}
	
	/**
	 * 初始化一些读取配置文件的类
	 * @param ioc   Ioc容器
	 */
	private void initPro(Ioc ioc){
		appConf.ioc = ioc;
		appProp.setPaths(new String[] { "media.properties" });
		config = ioc.get(PropertiesProxy.class, "config");
	}
}
