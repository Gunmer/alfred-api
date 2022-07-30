package com.gunmer.alfred.db.repositories

import com.gunmer.alfred.db.model.UserDb
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserDb, String>
