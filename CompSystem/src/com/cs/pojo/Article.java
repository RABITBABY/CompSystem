package com.cs.pojo;

import java.util.Date;

public class Article {
    private Integer articleid;

    private String title;

    private Date pubdate;

    private String pubuserno;

    private Integer articletype;

    private Integer relationId;

    private String content;

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }


    public String getPubuserno() {
		return pubuserno;
	}

	public void setPubuserno(String pubuserno) {
		this.pubuserno = pubuserno;
	}

	public Integer getArticletype() {
        return articletype;
    }

    public void setArticletype(Integer articletype) {
        this.articletype = articletype;
    }


    public Integer getRelationId() {
		return relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "Article [articleid=" + articleid + ", title=" + title
				+ ", pubdate=" + pubdate + ", pubuserno=" + pubuserno
				+ ", articletype=" + articletype + ", relationId=" + relationId
				+ ", content=" + content + "]";
	}

    
    
}