package com.cs.service.fileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.dao.fileUpload.FileUploadMapper;
import com.cs.pojo.FileUpload;
@Service("fileImpl")
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	FileUploadMapper mapper;
	
	@Override
	public int insertFile(FileUpload file) {
		int statue=mapper.insert(file);
		return statue;
	}

}
