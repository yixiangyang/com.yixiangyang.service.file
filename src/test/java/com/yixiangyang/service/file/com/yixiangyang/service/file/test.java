package com.yixiangyang.service.file.com.yixiangyang.service.file;

import java.util.Arrays;
import java.util.Date;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;

public class test {

	public static void main(String[] args) {
//		String url = "http://dev.zhimeiplus.com/group1/M00/00/00/rBAQB1tsAriANBsPAAFvu0-KEPQ038.png";
//		String a[] = url.split(".com/");
//		System.out.println(Arrays.asList(a));
		DateUtil.parse("1995-11-14");
		DateUtil.age(DateUtil.parse("1995-09-14"), new Date());
		System.out.println(DateUtil.age(DateUtil.parse("1995-11-14"), new Date()));
	}

}
