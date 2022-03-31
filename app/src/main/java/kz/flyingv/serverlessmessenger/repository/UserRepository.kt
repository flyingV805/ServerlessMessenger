package kz.flyingv.serverlessmessenger.repository

import android.util.Log
import kz.flyingv.serverlessmessenger.model.ActionResult
import kz.flyingv.serverlessmessenger.model.AppUser
import kz.flyingv.serverlessmessenger.model.ProfileUpdate
import kz.flyingv.serverlessmessenger.repository.base.BaseRepository

interface UserRepository {


    fun setAppUser(appUser: AppUser): ActionResult
    fun editProfile(profileUpdate: ProfileUpdate): ActionResult

}

class UserRepositoryImpl: UserRepository, BaseRepository() {

    override fun setAppUser(appUser: AppUser): ActionResult {
        //step 1. check if user exists
        val checkUserResult = firebaseDatabase.reference.child("appUsers").child(appUser.userId!!).get().result
        Log.d("checkUserResult", checkUserResult.toString())
        //val addUserResult = firebaseDatabase.reference.child("appUsers").child(appUser.userId!!).setValue(appUser).result
        //Log.d("addUserResult", addUserResult.toString())
        //addUserResult.toString()
        return ActionResult(false)
    }

    override fun editProfile(profileUpdate: ProfileUpdate): ActionResult {
        return ActionResult(false)
    }
}

