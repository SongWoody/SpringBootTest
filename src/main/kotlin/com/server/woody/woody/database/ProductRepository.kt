package com.server.woody.woody.database

import com.server.woody.woody.database.entities.Members
import org.springframework.data.jpa.repository.JpaRepository


interface ProductRepository: JpaRepository<Members, Long>