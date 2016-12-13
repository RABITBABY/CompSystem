package com.cs.pojo;
import java.util.Date;

public class FileUpload {
    private Integer fileid;

    private Integer filename;

    private String savename;

    private Date uploaddate;

    private String uploaduser;

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    public Integer getFilename() {
        return filename;
    }

    public void setFilename(Integer filename) {
        this.filename = filename;
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

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser == null ? null : uploaduser.trim();
    }
}