/**
 * 
 */
package cn.com.liandisys.ahis.webapp.his.entity.request;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.his.entity.request.wx3h.Wx3hDeptHisRequest;
import cn.com.liandisys.ahis.webapp.service.Mfih004Service;

/**
 * @author litong
 *
 */
public class TestRequest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Wx3hDeptHisRequest r = new Wx3hDeptHisRequest();
		r.setDeptCode("1234");
		
		String jsonStr = JSONObject.toJSONString(r);  
		System.out.println("转换为json:" + JSONObject.toJSONString(r));  

		//jsonStr = jsonStr.toUpperCase();  
		System.out.println(jsonStr);  

		r = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), Wx3hDeptHisRequest.class);  
		System.out.println(r.toString());
		
		//ApplicationContext appContext = new AnnotationConfigApplicationContext("cn.com.liandisys.ahis.webapp");
		WebApplicationContext appContext = ContextLoader.getCurrentWebApplicationContext();
		Mfih004Service service = appContext.getBean(Mfih004Service.class);
        System.out.println(service.mfih001Mapper);
	}

}
