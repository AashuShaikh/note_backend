package com.aashushaikh.spring_boot_note.database.repository

import com.aashushaikh.spring_boot_note.database.models.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, ObjectId> {
    fun findByEmail(email: String): User?
}