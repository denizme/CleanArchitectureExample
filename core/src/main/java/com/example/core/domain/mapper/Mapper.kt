package com.example.core.domain.mapper

interface Mapper<in T, out R> {

    suspend fun invoke(input: T): R
}