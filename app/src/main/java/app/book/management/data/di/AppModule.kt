package app.book.management.data.di

import app.book.management.data.api.BlogService
import app.book.management.data.repo.BlogRepository
import app.book.management.data.repo.BlogRepositoryImpl
import app.book.management.data.vm.BlogsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val BASE_URL = "https://blog.vrid.in/wp-json/wp/v2/"

    @Provides
    fun provideBlogService(): BlogService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BlogService::class.java)
    }

    @Provides
    fun provideBlogRepository(blogService: BlogService): BlogRepository {
        return BlogRepositoryImpl(blogService)
    }
}

