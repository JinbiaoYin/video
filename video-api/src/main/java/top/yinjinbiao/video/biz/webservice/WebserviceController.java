package top.yinjinbiao.video.biz.webservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.yinjinbiao.video.webservice.phone.MobileCodeWS;
import top.yinjinbiao.video.webservice.phone.MobileCodeWSSoap;

@RestController
@RequestMapping("/webservice")
public class WebserviceController {
	
	@GetMapping("/phone")
	public String queryPhone(String phone) {
		MobileCodeWS ss = new MobileCodeWS();
		MobileCodeWSSoap soap = ss.getMobileCodeWSSoap();
		String result = soap.getMobileCodeInfo(phone, null);
		return result;
	}

}
