package com.yixiangyang.service.file.com.yixiangyang.service.file;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		String url = "http://dev.zhimeiplus.com/group1/M00/00/00/rBAQB1tsAriANBsPAAFvu0-KEPQ038.png";
		String a[] = url.split(".com/");
		System.out.println(Arrays.asList(a));
	}

}
