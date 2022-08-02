package com.gunmer.alfred.db.repositories

import com.gunmer.alfred.db.model.FamilyDb
import org.springframework.data.repository.CrudRepository

interface FamilyRepository : CrudRepository<FamilyDb, String>
