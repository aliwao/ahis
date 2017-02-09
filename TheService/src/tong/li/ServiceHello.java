package tong.li;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * 
 */

/**
 * @author litong
 *
 */
@WebService
public class ServiceHello {

	@WebMethod
	public String getValue(String name){
		return "我叫"+name;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9001/Service/ServiceHello", new ServiceHello());
		System.out.println("service success!");
	}

}
