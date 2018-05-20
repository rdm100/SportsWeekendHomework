package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="managers")
public class Manager extends Employee {

    private int moneyForTransfers;
    private Team team;


    public Manager(String name, int salary, int moneyForTransfers) {
        super(name, salary);
        this.moneyForTransfers = moneyForTransfers;

    }

    public Manager() {
    }

    @Column(name="MoneyForTransfers")
    public int getMoneyForTransfers() {
        return moneyForTransfers;
    }

    public void setMoneyForTransfers(int moneyForTransfers) {
        this.moneyForTransfers = moneyForTransfers;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }





}