package cu.uci.apklisupdate.base

import cu.uci.apklisupdate.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class RestClient<T>(type: Class<T>) {

    companion object {
        private const val CONNECTION_TIMEOUT_MS = 30000L
        private const val READ_TIMEOUT_MS = 30000L
        private const val WRITE_TIMEOUT_MS = 30000L
    }

    var mApi: T

    // http client
    private var mOkHttpClient: OkHttpClient

    private val baseUrl: String = "https://api.apklis.cu/"

    init {

        val userAgentInterceptor = Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .header("User-Agent", BuildConfig.LIBRARY_PACKAGE_NAME)
            val request = requestBuilder.build()
            chain.proceed(request)
        }

        mOkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(userAgentInterceptor)
            .connectTimeout(CONNECTION_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .client(mOkHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

        mApi = retrofit.create(type)
    }

}