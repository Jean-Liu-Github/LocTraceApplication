package com.rosy.loctraceapplication.exception

import java.lang.Exception

class BusinessException : Exception() {
    lateinit var code : String
    lateinit var mes : String

}