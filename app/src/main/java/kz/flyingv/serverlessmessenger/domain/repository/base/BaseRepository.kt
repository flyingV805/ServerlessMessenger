package kz.flyingv.serverlessmessenger.domain.repository.base

import com.google.firebase.database.FirebaseDatabase
import kz.flyingv.serverlessmessenger.data.storage.MessengerDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseRepository: KoinComponent {

    protected val firebaseDatabase: FirebaseDatabase by inject()
    protected val database: MessengerDatabase by inject()


}