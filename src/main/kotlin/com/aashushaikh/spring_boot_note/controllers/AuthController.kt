package com.aashushaikh.spring_boot_note.controllers

import com.aashushaikh.spring_boot_note.security.AuthService
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Pattern
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    data class AuthRequest(
        @field:Email(message = "Invalid Email format")
        val email: String,
        @field:Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#\$%^&+=!]).{8,}\$",
            message = "Password should be 8 characters long and should include a upper case, lower case, special character and a digit."
        )
        val password: String
    )

    data class RefreshRequest(
        val refreshToken: String
    )

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/register")
    fun register(
        @RequestBody body: AuthRequest
    ){
        authService.register(email = body.email, password = body.password)
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/login")
    fun login(
        @RequestBody body: AuthRequest
    ): AuthService.TokenPair{
        return authService.login(email = body.email, password = body.password)
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/refresh")
    fun refresh(
        @RequestBody body: RefreshRequest
    ): AuthService.TokenPair{
        return authService.refresh(refreshToken = body.refreshToken)
    }

}