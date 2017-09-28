package com.rbp.games.cardgames.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Hand {

	ArrayList<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void addCard(Card c) {
		cards.add(c);
	}

	public void discardCard(int cardIndex) {
		cards.remove(cardIndex);
	}

	public Card getCard(int cardIndex) {
		return cards.get(cardIndex);
	}

	public boolean checkForSets(int cardValue) {
		Collections.sort(cards);
		boolean hasSet = false;
		int numCardsInSet = 0;
		for (Card c : cards) {
			if (c.getValue() == cardValue) {
				numCardsInSet++;
				System.out.println("FOUND A CARD TOTAL: " + numCardsInSet);
			}
			if (c.getValue() > cardValue || numCardsInSet == 4)
				break;
		}
		if (numCardsInSet == 4) {
			hasSet = true;
			System.out.println("Set Complete");
			for (Iterator<Card> iterator = cards.iterator(); iterator.hasNext();) {
				Card c = iterator.next();
				if (c.getValue() == cardValue) {
					iterator.remove();
				}
			}
		}
		return hasSet;
	}

}
