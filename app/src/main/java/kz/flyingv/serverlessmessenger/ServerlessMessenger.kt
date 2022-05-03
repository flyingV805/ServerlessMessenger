package kz.flyingv.serverlessmessenger

import android.app.Application
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kz.flyingv.serverlessmessenger.data.repository.MessagesRepository
import kz.flyingv.serverlessmessenger.data.repository.MessagesRepositoryImpl
import kz.flyingv.serverlessmessenger.data.repository.UserRepository
import kz.flyingv.serverlessmessenger.data.repository.UserRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ServerlessMessenger: Application() {

    private val appModule = module {
        single { Firebase.auth }
        single { Firebase.database(BuildConfig.FRB_DB_URL) }
        single<UserRepository> { UserRepositoryImpl() }
        single<MessagesRepository> { MessagesRepositoryImpl() }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@ServerlessMessenger)
            modules(appModule)
        }
    }

}