package io.my1795.metadata

import jakarta.enterprise.context.ApplicationScoped
import java.util.*


@ApplicationScoped
class TitleCapitalizer {
    private val ignoredWords = setOf("a", "and", "as", "at", "but", "by", "for", "if", "in", "nor", "of", "off", "on", "or", "the", "to", "up", "vs")
    private val stopSymbols = setOf(":", "- ", "–", "—", "\n")
    fun capitalize(title: String?): String? {
        if (title == null || title.isBlank()) return title
        val builder = StringBuilder(title.lowercase(Locale.getDefault()))
        val length = title.length
        var capitalizeNextWord = true
        var firstAlphaOccurred = false
        var index = 0
        while (index < length) {
            var codePoint = title.codePointAt(index)
            val currentIndex = index
            val stopChar = stopSymbols.stream().anyMatch { s: String? -> currentIndex == builder.indexOf(s, currentIndex) }
            if (!Character.isLetterOrDigit(codePoint)) {
                capitalizeNextWord = true
            } else if (capitalizeNextWord) {
                val nextWordEnd = Math.max(builder.indexOf(" ", index), builder.indexOf("-", index))
                val nextWord = if (nextWordEnd != -1) builder.substring(index, nextWordEnd) else builder.substring(index)
                if (!firstAlphaOccurred || !ignoredWords.contains(nextWord)) {
                    builder.setCharAt(index, codePoint.toChar())
                }
                capitalizeNextWord = false
            }
            index += Character.charCount(codePoint)
            firstAlphaOccurred = firstAlphaOccurred || Character.isAlphabetic(codePoint)
            if (stopChar) firstAlphaOccurred = false
        }
        return builder.toString()
    }
}