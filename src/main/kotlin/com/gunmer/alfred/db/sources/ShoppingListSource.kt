package com.gunmer.alfred.db.sources

import com.gunmer.alfred.db.model.ShoppingListDao
import org.springframework.data.repository.CrudRepository

interface ShoppingListSource : CrudRepository<ShoppingListDao, String>
