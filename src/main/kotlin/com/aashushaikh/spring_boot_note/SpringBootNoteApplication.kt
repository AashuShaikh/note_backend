package com.aashushaikh.spring_boot_note

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootNoteApplication

fun main(args: Array<String>) {
	runApplication<SpringBootNoteApplication>(*args)
}
