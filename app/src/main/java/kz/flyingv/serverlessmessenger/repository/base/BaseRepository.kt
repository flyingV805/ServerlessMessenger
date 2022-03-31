package kz.flyingv.serverlessmessenger.repository.base

import com.google.firebase.database.FirebaseDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseRepository: KoinComponent {

    protected val firebaseDatabase: FirebaseDatabase by inject()



}