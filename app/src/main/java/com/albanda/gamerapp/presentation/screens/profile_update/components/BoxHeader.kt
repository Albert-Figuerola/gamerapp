package com.albanda.gamerapp.presentation.screens.profile_update.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.albanda.gamerapp.R
import com.albanda.gamerapp.presentation.screens.profile_update.ProfileUpdateViewModel
import com.albanda.gamerapp.presentation.ui.theme.Red500
import com.albanda.gamerapp.presentation.utils.ComposeFileProvider

@Composable
fun BoxHeader(profileUpdateViewModel: ProfileUpdateViewModel = hiltViewModel()) {

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let { profileUpdateViewModel.onGalleryResult(it) }
        }
    )

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { hasImage ->
            profileUpdateViewModel.onCameraResult(hasImage)
        }
    )

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Red500)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(64.dp))
            if (profileUpdateViewModel.hasImage && profileUpdateViewModel.imageUri != null) {
                AsyncImage(
                    modifier = Modifier
                        .height(120.dp)
                        .clip(CircleShape),
                    model = profileUpdateViewModel.imageUri,
                    contentDescription = "Selected image"
                )
            } else {
                Image(
                    modifier = Modifier
                        .height(120.dp)
                        .clickable {
                            // imagePicker.launch("image/*")
                            val uri = ComposeFileProvider.getImageUri(context)
                            //profileUpdateViewModel.onGalleryResult(uri)
                            profileUpdateViewModel.imageUri = uri
                            cameraLauncher.launch(uri)
                        },
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User image"
                )
            }

        }
    }
}