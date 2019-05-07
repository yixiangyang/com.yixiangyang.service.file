package com.yixiangyang.file.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

//import org.csource.common.MyException;
//import org.csource.common.NameValuePair;
//import org.csource.fastdfs.StorageClient;
//import org.csource.fastdfs.StorageServer;
//import org.csource.fastdfs.TrackerClient;
//import org.csource.fastdfs.TrackerServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yixiangyang.file.service.FileService;

@RestController
public class Controller {
	@Resource
	private FileService fileService;
	
	@RequestMapping(value="/v1/upload_file",method=RequestMethod.POST)
	public ResponseEntity<String[]> uploadFile(@RequestParam(value = "file") File file) throws IOException {
		long fileLength = 99999;
		String [] files = fileService.uploadFile(file, "文件名", fileLength);
		
		return new ResponseEntity<String[]>(files, HttpStatus.OK);
	}
	
//	@RequestMapping(value="/v1/download_file",method=RequestMethod.GET)
//	public void downloadFile(HttpServletResponse response) throws IOException, MyException {
//		TrackerClient tracker = new TrackerClient();
//		TrackerServer trackerServer = tracker.getConnection();
//		StorageServer storageServer = null;
//		StorageClient client = new StorageClient(trackerServer, storageServer);
//		byte[] bytes= client.download_file("group1", "M00/00/00/rBBln1tqkDSAKS72AAFvuzCOObk467.png");
//		NameValuePair nvps[]= client.get_metadata("group1", "M00/00/00/rBBln1tqkDSAKS72AAFvuzCOObk467.png");
//		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(nvps[1].getValue(), "UTF-8"));
//		ServletOutputStream outputStream = null;
//        try {
//            outputStream = response.getOutputStream();
//            outputStream.write(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                outputStream.flush();
//                outputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//		
//	}
	
	
	
//	@RequestMapping(value={"/v1/file/_delete"}, method={RequestMethod.DELETE}, produces={"application/json"})
//	public ResponseEntity<Boolean> deleteResorce(@RequestParam("url") String url) {
//		if(url == null || url.trim().length() ==0 ) {
//			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		String a[] = url.split("http://dev.zhimeiplus.com/");
//		System.out.println(a[1]  );
//		boolean flag =fileClient.deleteFile(a[1]);
//		System.out.println(flag);
//		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
//	}
}
