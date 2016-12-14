package com.cs.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Article {
    private Integer articleId;

    private String title;

    private Date pubDate;

    private String pubUser;

    private Integer articleType;

    private Integer comId;

    private String content;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleid) {
        this.articleId = articleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubdate) {
        this.pubDate = pubdate;
    }

    public String getPubUser() {
        return pubUser;
    }

    public void setPubUser(String pubuser) {
        this.pubUser = pubuser == null ? null : pubuser.trim();
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articletype) {
        this.articleType = articletype;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comid) {
        this.comId = comid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title
				+ ", pubDate=" + pubDate + ", pubUser=" + pubUser
				+ ", articleType=" + articleType + ", comId=" + comId
				+ ", content=" + content + "]";
	}
    
}