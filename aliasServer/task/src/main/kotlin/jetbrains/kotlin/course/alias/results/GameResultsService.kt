package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService.Companion.teamsStorage
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {
    companion object {
        val gameHistory: MutableList<GameResult> = mutableListOf()
    }
    fun saveGameResults(result: GameResult): Unit {
        val validTeamIds = result.all({ it.id in teamsStorage })
        require(result.isNotEmpty() and validTeamIds) { "Results cannot be empty and all team ids must be valid!" }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> = gameHistory.reversed()
}
