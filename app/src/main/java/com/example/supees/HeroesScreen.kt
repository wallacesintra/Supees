package com.example.supees

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.supees.model.Hero
import com.example.supees.ui.theme.SupeesTheme

@Composable
fun HeroCard(hero: Hero,modifier: Modifier = Modifier){
    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(72.dp)
        ) {
            HeroInfo(
                heroNameId = hero.nameRes,
                heroDescriptionId = hero.descriptionRes
            )
            Spacer(modifier = Modifier.weight(1f))
            Box (

                modifier = Modifier
                    .size(height = 72.dp, width = 72.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .wrapContentWidth(Alignment.End)
            ){
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()

                )
            }

        }

    }
}

@Composable
fun HeroInfo(heroNameId: Int, heroDescriptionId: Int ){
    Column{
        Text(
            text = stringResource(heroNameId),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(id = heroDescriptionId),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .wrapContentWidth(Alignment.Start)
        )
    }
}

@Composable
fun HeroList(
    heroList: List<Hero>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(
        modifier = Modifier,
        contentPadding = contentPadding
    ){
        items(heroList){hero ->
            HeroCard(
                hero = hero,
                modifier = Modifier
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LightColorPreview(){
    SupeesTheme {
        HeroCard(Hero(R.string.hero4, R.string.description4,R.drawable.android_superhero4))
    }
}