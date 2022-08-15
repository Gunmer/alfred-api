package com.gunmer.alfred.db.sources

import com.gunmer.alfred.db.model.UserDao
import org.springframework.data.repository.CrudRepository

interface UserSource : CrudRepository<UserDao, String>
