package com.shengchanshixi.gongxiangyigui;

import com.shengchanshixi.gongxiangyigui.dao.AdminDao;
import com.shengchanshixi.gongxiangyigui.dao.ClothDao;
import com.shengchanshixi.gongxiangyigui.entity.Admin;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import com.shengchanshixi.gongxiangyigui.service.ClothManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GongxiangyiguiApplicationTests {

	@Autowired
	AdminDao adminDao;
	@Autowired
	ClothManageService clothManageService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void querytest() throws Exception {
		Cloth cloth=new Cloth();
		cloth.setName("时尚");
		cloth.setBrand("gucci");
		cloth.setClothcub(3);
		cloth.setClothsta("全新");
		cloth.setColor("绿");
		cloth.setPart("上衣");
		cloth.setScenes("工作");
		cloth.setSeason("秋");
		cloth.setShelfsta("上架");
		cloth.setSize("M");
		cloth.setSort("常服");
		cloth.setStyle("休闲");
		cloth.setValue(1000);
		clothManageService.add(cloth);
		//clothManageService.delete(8);
		//cloth.setName("超超愁啊愁啊时尚外套");
		//cloth.setId(5);
		//clothManageService.update(cloth);
		//System.out.println(clothManageService.findByNameList("时尚"));
		for (Cloth c:clothManageService.findByNameList("时尚")
			 ) {
			System.out.print(c.getId()+" ");
			System.out.println(c.getName());
		}
	}
}


