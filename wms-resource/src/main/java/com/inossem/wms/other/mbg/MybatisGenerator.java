package com.inossem.wms.other.mbg;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * Mybatis Generator 文件生成工具
 * @author libin
 * 2019年7月24日
 */
public class MybatisGenerator {
	
	public static void main(String[] args) throws URISyntaxException {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream("generatorConfig.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(is);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			for (String warning : warnings) {
				System.out.println(warning);
			}
			System.out.println("运行成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
