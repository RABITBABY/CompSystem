package com.cs.pojo;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class FileUpload {
    private Integer fileId;

    private Integer fileName;

    private String saveName;

    private Date uploadDate;

    private Administer uploadUser;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getFileName() {
        return fileName;
    }

    public void setFileName(Integer fileName) {
        this.fileName = fileName;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName == null ? null : saveName.trim();
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

	public Administer getUploadUser() {
		return uploadUser;
	}

	public void setUploadUser(Administer uploadUser) {
		this.uploadUser = uploadUser;
	}

	@Override
	public String toString() {
		return "FileUpload [fileId=" + fileId + ", fileName=" + fileName
				+ ", saveName=" + saveName + ", uploadDate=" + uploadDate
				+ ", uploadUser=" + uploadUser + "]";
	}

}