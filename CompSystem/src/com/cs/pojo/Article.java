package com.cs.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Article {
    private Integer articleId;

    private String title;

    private Date pubDate;

    private Administer pubUser;

    private Integer articleType;

    private Project project;

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


    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articletype) {
        this.articleType = articletype;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public Administer getPubUser() {
		return pubUser;
	}

	public void setPubUser(Administer pubUser) {
		this.pubUser = pubUser;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title
				+ ", pubDate=" + pubDate + ", pubUser=" + pubUser
				+ ", articleType=" + articleType + ", project=" + project
				+ ", content=" + content + "]";
	}

    
}