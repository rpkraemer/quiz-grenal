package org.devinpf.model;

public class Fan {

	private final String name;
	private Team team;

	public Fan(final String name) {
		this.name = name;
	}

	public Fan setTeam(Team team) {
		this.team = team;
		return this;
	}

	public String getName() {
		return name;
	}
	
	public Team getTeam() {
		return team;
	}

	public boolean namePresent() {
		return (getName() != null && !getName().isEmpty());
	}
}