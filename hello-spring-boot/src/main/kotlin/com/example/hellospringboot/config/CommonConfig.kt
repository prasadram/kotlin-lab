package com.example.hellospringboot.config

import com.example.hellospringboot.model.CommonHeader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.web.context.WebApplicationContext
import javax.servlet.http.HttpServletRequest

@Configuration
class CommonConfig {

    @Bean
    @Scope(value = "request"
            , proxyMode = ScopedProxyMode.TARGET_CLASS
    )
    open fun commonHeader(request: HttpServletRequest): CommonHeader {
        //println("Creating common header bean")
        val headerNames = request.headerNames;
        val  haders:HashMap<String, String> = HashMap<String, String>()
        var headerName:String
        while (headerNames.hasMoreElements()) {
            headerName = headerNames.nextElement()
                haders.put(headerName, request.getHeader(headerName))
        }
        return CommonHeader(haders)
    }
}