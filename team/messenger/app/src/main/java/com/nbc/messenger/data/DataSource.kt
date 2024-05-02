package com.nbc.messenger.data

import com.nbc.messenger.model.My
import com.nbc.messenger.model.ProfileImage
import com.nbc.messenger.model.User
import kotlinx.parcelize.Parcelize

object DataSource {

    private val users: MutableList<User> = MemoryStorage.users.toMutableList()

    fun addUser(user: User) {
        users.add(user)
    }

    fun searchByName(_name: String): User? {
        return users.find { it.name==_name }
    }

    fun updateIsChecked(_user:User, _changeTo: Boolean){
        users[users.indexOf(_user)].isChecked = _changeTo
    }

    fun getUsers(): List<User> = users

    private var my: My = My(
        id = "1",
        name = "Anna",
        nickname = "anna",
        phoneNumber = "1717171717",
        email = "anna@example.com",
        profileImage = ProfileImage.DefaultImage
    )

    fun setMyData(my: My) {
        this.my = my
    }

    fun getMyData(): My = my
}