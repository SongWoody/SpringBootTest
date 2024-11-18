package com.server.woody.woody.database

import com.server.woody.woody.database.entities.Members
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    lateinit var productRepository: ProductRepository

    fun saveProduct(product: Members): Members {
        return productRepository.save(product)
    }
}