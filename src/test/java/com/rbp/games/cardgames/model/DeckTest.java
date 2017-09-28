package com.rbp.games.cardgames.model;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

	@Test
	public void deckCreationTest() throws Exception {
		Deck d = new Deck(52);
		for (Card c : d.getCards()) {
			System.out.println("VALUE: " + c.getValue() + " SUIT: " + c.getSuit());
			System.out.println("CARD STRING: " + c.getCardString());
			Assert.assertEquals(52, d.getSize());
		}
	}

	@Test
	public void shuffleDeckTest() throws Exception {
		Deck d = new Deck(52);
		d.shuffleCards();
		for (Card c : d.getCards()) {
			System.out.println("VALUE: " + c.getValue() + " SUIT: " + c.getSuit());
			Assert.assertEquals(52, d.getSize());
		}
	}
}
