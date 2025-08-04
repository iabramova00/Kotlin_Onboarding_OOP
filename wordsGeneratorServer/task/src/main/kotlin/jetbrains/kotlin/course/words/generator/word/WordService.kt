package jetbrains.kotlin.course.words.generator.word

import jetbrains.kotlin.course.words.generator.util.words
import org.springframework.stereotype.Service

@Service
class WordService {
    companion object {
        val numberOfWords = words.size
        val previousWords: MutableMap<String, MutableList<Word>> = mutableMapOf()
    }

    fun generateNextWord(): Word {
        require(words.isNotEmpty()) { "Word list is empty" }
        val firstWord = words.removeFirst()
        return Word(firstWord)
    }

    fun isValidWord(keyWord: String, newWord: String): Boolean {
        require(newWord.isNotEmpty()) { "New word is empty" }
        return newWord.all({ it in keyWord })
    }

    fun isNewWord(keyWord: String, newWord: String): Boolean {
        return previousWords.getOrPut(keyWord) { mutableListOf() }
            .let { if (Word(newWord) in it) false else it.add(Word(newWord)).let { true } }
    }
}
