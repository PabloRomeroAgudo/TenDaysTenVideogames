package com.example.tendaystenvideogames

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.tendaystenvideogames.model.Videogame

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideogameTopBar(modifier: Modifier = Modifier) {
    val activity = (LocalContext.current as? Activity)
    CenterAlignedTopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier.padding(end = dimensionResource(id = R.dimen.title_padding))
                )
                Button(
                    onClick = {
                        activity?.finish()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = "X")
                }
            }
        },
        modifier = modifier
    )
}

@Composable
fun VideogameItem(
    videogame: Videogame,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer, label = ""
    )
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.card_elevation))
    ) {
        Column (
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = color)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .sizeIn(minHeight = dimensionResource(id = R.dimen.min_height))
                    .padding(dimensionResource(id = R.dimen.card_padding_big)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                VideogameTitle(
                    videogame.nameRes,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { expanded = !expanded },
                )
                VideogameItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
                VideogameIcon(
                    videogameIcon = videogame.imageRes,
                    expanded,
                    url = stringResource(id = videogame.webPageRes),
                    modifier = Modifier
                        .padding(start = dimensionResource(id = R.dimen.card_padding_big))
                )
            }

            if (expanded) {
                VideogameDescription(
                    videogameDescription = videogame.descriptionRes,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.card_padding_big),
                            end = dimensionResource(id = R.dimen.card_padding_big),
                            bottom = dimensionResource(id = R.dimen.card_padding_big)
                        )
                )
            }
        }
    }
}

@Composable
fun VideogameTitle(
    @StringRes videogameName: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(videogameName),
            style = MaterialTheme.typography.displayMedium
        )
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun VideogameIcon(
    @DrawableRes videogameIcon: Int,
    expanded : Boolean,
    url: String,
    modifier: Modifier = Modifier
) {
    val size = animateDpAsState(if (expanded)
                                    dimensionResource(id = R.dimen.image_size_expanded)
                                else
                                    dimensionResource(id = R.dimen.image_size), label = "")

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val rotateAnimation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(2000, easing = LinearEasing)), label = ""
    )
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { }

    Image(
        painter = painterResource(videogameIcon),
        contentDescription = null,
        modifier = modifier
            .size(size.value)
            .padding(dimensionResource(id = R.dimen.image_padding))
            .drawBehind {
                rotate(rotateAnimation.value) {
                    drawCircle(rainbowColorsBrush, style = Stroke(15f))
                }
            }
            .clip(CircleShape)
            .clickable {
                launcher.launch(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
            },
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun VideogameDescription(
    @StringRes videogameDescription: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(videogameDescription),
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier
    )
}

@Composable
private fun VideogameItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}