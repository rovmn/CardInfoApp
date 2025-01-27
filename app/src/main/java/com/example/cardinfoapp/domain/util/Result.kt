package com.example.cardinfoapp.domain.util

sealed class Result<T>

class SuccessResult<T>(
    val data: T
) : Result<T>()

class EmptyResult<T> : Result<T>()

class ErrorResult<T> (
    val e: Exception
) : Result<T>()