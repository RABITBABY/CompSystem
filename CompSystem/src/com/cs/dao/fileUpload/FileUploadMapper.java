package com.cs.dao.fileUpload;

import com.cs.pojo.FileUpload;

public interface FileUploadMapper {
    int deleteByPrimaryKey(Integer fileid);

    int insert(FileUpload record);

    int insertSelective(FileUpload record);

    FileUpload selectByPrimaryKey(Integer fileid);

    int updateByPrimaryKeySelective(FileUpload record);

    int updateByPrimaryKey(FileUpload record);
}