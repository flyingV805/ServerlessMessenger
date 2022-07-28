package kz.flyingv.serverlessmessenger.domain.repository

import kotlinx.coroutines.flow.Flow
import kz.flyingv.serverlessmessenger.data.model.Companion
import kz.flyingv.serverlessmessenger.domain.repository.base.BaseRepository

interface CompanionsRepository {

    fun testInit()

    /*lets get serious*/
    fun getAllCompanions(): Flow<List<Companion>>

}

class CompanionsRepositoryImpl: BaseRepository(), CompanionsRepository {

    override fun testInit() {

        if(database.companionDao().getCount() != 0){
            return
        }

        database.companionDao().insert(
            Companion(
                photoUrl = "https://static.wikia.nocookie.net/uncharted-game/images/3/34/Image.png/revision/latest?cb=20190305165221&path-prefix=ru",
                displayName = "Victor Sullivan",
                nickname = "@sully",
                firebaseToken = ""
            )
        )

        database.companionDao().insert(
            Companion(
                photoUrl = "https://static.wikia.nocookie.net/uncharted/images/9/9d/Nathan_Drake_from_A_Thief%27s_End.png/revision/latest?cb=20180521172750",
                displayName = "Nathan Drake",
                nickname = "@sigparvismagna",
                firebaseToken = ""
            )
        )

        database.companionDao().insert(
            Companion(
                photoUrl = "https://static.wikia.nocookie.net/uncharted-game/images/0/08/ChloeFrazer-UTLL.png/revision/latest?cb=20190305171141&path-prefix=ru",
                displayName = "Chloe Frazer",
                nickname = "@chlochlo",
                firebaseToken = ""
            )
        )

        database.companionDao().insert(
            Companion(
                photoUrl = "https://static.wikia.nocookie.net/uncharted-game/images/0/02/Uncharted-4-elena-fisher-0.jpg/revision/latest?cb=20190305170919&path-prefix=ru",
                displayName = "Elena Fisher",
                nickname = "@thebige",
                firebaseToken = ""
            )
        )

    }

    override fun getAllCompanions(): Flow<List<Companion>> = database.companionDao().getAllFlow()


}