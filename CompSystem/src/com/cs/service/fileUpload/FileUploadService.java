package com.cs.service.fileUpload;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.cs.pojo.FileUpload;
import com.cs.util.PageInfo;
@Service
public interface FileUploadService {

	int insertFile(FileUpload file);
	int deleteFile(int fileId);
	FileUpload findFileById(int fileId);
	PageInfo allFile(Map map);
}
