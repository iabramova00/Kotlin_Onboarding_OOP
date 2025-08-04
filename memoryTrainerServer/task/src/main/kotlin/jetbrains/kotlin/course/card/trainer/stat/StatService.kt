package jetbrains.kotlin.course.card.trainer.stat

import jetbrains.kotlin.course.card.trainer.card.Back
import org.springframework.stereotype.Service

@Service
class StatService {
    companion object {
        val history: MutableList<Stat> = mutableListOf()
    }
    fun getHistory(): MutableList<Stat> = history.reversed().toMutableList()

    fun save(knownBacks: List<String>, unknownBacks: List<String>): Unit {
        history.add(Stat( knownBacks.map({it -> Back(it) }),
            unknownBacks.map({it -> Back(it) })))
    }
}
