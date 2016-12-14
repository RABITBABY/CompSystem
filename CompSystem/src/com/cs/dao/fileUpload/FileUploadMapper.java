package com.cs.dao.fileUpload;

import com.cs.pojo.FileUpload;



public interface FileUploadMapper {
	/**
	 * 根据ID删除
	 * @param fileid
	 * @return
	 */
    int deleteByID(Integer fileid);
    /**
     * 全部插入
     * @param record
     * @return
     */
    int insert(FileUpload record);
    /**
     * 动态插入
     * @param record
     * @return
     */
    int insertSelective(FileUpload record);
    /**
     * 根据Id查找
     * @param fileid
     * @return
     */
    FileUpload selectByID(Integer fileid);
    /**
     * 动态更新
     * @param record
     * @return
     */
    int updateByIDSelective(FileUpload record);
    /**
     * 根据ID更新所有属性
     * @param record
     * @return
     */
    int updateByID(FileUpload record);
    

}