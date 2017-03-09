package com.cs.pojo;

import java.util.Date;

public class Article {
    private Integer articleId;

    private String title;

    private Date pubDate;

    private Integer pubUserNo;

    private Integer articleType;

    private Integer comId;

    private String content;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Integer getPubUserNo() {
		return pubUserNo;
	}

	public void setPubUserNo(Integer pubUserNo) {
		this.pubUserNo = pubUserNo;
	}

	public Integer getArticleType() {
		return articleType;
	}

	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    

}