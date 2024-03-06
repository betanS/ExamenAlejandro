package com.example.examenalejandro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Screen1(){
    val listaDatos = listOf(
        Data(
            painterResource(id = R.drawable.exampleuno),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        ),
        Data(
            painterResource(id = R.drawable.exampledos),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        ),
        Data(
            painterResource(id = R.drawable.exampletres),
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        ))
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        TopBarCasero(text = "Material 3")
        for (dato in listaDatos) {
            MyUI(
                imageurl = dato.imageurl,
                txtTitulo = dato.txtTitulo
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarCasero(text: String) {
    //val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Column( /*modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)*/) {
            TopAppBar(
                title = { Text(text) },
                actions = {

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Ver más")
                    }
                }//,scrollBehavior = scrollBehavior
            )
    }
}
@Composable
fun MyUI(imageurl: Painter, txtTitulo: String) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
        ), modifier = Modifier.padding(10.dp)
    ) {
        Column() {
            Column {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(size = 12.dp))
                        .size(width = 300.dp, height = 230.dp),
                    painter = imageurl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Ver más")
                }
            }

            Text(
                modifier = Modifier.padding(start = 12.dp, top = 19.dp),
                text = txtTitulo,
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )
        }
    }
}


