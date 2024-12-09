package utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File


    fun loadJsonFileAsMap(filePath: String): Map<String, Any> {
        return try {

            val file = File(filePath)
            val jsonString = file.readText()


            val mapper = jacksonObjectMapper()
            mapper.readValue(jsonString, Map::class.java) as Map<String, Any>
        } catch (e: Exception) {
            e.printStackTrace()
            emptyMap()
        }
    }

