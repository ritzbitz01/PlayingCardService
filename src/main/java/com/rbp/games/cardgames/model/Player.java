package com.rbp.games.cardgames.model;

public class Player {
	String name;
	Hand hand;
	int numSets;

	public Player(String name) {
		this.name = name;
		hand = new Hand();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public void addSet() {
		numSets++;
	}

	public int getNumSets() {
		return numSets;
	}
}
