package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="teams")
public class Team {
    private int id;
    private String name;
    private int points;
    private Manager manager;
    private League league;
    private Set<Player> players;

    public Team(String name, int points, Manager manager, League league) {
        this.name = name;
        this.points = points;
        this.manager = manager;
        this.league = league;
    }

    public Team() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @OneToOne(mappedBy = "team", fetch = FetchType.EAGER)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @ManyToOne
    @JoinColumn(name="league_id", nullable = false)
    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public void win() {
        this.points += 3;
    }

    public void draw(){
        this.points += 1;
    }
}
