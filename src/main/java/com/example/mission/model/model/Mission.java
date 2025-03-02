package com.example.mission.model.model;

public class Mission {
    private int id;
    private String name;
    private String rank; // D, C, B, A, S
    private String description;

    public Mission(int id, String name, String rank, String description) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.description = description;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRank() { return rank; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Mission{id=" + id + ", name='" + name + "', rank='" + rank + "', description='" + description + "'}";
    }
}
