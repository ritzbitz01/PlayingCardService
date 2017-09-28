package com.rbp.games.cardgames.model;

import org.junit.Assert;
import org.junit.Test;

public class HandTest {

	@Test
	public void setTest() throws Exception {
		Hand hand = new Hand();
		Card c1 = new Card(2, Suit.H);
		Card c2 = new Card(2, Suit.S);
		Card c3 = new Card(2, Suit.D);
		Card c4 = new Card(2, Suit.C);
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		hand.addCard(c4);

		boolean hasset = hand.checkForSets(2);

		Assert.assertEquals(true, hasset);
	}

}
