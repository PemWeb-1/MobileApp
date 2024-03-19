package com.example.faker.hilt

import com.example.faker.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.Duration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    private fun provideOkHttpClient(): OkHttpClient{
        val duration = Duration.ofSeconds(15)
        return OkHttpClient.Builder()
            .connectTimeout(duration)
            .readTimeout(duration)
            .writeTimeout(duration)
            .build()
    }
    @Provides
    @Singleton
    fun providesProductsService(retrofit: Retrofit): MainActivity.ProductsService {
        return retrofit.create(MainActivity.ProductsService::class.java)
    }
}