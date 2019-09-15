package com.rolandoasmat

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class Q1_01_Is_UniqueTest {

    @Test
    fun isUnique_hasUniqueChars_true() {
        // Arrange
        val string = "abcdefgh12345!@#$"

        // Act
        val result = Q1_01_Is_Unique.isUnique(string)

        // Assert
        assertTrue(result)
    }

    @Test
    fun isUnique_notUniqueChars_false() {
        // Arrange
        val string = "aaaaaa"

        // Act
        val result = Q1_01_Is_Unique.isUnique(string)

        // Assert
        assertFalse(result)
    }
}