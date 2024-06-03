package com.loc.newsapp.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.model.Source
import com.loc.newsapp.presentation.Dimens.ArticleCardSize
import com.loc.newsapp.presentation.Dimens.ArticleImageHeight
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.loc.newsapp.presentation.Dimens.HeadlineCardSize
import com.loc.newsapp.presentation.Dimens.HeadlineImageHeight
import com.loc.newsapp.presentation.Dimens.SmallIconSize
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun HeadlineCard(
    modifier: Modifier = Modifier,
    headline: Article,
    onClick:() -> Unit
) {

    val context = LocalContext.current

    Column(modifier = modifier
        .fillMaxWidth()
        .size(HeadlineCardSize)
        .padding(horizontal = ExtraSmallPadding2)
        .clickable { onClick() }) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .size(HeadlineImageHeight)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(headline.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        
        Spacer(modifier = Modifier.width(ExtraSmallPadding2))

        Text(
            text = headline.title,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_title),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.width(ExtraSmallPadding2))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = headline.source.name,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.body),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(ExtraSmallPadding2))
            Icon(
                painter = painterResource(id = R.drawable.ic_time),
                contentDescription = null,
                modifier = Modifier.size(SmallIconSize),
                tint = colorResource(id = R.color.body)
            )
            Spacer(modifier = Modifier.width(ExtraSmallPadding2))
            Text(
                text = headline.publishedAt,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.body),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeadlineCardPreview() {
    NewsAppTheme {
        Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
            HeadlineCard(
                headline = Article(
                    author = "",
                    content = "",
                    description = "",
                    publishedAt = "2 hours",
                    source = Source(id = "", name = "BBC"),
                    title = "Her train broke down. Her phone died. And then she met her saver in a",
                    url = "",
                    urlToImage = ""
                )
            ) {

            }
        }
    }
}