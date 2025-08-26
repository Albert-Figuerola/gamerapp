package com.albanda.gamerapp.presentation.screens.detail_post.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albanda.gamerapp.R
import com.albanda.gamerapp.presentation.ui.theme.GamerAppTheme
import com.albanda.gamerapp.presentation.ui.theme.Red500

@Composable
fun DetailPostContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
//            model = "",
            painter = painterResource(id = R.drawable.control),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp, horizontal = 20.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 15.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(55.dp)
                        .clip(CircleShape),
//                    model = "",
                    painter = painterResource(id = R.drawable.control),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier.padding(top = 3.dp, start = 10.dp)
                ) {
                    Text(
                        text = "Nombre del usuario",
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Email",
                        fontSize = 11.sp
                    )
                }
            }
        }

        Text(
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 20.dp),
            text = "Título del juego",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Red500
        )

        Card(
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 20.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 7.dp, horizontal = 15.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(R.drawable.icon_xbox),
                    contentDescription = ""
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "Categoría",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp),
            thickness = 1.dp,
            color = Color.Gray
        )

        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Descripción",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )

        Text(
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            fontSize = 14.sp
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetailPostContentScreen() {
    GamerAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DetailPostContent()
        }
    }
}