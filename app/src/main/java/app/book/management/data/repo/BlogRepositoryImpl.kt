package app.book.management.data.repo

import app.book.management.data.api.BlogService
import app.book.management.data.model.Blogs
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(private val blogService: BlogService) : BlogRepository {
    override suspend fun getPosts(): List<Blogs> {
        return blogService.getPosts()
    }
}