package com.example.businesscard

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardApp()

                }
            }
        }
    }
}


@Composable
@Preview()
fun CardApp() {
    FullCard(
        painter = painterResource(id = R.drawable.android_logo),
        name = "Gycha Mafon",
        profession = "Dungeon Master"
    )

}


@Composable
fun FullCard(
    painter: Painter,
    name: String,
    profession: String,
    modifier: Modifier = Modifier
) {

    Box(
        modifier
            .fillMaxSize()
            .background(Color(194, 218, 184))
    )


    {
        Column(
            modifier = modifier
                .align(Alignment.Center)
                .padding(bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                Modifier
                    .background(Color(0, 0, 54))
                    .size(100.dp),
            )
            Text(text = name, fontSize = 60.sp)
            Text(text = profession, color = Color(0, 900, 0), fontWeight = FontWeight.Bold)
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
        ) {
            ContactInfo(icon = Icons.Default.AccountCircle, info = "Gychamafon")
            ContactInfo(
                icon = Icons.Default.Call,
                info = "8 800 55 35 35",
                colorIcon = Color.DarkGray
            )
            ContactInfo(
                icon = Icons.Default.Email,
                info = "aboba@gmail.com",
                colorIcon = Color.Cyan
            )
        }

    }
}


@Composable
fun ContactInfo(
    icon: ImageVector,
    info: String,
    colorIcon: Color = Color.White,
    colorText: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Icon(
            icon,
            contentDescription = null,
            tint = colorIcon,
            modifier = modifier
                .padding(end = 4.dp)
                .size(50.dp)
        )
        Text(
            text = info,
            modifier.align(Alignment.CenterVertically),
            color = colorText,
            fontStyle = FontStyle.Italic, fontSize = 20.sp,
        )
    }
}