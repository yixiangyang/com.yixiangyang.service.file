package com.yixiangyang.service.file.com.yixiangyang.service.file;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Arrays;

import javax.annotation.Resource;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerGroup;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import com.yixiangyang.bootstrap.Application;
import com.yixiangyang.file.service.FileService;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages= {"com.yixiangyang.**.service", "com.yixiangyang.**.controller"})
@SpringBootTest(classes= Application.class)
public class ApplicationTests {
	@Resource
	private FileService fileService;
	
	//@Test
	public void contextLoads() throws IOException, MyException {
		
		System.out.println(ClientGlobal.configInfo());
		String[] files = fileService.uploadFile(new File("F:/dd/aa.png"), "aa.png", 0);
		System.out.println(Arrays.asList(files));
		TrackerClient tracker = new TrackerClient();
		TrackerServer trackerServer = tracker.getConnection();
		StorageClient client = new StorageClient(trackerServer, null);
		NameValuePair nvps[] = client.get_metadata(files[0], files[1]);
		System.out.println(nvps[0].getName() + "  "+nvps[0].getValue());
		System.out.println(nvps[1].getName() + "  "+nvps[1].getValue());
	}

	public void contextLoads1() throws IOException, MyException {
		
		TrackerClient tracker = new TrackerClient();
		TrackerServer trackerServer = tracker.getConnection();
		StorageClient client = new StorageClient(trackerServer, null);
		//client.delete_file(group_name, remote_filename);
		
	}
}
