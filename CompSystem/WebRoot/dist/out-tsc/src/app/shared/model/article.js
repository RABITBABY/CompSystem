export var Article = (function () {
    function Article() {
    }
    Article.prototype.ArticleId = function (articleId) {
        this.articleId = articleId;
        return this;
    };
    Article.prototype.Title = function (title) {
        this.title = title;
        return this;
    };
    Article.prototype.Content = function (content) {
        this.content = content;
        return this;
    };
    Article.prototype.PubDate = function (pubDate) {
        this.pubDate = pubDate;
        return this;
    };
    Article.prototype.PubUser = function (pubUser) {
        this.pubUser = pubUser;
        return this;
    };
    Article.prototype.ArticleType = function (articleType) {
        this.articleType = articleType;
        return this;
    };
    Article.prototype.Project = function (project) {
        this.project = project;
        return this;
    };
    return Article;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/article.js.map