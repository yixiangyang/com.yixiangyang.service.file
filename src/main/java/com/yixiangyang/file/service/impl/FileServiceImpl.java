package com.yixiangyang.file.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

//import org.csource.common.MyException;
//import org.csource.common.NameValuePair;
//import org.csource.fastdfs.ClientGlobal;
//import org.csource.fastdfs.StorageClient;
//import org.csource.fastdfs.StorageServer;
//import org.csource.fastdfs.TrackerClient;
//import org.csource.fastdfs.TrackerServer;
import org.springframework.stereotype.Service;

import com.yixiangyang.file.service.FileService;

@Service
public class FileServiceImpl implements FileService{

//	private static byte[] getFileBuffer(InputStream inStream,long fileLength) throws IOException {
//		byte[] buffer = new byte[256 * 1024];
//		byte[] fileBuffer = new byte[(int)fileLength];
//		int count = 0;
//		int length = 0;
//		while((length = inStream.read(buffer)) != -1) {
//			for(int i = 0; i<length;++i) {
//				fileBuffer[count+i] = buffer[i];
//			}
//			count += length;
//		}
//		return fileBuffer;
//	}
	@PostConstruct
	public void init() {
//		try {
//			ClientGlobal.init("src/main/resources/client.conf");
//		} catch (IOException | MyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Override
	public String[] uploadFile(File file,String fileName,long fileLength)throws IOException {
//		//byte[] fileBuff = getFileBuffer(new FileInputStream(file), fileLength);
//		try {
//			ClientGlobal.init("src/main/resources/client.conf");
//		} catch (MyException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		String[] files = null;
//		String fileExtName = "";
//		if(fileName.contains(".")) {
//			fileExtName = fileName.substring(fileName.lastIndexOf(".")+1);
//		}else {
//			System.out.println("文件上传失败");
//			return null;
//		}
//		TrackerClient tracker = new TrackerClient();
//		TrackerServer trackerServer = tracker.getConnection();
//		StorageServer storageServer = null;
//		StorageClient client = new StorageClient(trackerServer, storageServer);
//		NameValuePair[] metaList = new NameValuePair[2];
//		metaList[0] = new NameValuePair("fileName", file.getName());
//		metaList[1] = new NameValuePair("fileExtName", fileExtName);
//		//metaList[2] = new NameValuePair("fileLength", String.valueOf(fileLength));
//		try {
//			System.out.println(file.getPath() + "  "+ file.getAbsolutePath() + "  "+ file.getName());
////			files = client.upload_file(fileBuff, fileExtName, metaList);
//			files= client.upload_file(file.getAbsolutePath(), "png", metaList);
//			//files= client.upload_file("F:/dd/aa.png", "png", null);
//		} catch (Exception e) {
//			System.out.println(fileName+"上传失败");
//			e.printStackTrace();
//		}
//		trackerServer.close();
//		return files;
		return null;
	}

}
