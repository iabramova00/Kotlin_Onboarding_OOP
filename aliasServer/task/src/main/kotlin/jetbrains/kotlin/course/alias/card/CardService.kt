package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

@Service
class CardService {
    private val identifierFactory = IdentifierFactory()
    private val cards: List<Card> = generateCards()

    companion object {
        private const val WORDS_IN_CARD = 4
        val cardsAmount = words.size / WORDS_IN_CARD
    }

    private fun generateCards(): List<Card> {
        val cards = words.shuffled().chunked(WORDS_IN_CARD).take(cardsAmount).map {
            Card(identifierFactory.uniqueIdentifier(), it.toWords())
        }
        return cards
    }

    private fun List<String>.toWords(): List<Word> = map { Word(it) }

    fun getCardByIndex(index: Int): Card = cards.getOrNull(index) ?: error("Card with index $index not found")
}
