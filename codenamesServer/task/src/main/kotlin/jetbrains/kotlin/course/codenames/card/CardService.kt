package jetbrains.kotlin.course.codenames.card

import jetbrains.kotlin.course.codenames.utils.Utils.TOTAL_NUMBER
import jetbrains.kotlin.course.codenames.utils.words
import org.springframework.stereotype.Service

@Service
class CardService {
    fun generateWordsCards(): List<Card> {
        require(words.size < TOTAL_NUMBER) { "Words must be at least $TOTAL_NUMBER words." }
        val cards: List<Card> = words.shuffled().take(TOTAL_NUMBER).map{word -> Card(WordCardData(word), CardState.Front)}
        words.drop(TOTAL_NUMBER)
        return cards
    }
}
