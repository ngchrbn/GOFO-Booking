package GOFO.Utilities;

import GOFO.User.Player;

import java.util.ArrayList;

/**
 * Team: Represent a team with its attributes and methods.
 * @author Mahamat Ibrahim Mahamat
 * @version 1.0
 */
public class Team {
    private String teamName;
    private String ownerID;
    private ArrayList<Player> members;

    /**
     * Construct a team object
     * @param teamName team name
     * @param ownerID owner id
     * @param members team's members
     */
    public Team(String teamName, String ownerID, ArrayList<Player> members) {
        setTeamName(teamName);
        setOwnerID(ownerID);
        setMembers(members);
    }

    /**
     * Set team name
     * @param teamName team name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Set owner id
     * @param ownerID owner id
     */
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    /**
     * Set the members of the team
     * @param members team's members
     */
    public void setMembers(ArrayList<Player> members) {
        this.members = members;
    }

    /**
     * Returns team's name
     * @return team's name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Returns owner id
     * @return owner id
     */
    public String getOwnerID() {
        return ownerID;
    }

    /**
     * Returns team's members
     * @return team's members
     */
    public ArrayList<Player> getMembers() {
        return members;
    }
}
