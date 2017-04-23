package com.cs.service.fileUpload;

import org.springframework.stereotype.Service;

import com.cs.pojo.FileUpload;
@Service
public interface FileUploadService {

	int insertFile(FileUpload file);
}
