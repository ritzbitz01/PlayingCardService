package com.rbp.games.cardgames.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;
	private int size;
	private int cardsLeft;

	public Deck(int size) {
		this.size = size;
		populateDeck(size);
	}

	private void populateDeck(int numCards) {
		List<Card> allCards = new ArrayList<Card>();
		if (numCards == 52) {
			cardsLeft = 52;
			// Create the standard deck
			for (Suit s : Suit.values()) {
				List<Card> suitCards = createCards(s);
				allCards.addAll(suitCards);
			}

		}
		cards = allCards;
	}

	public List<Card> createCards(Suit suit) {
		List<Card> cards = new ArrayList<Card>();
		int value = 1;
		while (value < 14) {
			Card c = new Card(value, suit);
			cards.add(c);
			value++;
		}

		return cards;
	}

	public void shuffleCards() {
		Collections.shuffle(cards);
	}

	public Card getTopCard() {
		Card c = cards.get(0);
		cards.remove(0);
		cardsLeft--;
		return c;
	}

	public List<Card> getCards() {
		return cards;
	}

	public int getSize() {
		return size;
	}

	public int getCardsLeft() {
		return cardsLeft;
	}
}
