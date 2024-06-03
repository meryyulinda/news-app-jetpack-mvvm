package com.loc.newsapp.presentation.home

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    private val sources = listOf(
        "wired",
        "the-verge",
        "business-insider",
        "techcrunch",
        "bbc-news",
        "abc-news"
    )

    val headlines = newsUseCases.getHeadlines(sources = sources).cachedIn(viewModelScope).take(5)
    val news = newsUseCases.getNews(sources = sources).cachedIn(viewModelScope)

//    private val _everythingPaging: MutableStateFlow<PagingData<Article>> =
//        MutableStateFlow(PagingData.empty())

//    private val _headlinesPaging: MutableStateFlow<PagingData<Article>> =
//        MutableStateFlow(PagingData.empty())

//    var everythingPaging = _everythingPaging.asStateFlow()
//        private set

//    var headlinesPaging = _headlinesPaging.asStateFlow()
//        private set

//    init {
//        everythingPagingSource()
//        headlinesPagingSource()
//    }

//    private fun everythingPagingSource() {
//        viewModelScope.launch {
//            newsUseCases.getNews(sources=sources).cachedIn(viewModelScope).collect {
//                _everythingPaging.value = it
//            }
//
//        }
//    }

//    private fun headlinesPagingSource() {
//        viewModelScope.launch {
//            newsUseCases.getHeadlines(sources = sources).cachedIn(viewModelScope).collect {
//                _headlinesPaging.value = it
//            }
//        }
//    }

}
