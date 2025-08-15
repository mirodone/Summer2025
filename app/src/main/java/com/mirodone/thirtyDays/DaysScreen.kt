package com.mirodone.thirtyDays


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mirodone.thirtyDays.model.Day


@Composable
fun DayCardItem(day: Day, index: Int, modifier: Modifier = Modifier) {

    var expand by remember {

        mutableStateOf(false)
    }

    val color by animateColorAsState(

        targetValue = if (expand) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.primary,
        label = "" // optional, used for tooling
    )

    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

        colors = CardDefaults.cardColors(containerColor = color)

    ) {

        Column {
            Modifier
                .background(color = color)
                .animateContentSize(
                    animationSpec = spring(
                        stiffness = Spring.StiffnessMediumLow,
                        dampingRatio = Spring.DampingRatioLowBouncy
                    )
                )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        {
            DayImage(
                visible = !expand, dayImage = day.imageRes, modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.small)
            )
            DayInfo(
                title = day.titleRes, dayNumber = "Day ${index + 1} Card",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f),

            )

            DayExpandButton(expanded = expand, onClick = { expand = !expand })
        }
        if (expand)
            DayCardInformation(day = day, modifier = Modifier.padding(16.dp))

    }

}

@Composable
fun DayImage(visible: Boolean, @DrawableRes dayImage: Int, modifier: Modifier = Modifier) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + expandHorizontally(),
        exit = fadeOut() + shrinkHorizontally()
    ) {
        Image(
            painter = painterResource(id = dayImage),
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun DayInfo(@StringRes title: Int, dayNumber: String, modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Text(
            text = dayNumber,
            style = MaterialTheme.typography.displayMedium,

        )
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 6.dp)
        )
    }

}

@Composable
fun DayExpandButton(expanded: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {

    IconButton(onClick = onClick, modifier = modifier) {

        if (expanded) Icon(
            Icons.Filled.Close,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = Color.White
        ) else Icon(
            Icons.Filled.List,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = Color.White
        )

    }

}

@Composable
fun DayCardInformation(day: Day, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = day.imageRes),
            contentDescription = stringResource(id = day.titleRes),
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .clip(MaterialTheme.shapes.large)
        )
        Text(
            text = stringResource(id = day.informationRes),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp),

        )
    }
}

@Composable
fun DayScreenList(days: List<Day>, modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier) {
        itemsIndexed(days) { index, day ->
            DayCardItem(day = day, index = index)
        }
    }
}



