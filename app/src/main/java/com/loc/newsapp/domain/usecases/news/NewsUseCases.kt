package com.loc.newsapp.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,
    val getHeadlines: GetHeadlines,
    val searchNews: SearchNews,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticles: SelectArticles,
    val selectArticle: SelectArticle
)
