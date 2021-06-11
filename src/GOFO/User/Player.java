package GOFO.User;

import GOFO.Utilities.Address;
import GOFO.Utilities.Ewallet;
import GOFO.Utilities.Team;

import java.util.ArrayList;
import java.util.Map;

/**
 * Player: Represents a Player and his/her properties and methods.
 * @author  Kangana Alain
 * @version 1.0
 */
public class Player extends User{

    private ArrayList<Team> teams;
    /**
     * Construct a Player object.
     * @param fName first name
     * @param lName last name
     * @param id user id
     * @param email email
     * @param password password
     * @param phoneNumber phone number
     * @param address Address object
     * @param ewallet EWallet object
     */
    public Player(String fName, String lName, String id, String email,
                  String password, String phoneNumber, Address address, Ewallet ewallet) {
        super(fName, lName, id, email, password, phoneNumber, address, ewallet);
        teams = new ArrayList<>();
    }


    /**
     * Add a new team to the list
     * @param team team object
     */
    public void addTeam(Team team) {
        teams.add(team);
    }

    /**
     * Returns a list of the Player teams
     * @return teams
     */
    public ArrayList<Team> getTeam() {
        return teams;
    }

    /**
     * Checks if a player has a team with given name .
     * @param teamName team name
     * @return true if found otherwise false
     */
    public boolean hasTeam(String teamName) {
        for (Team team: teams) {
            if (team.getTeamName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a team info if found
     * @param teamName team name
     * @return team object
     */
    public Team getTeamInfo(String teamName) {
        for (Team team: teams) {
            if (team.getTeamName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }
}
