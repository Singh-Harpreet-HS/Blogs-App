package app.book.management.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import app.book.management.data.model.Blogs
import app.book.management.data.vm.BlogsViewModel
import javax.inject.Inject

@Composable
fun BlogsScreen(viewModel: BlogsViewModel = viewModel()) {

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            BlogList(viewModel)
        }

    }
}


@Composable
fun BlogList(viewModel: BlogsViewModel) {
    val posts by viewModel.posts.collectAsState()

    LazyColumn {
        items(posts) { post ->
            BlogPostItem(post)
        }
    }
}

@Composable
fun BlogPostItem(post: Blogs) {
    Column {
        Text(text = "${post.title.rendered}")
        Text(text = "${post.author}")
    }
}

//@Preview
//@Composable
//fun PreviewBlogList() {
//    BlogList("")
//}
