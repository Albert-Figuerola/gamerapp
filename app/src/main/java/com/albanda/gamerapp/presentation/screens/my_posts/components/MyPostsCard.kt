package com.albanda.gamerapp.presentation.screens.my_posts.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.albanda.gamerapp.domain.model.Post
import com.albanda.gamerapp.presentation.navigation.DetailsScreen

@Composable
fun MyPostsCard(navHostController: NavHostController, post: Post) {

    Card(
        modifier = Modifier
            .padding(top = 12.dp)
            .clickable {
                navHostController.navigate(route = DetailsScreen.DetailPost.passPost(post.toJson()))
            },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column() {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                model = post.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                text = post.name,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = post.description,
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray
            )
        }
    }
}

