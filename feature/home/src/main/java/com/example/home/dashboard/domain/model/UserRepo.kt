package com.example.home.dashboard.domain.model

import com.example.core.domain.model.BaseDomainModel

data class UserRepo(
    val id: Long,
    val name: String,
    val description: String?
) : BaseDomainModel()