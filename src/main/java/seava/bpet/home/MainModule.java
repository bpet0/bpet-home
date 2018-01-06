package seava.bpet.home;

import org.beetl.ext.nutz.BeetlViewMaker;
import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;


/**
 * 主模块声明
 * 
 * Modules是声明应用的所有子模块， 可以指定之模块 ({xxx.class, yyy.class}), 
 * 也可以自动搜索子模块(scanPackage=true)
 * 半自动搜素子模块(value={xxx.class, yyy.class},scanPackage=true)
 * 
 * 
 * IocBy是加载Ioc容器，这里面加载了两个Ioc容器，一个是JsonLoader，另一个是AnnotationIocLoader
 * JsonLoader是JSON加载器，会从datasource.js的配置文件中读取容器对象的配置信息， 
 * AnnotationIocLoader是Annotation加载器，会从com.xiu8.monitor包及其下的子包扫描，去发现和加载有容器的对象
 * ComboIocLoader是组合加载器，对JsonLoader和AnnotationIocLoader进行组合加载
 * 
 * @author WaterHsu
 *
 */

@Modules(scanPackage = true)
@IocBy(type = ComboIocProvider.class, args = {	"*org.nutz.ioc.loader.json.JsonLoader",
												"application.js",
												"*org.nutz.ioc.loader.annotation.AnnotationIocLoader",
												"seava.bpet"
})
@SetupBy(MainModule.class)
@Views(value={BeetlViewMaker.class})
public class MainModule implements Setup{
	
	private Ioc ioc;
	private static Log log = Logs.getLog(MainModule.class);
	public void init(NutConfig config) {
		log.info("加载开始");
		ioc = config.getIoc();
		ioc.get(Dao.class, "dao");
		ioc.get(appConf.class).run(ioc);
	}

	public void destroy(NutConfig arg0) {
	}
}
