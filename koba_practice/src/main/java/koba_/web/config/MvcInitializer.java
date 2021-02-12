package koba_.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import koba_.persistence.config.DataSourceConfig;
import koba_.persistence.config.MyBatisConfig;
import koba_.service.config.ServiceConfig;


public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

		@Override
		protected Class<?>[] getRootConfigClasses() {
			return null;
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {
			return new Class<?>[] {DataSourceConfig.class, MyBatisConfig.class, ServiceConfig.class, MvcConfig.class};
		}
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
