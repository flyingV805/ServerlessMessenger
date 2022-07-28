package kz.flyingv.serverlessmessenger

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kz.flyingv.serverlessmessenger.data.storage.MessengerDatabase
import kz.flyingv.serverlessmessenger.domain.repository.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ServerlessMessenger: Application() {

    private val appModule = module {
        single { Firebase.auth }
        single { Firebase.database(BuildConfig.FRB_DB_URL) }

        single { Room.databaseBuilder(androidContext(), MessengerDatabase::class.java, "Messenger.db").build() }

        single<UserRepository> { UserRepositoryImpl() }
        single<ChatsRepository> { ChatsRepositoryImpl() }
        single<MessagesRepository> { MessagesRepositoryImpl() }
        single<CompanionsRepository> { CompanionsRepositoryImpl() }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@ServerlessMessenger)
            modules(appModule)
        }
    }

}