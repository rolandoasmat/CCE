package com.rolandoasmat

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
object Q1_01_Is_Unique {

    fun isUnique(s: String): Boolean {
        val set = HashSet<Char>()
        s.forEach {
            if (set.contains(it)) {
                return false
            } else {
                set.add(it)
            }
        }
        return true
    }

}