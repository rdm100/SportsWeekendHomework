import db.DBHelper;
import models.League;
import models.Manager;
import models.Player;
import models.Team;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        League league = new League("Serie a");
        DBHelper.saveOrUpdate(league);

        Manager manager1 = new Manager("Pep Guardiola", 10000, 150000000);
        DBHelper.saveOrUpdate(manager1);

        Manager manager2 = new Manager("Arrigo Sacchi ", 10000, 20000000);
        DBHelper.saveOrUpdate(manager2);

        Manager manager3 = new Manager("Fabio Capello ", 10000, 20000000);
        DBHelper.saveOrUpdate(manager2);

        Team team1 = new Team("Barcelona", 15, manager1, league);
        DBHelper.saveOrUpdate(team1);

        Team team2 = new Team("Milan", 20, manager3, league);
        DBHelper.saveOrUpdate(team2);

        Team team3 = new Team("Lazio", 17, manager2, league);
        DBHelper.saveOrUpdate(team3);

        Player player1 = new Player("Maradonna", 100, team2);
        DBHelper.saveOrUpdate(player1);

        Player player2 = new Player("Pele", 100, team2);
        DBHelper.saveOrUpdate(player2);

        Player player3 = new Player("Alessandro Nesta", 100, team2);
        DBHelper.saveOrUpdate(player3);

        Player player4 = new Player("Pavel Nedved", 100, team2);
        DBHelper.saveOrUpdate(player4);

        List<Player> players = DBHelper.getAll(Player.class);
        List<Manager> managers = DBHelper.getAll(Manager.class);

        List<League> leagues = DBHelper.getAll(League.class);

        List<Team> teams = DBHelper.getAll(Team.class);

        List<Player> playersInTeam1 = DBHelper.getPlayersByTeam(team1);

        List<Player> playersInTeam2 = DBHelper.getPlayersByTeam(team2);

        List<Team> teamsInLeague = DBHelper.getTeamsByLeague(league);

        List<Team> teamsByPoints = DBHelper.getOrderOfTeamByPoints();

    }
}
