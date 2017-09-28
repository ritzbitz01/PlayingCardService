package com.rbp.games.cardgames.model;

public class Card implements Comparable<Card> {
	private int value;
	private Suit suit;

	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public String getStringValue() {
		String stringValue = "";
		switch (value) {
		case 1:
			stringValue = "A";
			break;
		case 11:
			stringValue = "J";
			break;
		case 12:
			stringValue = "Q";
			break;
		case 13:
			stringValue = "K";
			break;
		default:
			stringValue = Integer.toString(value);
		}
		return stringValue;
	}

	public String getCardString() {
		String stringValue = getStringValue();

		return stringValue + suit;
	}

	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}

}
