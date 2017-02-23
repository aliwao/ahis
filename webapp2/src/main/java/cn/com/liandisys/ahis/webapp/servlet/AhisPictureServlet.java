package cn.com.liandisys.ahis.webapp.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;

import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@WebServlet(urlPatterns = "/images/portrait", description = "This is PictureServlet for Ahis.")
public class AhisPictureServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7939641165516831248L;

	/**
	 * 登录后默认头像路径
	 */
	private static final String DEFAULT_PORTRAIT = "static/images/tx_m.png";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doPost(req, resp);
		LoginUserInfo userinfo = AhisCommonUtil.getCurrentUserInfo();
		byte[] data = userinfo.getPortrait();
		if(data == null || data.length == 0){
			Resource resource = new FileSystemResourceLoader().getResource("classpath:" + DEFAULT_PORTRAIT);
			FileInputStream fis = new FileInputStream(resource.getFile());
			int size =fis.available(); //得到文件大小 
			data = new byte[size];
			fis.read(data);  //读数据
			fis.close();
		}
        //resp.setContentType("image/png"); //设置返回的文件类型   
        OutputStream os = resp.getOutputStream();  
        os.write(data);
        os.flush();
        os.close();
	}
}
