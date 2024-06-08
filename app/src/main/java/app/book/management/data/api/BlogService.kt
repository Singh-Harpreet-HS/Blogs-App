package app.book.management.data.api

import app.book.management.data.model.Blogs
import retrofit2.http.GET

interface BlogService {
    @GET("posts?per_page=10&page=1")
    suspend fun getPosts(): List<Blogs>
}
