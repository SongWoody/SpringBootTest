package com.server.woody.jumpto.database

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

@RestController
@RequestMapping("/image")
class ImageController {
    private val thumbnail = Path.of("images/thumbnails")

    @GetMapping("/thumbnail/{id}")
    fun getThumbnail(@PathVariable id: Long): ResponseEntity<ByteArray> {
        println("/thumbnail/{id} : id = $id")
        val imagePath = thumbnail.resolve("$id.png")
        return try {
            val imageBytes = Files.readAllBytes(imagePath)
            ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageBytes)
        } catch (e: NoSuchFileException) {
            println("NoSuchFileException")
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        } catch (e: IOException) {
            println("IOException: ${e.message}")
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
        }
    }
}