package app.book.management.data.repo

import app.book.management.data.model.Blogs

interface BlogRepository {
    suspend fun getPosts(): List<Blogs>
}