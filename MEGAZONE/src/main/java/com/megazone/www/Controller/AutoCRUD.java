package com.megazone.www.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.megazone.www.Service.DataService;

@RequestMapping("/crud")
@Controller
public class AutoCRUD {
	
	static int count;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final DataService dataService;
	
	@Autowired
	public AutoCRUD(DataService dataService) {
		this.dataService = dataService;
	}
	
	@GetMapping("/speed")// url : /speed?interval=1000
	public ResponseEntity<String> adjustSpeed(@RequestParam(name = "speedInterval") int interval) {
		// 컨트롤러에서 받은 값을 서비스로 전달하여 속도 동적 조절
		
		// 1초 1회 = 1000
		// 1초 2회 = 500
		
		// 1초 10회 = 100
		// x = 1000/횟수
		// interval = 1000/x
		if (interval == 0) {
			dataService.setFixedDelay(interval);
		}
		interval = 1000/interval;
		System.out.println(interval);
		dataService.setFixedDelay(interval);
		return ResponseEntity.ok("Speed adjusted to " + interval + " milliseconds");
	}
	
}
