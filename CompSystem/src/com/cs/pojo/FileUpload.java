package com.cs.pojo;

import java.util.Date;

public class FileUpload {
    private Integer fileid;

    private String filename;

    private String savename;

    private Date uploaddate;

    private String uploaduserno;

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getSavename() {
        return savename;
    }

    public void setSavename(String savename) {
        this.savename = savename == null ? null : savename.trim();
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

	public String getUploaduserno() {
		return uploaduserno;
	}

	public void setUploaduserno(String uploaduserno) {
		this.uploaduserno = uploaduserno;
	}

	@Override
	public String toString() {
		return "FileUpload [fileid=" + fileid + ", filename=" + filename
				+ ", savename=" + savename + ", uploaddate=" + uploaddate
				+ ", uploaduserno=" + uploaduserno + "]";
	}

    
}