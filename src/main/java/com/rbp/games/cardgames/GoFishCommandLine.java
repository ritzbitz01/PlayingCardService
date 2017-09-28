package com.rbp.games.cardgames;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.rbp.games.cardgames.model.Card;
import com.rbp.games.cardgames.model.Deck;
import com.rbp.games.cardgames.model.Player;

public class GoFishCommandLine {
	int numPlayers = 2;
	Player[] players;
	static Player playerOne;
	static Player playerTwo;
	int setSize;
	boolean gameover;
	static Deck d;
	static Scanner scan;
	static String[] validValues = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	static Map<Integer, String> setsMade;
	//	static Card upCard;

	public static void main(String[] args) {
		setsMade = new HashMap<Integer, String>();
		gameThread();
	}

	private static void gameThread() {

		System.out.println("Enter in player one name: ");
		scan = new Scanner(System.in);
		String p1name = scan.next();
		playerOne = new Player(p1name);
		System.out.println("Enter in player two name: ");
		String p2name = scan.next();
		playerTwo = new Player(p2name);
		System.out.println(playerOne.getName() + " is Player One");
		System.out.println(playerTwo.getName() + " is Player Two");

		d = new Deck(52);
		d.shuffleCards();
		deal();
		playGame();

	}

	private static void playGame() {
		boolean gameover = false;
		while (!gameover) {

			System.out.println("PLAYER ONE HAND");
			Collections.sort(playerOne.getHand().getCards());
			int handIndex = 0;
			for (Card c : playerOne.getHand().getCards()) {
				System.out.println("CARD: " + handIndex + " - " + c.getCardString());
				handIndex++;
			}

			System.out.println("PLAYER TWO HAND");
			Collections.sort(playerTwo.getHand().getCards());
			handIndex = 0;
			for (Card c : playerTwo.getHand().getCards()) {
				System.out.println("CARD: " + handIndex + " - " + c.getCardString());
				handIndex++;
			}

			System.out.println("Player 1 turn command. (# - Value of card (2-10,J,Q,K,A)");

			String input = "";
			input = scan.next();

			boolean validRequest = false;
			while (!validRequest) {
				String[] valuesInHand = new String[playerOne.getHand().getCards().size()];
				int valueIndex = 0;

				for (Card c : playerOne.getHand().getCards()) {
					valuesInHand[valueIndex] = c.getStringValue();
					valueIndex++;
				}
				for (String v : valuesInHand) {
					if (input.equals(v)) {
						validRequest = true;
						break;
					}
				}
				if (!validRequest) {
					System.out.println("Can only request a value in your hand. Try Again.");
					input = scan.next();
				}
			}

			System.out.println("Do you have any " + input + "'s");
			// Check player two's hand and take all cards with value specified
			int newCardValue = 0;
			boolean hasCard = false;
			for (Iterator<Card> iterator = playerTwo.getHand().getCards().iterator(); iterator.hasNext();) {
				Card c = iterator.next();
				if (c.getStringValue().equals(input)) {
					hasCard = true;
					playerOne.getHand().addCard(c);
					newCardValue = c.getValue();
					iterator.remove();
				}
			}

			if (!hasCard) {
				Card newCard = d.getTopCard();
				playerOne.getHand().addCard(newCard);
				newCardValue = newCard.getValue();
			}

			// Check for sets, put any down
			if (playerOne.getHand().checkForSets(newCardValue)) {
				playerOne.addSet();
			}

			System.out.println("PLAYER ONE HAND");
			handIndex = 0;
			for (Card c : playerOne.getHand().getCards()) {
				System.out.println("CARD: " + handIndex + " - " + c.getCardString());
				handIndex++;
			}
			System.out.println("PLAYER TWO HAND");
			handIndex = 0;
			for (Card c : playerTwo.getHand().getCards()) {
				System.out.println("CARD: " + handIndex + " - " + c.getCardString());
				handIndex++;
			}

			System.out.println("Player 2 turn command. (# - Value of card (2-10,J,Q,K,A)");

			input = scan.next();
			validRequest = false;
			while (!validRequest) {
				String[] valuesInHand = new String[playerTwo.getHand().getCards().size()];
				int valueIndex = 0;

				for (Card c : playerTwo.getHand().getCards()) {
					valuesInHand[valueIndex] = c.getStringValue();
					valueIndex++;
				}
				for (String v : valuesInHand) {
					if (input.equals(v)) {
						validRequest = true;
						break;
					}
				}
				if (!validRequest) {
					System.out.println("Can only request a value in your hand. Try Again.");
					input = scan.next();
				}
			}

			System.out.println("Do you have any " + input + "'s");
			// Check player two's hand and take all cards with value specified
			boolean hasCard2 = false;
			newCardValue = 0;
			for (Iterator<Card> iterator = playerOne.getHand().getCards().iterator(); iterator.hasNext();) {
				Card c = iterator.next();
				if (c.getStringValue().equals(input)) {
					playerTwo.getHand().addCard(c);
					iterator.remove();
					newCardValue = c.getValue();
					hasCard2 = true;
				}
			}
			if (!hasCard2) {
				Card newCard = d.getTopCard();
				playerTwo.getHand().addCard(newCard);
				// Check for sets, put any down, then discard
				newCardValue = newCard.getValue();
			}

			if (playerTwo.getHand().checkForSets(newCardValue)) {
				System.out.println("Player 2 Checking for sets");
				playerTwo.addSet();
			}

			if (d.getCardsLeft() == 0) {
				gameover = true;
			}
		}
	}

	private static void deal() {
		int numCards = 0;
		while (numCards < 10) {
			playerOne.getHand().addCard(d.getTopCard());
			numCards++;
			playerTwo.getHand().addCard(d.getTopCard());
			numCards++;
		}
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public int getSetSize() {
		return setSize;
	}

	public void setSetSize(int setSize) {
		this.setSize = setSize;
	}

}
