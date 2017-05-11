package com.cs.dao.fileUpload;

import java.util.List;
import java.util.Map;

import com.cs.pojo.FileUpload;

public interface FileUploadMapper {
	
	List<Map> allFile(Map map);
	 
	int getTotal(Map map);
	
    int deleteByPrimaryKey(Integer fileid);

    int insert(FileUpload record);

    int insertSelective(FileUpload record);

    FileUpload selectByPrimaryKey(Integer fileid);

    int updateByPrimaryKeySelective(FileUpload record);

    int updateByPrimaryKey(FileUpload record);
}