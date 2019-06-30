package com.example.hellospringboot.model

open class CommonHeader(val headers:Map<String, String>) {

    open fun getHeader( key: String): String? {
        return headers.get(key)
    }
}