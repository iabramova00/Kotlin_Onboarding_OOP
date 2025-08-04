package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService {
    private val identifierFactory = IdentifierFactory()

    companion object {
        val teamsStorage : MutableMap<Identifier, Team> = mutableMapOf()
    }

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teams: MutableList<Team> = mutableListOf()

        for (i in 1..teamsNumber) {
          teams.add(Team(identifierFactory.uniqueIdentifier()))
        }

        teams.forEach { teamsStorage.putIfAbsent(it.id, it) }
        return teams
    }
}
