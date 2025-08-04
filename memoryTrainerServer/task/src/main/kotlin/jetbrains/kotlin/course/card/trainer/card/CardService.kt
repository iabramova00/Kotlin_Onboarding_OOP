package jetbrains.kotlin.course.card.trainer.card

import jetbrains.kotlin.course.card.trainer.util.countries
import org.springframework.stereotype.Service

@Service
class CardService {
    companion object {
        val randomCardGenerator = CardSequenceGenerator {
            countries.map {(key, value) -> Card(Front(key), Back(value))}.shuffled()
        }
        fun generateNewCardsSequence() = randomCardGenerator.generateCards().toMutableList()
        var cards = generateNewCardsSequence()
    }
    fun getNextCard(): Card {
        require(cards.isNotEmpty()) { "cards must not be empty" }
        return cards.removeFirst()
    }

    fun startNewGame(): Card {
        cards = generateNewCardsSequence()
        return getNextCard()
    }
}
