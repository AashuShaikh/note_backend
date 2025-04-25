package com.aashushaikh.spring_boot_note.database.repository

import com.aashushaikh.spring_boot_note.database.models.Note
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository: MongoRepository<Note, ObjectId> {
    fun findByOwnerId(ownerId: ObjectId): List<Note>
}