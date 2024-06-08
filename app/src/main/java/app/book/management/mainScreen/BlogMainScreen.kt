package app.book.management.mainScreen

import android.graphics.drawable.Drawable
import android.webkit.WebView
import android.view.KeyEvent
import android.webkit.WebViewClient
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import app.book.management.R
import app.book.management.data.vm.BlogsViewModel
import kotlinx.coroutines.launch

@Composable
fun BlogMainScreen(viewModel: BlogsViewModel = viewModel(), /*navController: NavController*/){
    Column(
        modifier = Modifier
            .padding(top = 48.dp, start = 32.dp, end = 32.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
        ) {
            ProfileImage()
            BellIcon()
        }

        BlogText()
        BlogSubText()
        BlogColumn(viewModel = viewModel /*navController = navController*/)
    }
}

@Composable
fun ProfileImage(){
    Image(
        painterResource(
            id = R.drawable.profile_img),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .border(width = 4.dp, color = Color(0xFF00B7DD), shape = CircleShape)
                .clip(CircleShape)
    )
}

@Composable
fun BellIcon(){
    Box(modifier = Modifier.padding(start = 240.dp, top=8.dp)){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.Notifications,
                contentDescription ="Bell",
                modifier=Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun BlogText(){
    Box(modifier = Modifier.padding(top = 16.dp)){
        Text(
            text = "Blog of the week",
            fontSize = 40.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp),
            fontWeight = FontWeight.ExtraBold,
        )
    }
}

@Composable
fun BlogSubText(){
    Box(modifier = Modifier.padding(top = 0.dp)){
        Text(
            text = "Trending Blogs and news",
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.LightGray,
            modifier = Modifier.padding(top = 8.dp),
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
fun BlogColumn(viewModel: BlogsViewModel, /*navController: NavController*/){
    val posts by viewModel.posts.collectAsState()


    LazyColumn {
        items(posts){post ->
            val url = post.link
//            BlogCard(title = post.title.rendered){
//                WebViewComponent(url = url)
//            }
            var showWebView by remember { mutableStateOf(false) }


            if (showWebView) {
                Box(modifier = Modifier.fillMaxSize().padding(top=16.dp)) {

                    WebViewComponent(url = url, onBack = { showWebView = false })
                }
            } else {
                BlogCard(title = post.title.rendered) {
                    showWebView = true
                }
            }
        }
    }
}

@Composable
fun WebViewComponent(url: String, onBack: () -> Unit) {
    AndroidView(factory = { context ->
        WebView(context).apply {
            loadUrl(url)
            webViewClient = WebViewClient()
            setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_BACK && canGoBack()) {
                    goBack()
                    true
                } else {
                    onBack()
                    false
                }
            }
        }
    })
}



@Composable
fun BlogCard(title:String, onClick: () -> Unit){

    Box(modifier = Modifier
        .clickable(onClick = onClick)
        .fillMaxWidth()
        .height(180.dp)
        .padding(top = 16.dp)
        .background(Color.LightGray, shape = RoundedCornerShape(12.dp))){

        Image(
            painterResource(id = R.drawable.background_img) ,
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
                .background(Color.Transparent, shape = RoundedCornerShape(12.dp)),
            contentScale = ContentScale.FillBounds
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(
                Color.Black.copy(alpha = 0.5f),
                shape = RoundedCornerShape(12.dp)
            ))
        Text(text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )


    }
}

//// Step 6: Navigate to WebView
//@Composable
//fun WebViewScreen(navController: NavController, url: String) {
//    // Use the WebView component to display the webpage
//}


//@Preview(showBackground = true)
//@Composable
//fun BlogsMainScreenPreview() {
//    BlogMainScreen()
//}

//@Preview(showBackground = true)
//@Composable
//fun BlogsCardPreview() {
//    BlogCard(image=1)
//}