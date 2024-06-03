package com.loc.newsapp.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.presentation.navgraph.Route
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loc.newsapp.R
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.loc.newsapp.presentation.Dimens.MediumPadding1
import com.loc.newsapp.presentation.common.ArticlesList
import com.loc.newsapp.presentation.common.SearchBar
import com.loc.newsapp.presentation.home.components.HeadlinesList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    headlines: LazyPagingItems<Article>,
    news: LazyPagingItems<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit
) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = MediumPadding1)
        .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding1)
        )
        
        Spacer(modifier = Modifier.height((MediumPadding1)))

        SearchBar(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = { navigateToSearch() },
            onSearch = {}
        )

        Spacer(modifier = Modifier.height((MediumPadding1)))

        // Article Headlines
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            text = "Headlines",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title),
        )

        Spacer(modifier = Modifier.height((ExtraSmallPadding2)))

        HeadlinesList(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            headlines = headlines,
            onClick = { navigateToDetails(it) }
        )

        Spacer(modifier = Modifier.height((MediumPadding1)))

        // Latest News
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            text = "Latest News",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title),
        )

        Spacer(modifier = Modifier.height((ExtraSmallPadding2)))
        
        ArticlesList(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            articles = news,
            onClick = { navigateToDetails(it) }
        )

        }
    }

