package cn.com.liandisys.ahis.webapp.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public abstract class AbstractAhisController<F extends AbstractAhisForm> {

	/** Logger */
	private Logger logger = LoggerFactory.getLogger(AbstractAhisController.class);

	@RequestMapping("index")
	public String index(@ModelAttribute F f, HttpServletRequest req) {
		return forwardIndex();
	}
	
	protected String forwardIndex() {
		String classname = this.getClass().getSimpleName();
		String pageId = classname.substring(0, 7).toUpperCase();
		logger.info(pageId);
		return pageId;
	}

}
