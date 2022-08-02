package com.gunmer.alfred.db.sources

import com.gunmer.alfred.db.model.FamilyDao
import org.springframework.data.repository.CrudRepository

interface FamilySource : CrudRepository<FamilyDao, String>
