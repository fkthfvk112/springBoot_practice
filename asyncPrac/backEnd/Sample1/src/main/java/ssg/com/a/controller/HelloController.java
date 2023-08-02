package ssg.com.a.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ssg.com.a.dto.HumanDto;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String hello() {
		System.out.println("HelloController -----");
		
		return "안녕하세요";
	}
	
	@GetMapping("/test")
	public int test() {
		System.out.println("HelloController -----" + new Date());

		return 12;
	}
	
	@GetMapping("/human")
	public HumanDto human() {
		System.out.println("HelloController human() -----" + new Date());

		HumanDto human = new HumanDto(1, "길동", "여기");
		
		return human;
	}
	
	@GetMapping("conn_param")
	public Map<String, Object> conn_param(int num, String str) {
		System.out.println("HelloController conn_param() -----" + new Date());
		System.out.println("num : " + num + " str : " + str);
		
		Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("num", num + 100);
        responseMap.put("str", str + ":processed");
        
		return responseMap;
	}
	
	@GetMapping("param_obj")
	public String param_obj(HumanDto h) {
		System.out.println("HelloController param_obj() -----" + new Date());
		System.out.println(h.toString());
		
		return "success";
	}
	
	@GetMapping("getlist")
	public List<HumanDto> getlist(){
		List<HumanDto> list = new ArrayList<HumanDto>();
		
		list.add(new HumanDto(1, "이름1", "부산"));
		list.add(new HumanDto(2, "이름2", "서울"));
		list.add(new HumanDto(3, "이름3", "전주"));
		
		return list;
	}
	
	@GetMapping("getMap")
	public Map<String, List<HumanDto>> getMap(){
		Map<String, List<HumanDto>> map = new HashMap<String, List<HumanDto>>();
		List<HumanDto> list1 = new ArrayList<HumanDto>();
		
		list1.add(new HumanDto(1, "이름1", "부산"));
		list1.add(new HumanDto(2, "이름2", "서울"));
		list1.add(new HumanDto(3, "이름3", "전주"));
		
		
		List<HumanDto> list2 = new ArrayList<HumanDto>();
		
		list2.add(new HumanDto(1, "이름1", "부산"));
		list2.add(new HumanDto(2, "이름2", "서울"));
		list2.add(new HumanDto(3, "이름3", "전주"));
		
		map.put("리스트 1번", list1);
		map.put("리스트 2번", list2);
		
		return map;
	}
 }
