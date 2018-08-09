package com.yixiangyang.file.service;

import java.io.File;
import java.io.IOException;

public interface FileService {
	
	public String[] uploadFile(File file,String fileName,long fileLength)throws IOException;
}
