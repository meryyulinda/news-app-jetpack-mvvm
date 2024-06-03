package com.loc.newsapp.presentation.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.presentation.Dimens
import com.loc.newsapp.presentation.Dimens.ArticleCardSize
import com.loc.newsapp.presentation.Dimens.HeadlineCardSize
import com.loc.newsapp.presentation.common.ArticleCard
import com.loc.newsapp.presentation.common.ArticleCardShimmerEffect
import com.loc.newsapp.presentation.common.EmptyScreen
import com.loc.newsapp.presentation.common.HeadlineCard
import com.loc.newsapp.presentation.common.HeadlineCardShimmerEffect
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeadlinesList(
    modifier: Modifier = Modifier,
    headlines: LazyPagingItems<Article>,
    onClick:(Article) -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        // provide pageCount
        5
    }

    val handlePagingResult = handleHeadlinePagingResult(headlines = headlines)
    if (handlePagingResult) {


        Box(modifier = Modifier
            .fillMaxWidth()
            .size(HeadlineCardSize)
            .padding(horizontal = Dimens.MediumPadding1)
        ) {
            HorizontalPager(state = pagerState) {
                LazyRow {
                    items(count = headlines.itemCount) {
                        headlines[it]?.let {
                            HeadlineCard(headline = it, onClick = { onClick(it) })
                        }
                    }
                }

            }
        }


//        LazyRow(
//            modifier = modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1)
//            ,contentPadding = PaddingValues(all = Dimens.ExtraSmallPadding2)
//        ) {
//
//            items(count = headlines.itemCount) {
//                headlines[it]?.let {
//                    HorizontalPager(
//                        state = pagerState,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .size(Dimens.HeadlineCardSize),
//                        pageSpacing = 15.dp,
////                ,contentPadding = PaddingValues(all = Dimens.ExtraSmallPadding2),
//                        key = { headlines[it]!! }
//                    ) {headline ->
//                        HeadlineCard(headline = it, onClick = {onClick(it)})
//
//                    }
//
//                }
//            }
//
//
//        }
    }
}

@Composable
fun handleHeadlinePagingResult(
    headlines: LazyPagingItems<Article>
): Boolean {

    val loadState = headlines.loadState
    val error = when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when{
        loadState.refresh is LoadState.Loading -> {
            HeadlineCardShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen(error = error)
            false
        }

        else -> {
            true
        }
    }
}

@Composable
private fun ShimmerEffectHeadline() {
    Column(verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1)) {
        HeadlineCardShimmerEffect(
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1)
        )
    }
}