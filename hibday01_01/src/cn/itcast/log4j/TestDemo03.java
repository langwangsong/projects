package cn.itcast.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestDemo03 {
	@Test
	public void testLog4j(){
		Logger LOG = Logger.getLogger("abc");
		LOG.fatal("致命的");
		LOG.error("错误的");
		LOG.warn("警告");
		LOG.info("提示");
		LOG.debug("调试");
	}
}
