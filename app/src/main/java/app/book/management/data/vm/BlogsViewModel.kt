package app.book.management.data.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.book.management.data.model.Blogs
import app.book.management.data.repo.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogsViewModel @Inject constructor(private val repository: BlogRepository) : ViewModel() {
    private val _posts = MutableStateFlow<List<Blogs>>(emptyList())
    val posts: StateFlow<List<Blogs>> = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            _posts.value = repository.getPosts()
        }
    }
}