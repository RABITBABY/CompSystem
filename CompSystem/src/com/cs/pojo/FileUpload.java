package com.cs.pojo;

import java.util.Date;

public class FileUpload {
    private Integer fileId;

    private String fileName;

    private String saveName;

    private Date uploadDate;

    private Integer uploadUserNo;

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Integer getUploadUserNo() {
		return uploadUserNo;
	}

	public void setUploadUserNo(Integer uploadUserNo) {
		this.uploadUserNo = uploadUserNo;
	}
    

}