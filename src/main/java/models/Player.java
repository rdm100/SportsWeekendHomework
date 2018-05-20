package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="players")
public class Player extends Employee {
    private Team team;

    public Player(String name, int wage, Team team) {
        super(name, wage);
        this.team = team;
    }

    public Player() {
    }

    @ManyToOne
    @JoinColumn(name="team_id", nullable = false)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}