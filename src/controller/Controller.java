package controller;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import model.Board;
import model.BucketZombie;
import model.ExplosiveZombie;
import model.Player;
import model.Spot;
import model.Wave;
import model.Zombie;
import view.MainFrame;
import view.WaveInfoPanel;

public class Controller {

	private Player currentPlayer = new Player(300);
	private Board gameBoard = new Board(currentPlayer);
	private Wave wave = null;

	public Controller() {
		
	}

	/***
	 * Updates the icons that are on the board
	 */
	public void nextTurn() {
		for (Spot s : gameBoard.getGrid()) {			
			/***
			 * Moves any plants that are on the board
			 */
			if (s.isHasSunflower()) {
				s.getSpotSunflower().addSunToPlayer();
			}
			if (s.isHasDSunflower()) {
				s.getSpotDSunflower().addDSunToPlayer();
			}
			if (s.isHasPea()) {
				s.getSpotPeaShooter().attackZombie();
			}
			
			/**
			 * Moves the zombies that are on the board
			 */
			//Moves Normal zombies
			if (s.isHasZombie()) {
				if (s.getSpotZombies() != null) {
					for (Zombie z : s.getSpotZombies()) {
						z.moveZombie();
					}
				}
			}
			//Moves any Explosive Zombies
			if(s.isHasEZombie()) {
				if(s.getExplosiveZombies() != null) {
					for(ExplosiveZombie z : s.getExplosiveZombies()) {
						z.moveZombie();
					}
				}
			}
			//Moves any Bucket Zombie
			if(s.isHasBZombie()) {
				if(s.getBucketZombies() != null) {
					for(BucketZombie z : s.getBucketZombies()) {
						z.moveZombie();
					}
				}
			}
		}

		System.out.println(Integer.toString(wave.getNumberOfZombies()) + " Zombies remain!\n");
		
		//Prints out winning messages
		if (wave.getNumberOfZombies() == 0) {
			System.out.println("Congrats you have defeated this wave of zombies!\nYou Win!\n");
			wave.setOngoing(false);
		}
	}

	public Spot spotAt(int spotId) {
		return gameBoard.spotAt(spotId);
	}

	public int getSpotXCord(Spot spot) {
		return spot.getxCord();
	}

	public int getSpotYCord(Spot spot) {
		return spot.getyCord();
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public Wave getWave() {
		return wave;
	}

	public ArrayList<Integer> getZombieSpotIds() {
		ArrayList<Integer> spotIds = new ArrayList<Integer>();

		for (Spot s : gameBoard.getGrid()) {
			if (s.isHasZombie() || s.isHasBZombie() || s.isHasEZombie()) {
				spotIds.add(s.getSpotId());
			}
		}
		return spotIds;
	}

	/**
	 * Starts a new wave, with a certain number of normal, bucker and explosive zombies
	 * @param normal
	 * @param bucket
	 * @param explosive
	 */
	public void startWave(int normal, int bucket, int explosive) {
		wave = new Wave(normal, bucket, explosive, gameBoard);
	}

	/**
	 * Return the number of Zombies on the board
	 * @return
	 */
	public int getZombieCount() {
		return wave.getNumberOfZombies();
	}

	/**
	 * Returns the numer of Sun Points that are available
	 * @return
	 */
	public int getCurrentSunAmount() {
		return currentPlayer.getSunAmount();
	}

	/***
	 * Get the Description for the Actors that are on the board
	 * @return
	 */
	public String getTurnDescription() {
		String turnDescription = "";
		for (Spot s : gameBoard.getGrid()) {
			if (s.getSpotZombies().size() != 0) {
				for (Zombie z : s.getSpotZombies()) {
					turnDescription += z.getTurnDescriptionZombie();
				}
			}
			if (s.getBucketZombies().size() != 0) {
				for (BucketZombie z : s.getBucketZombies()) {
					turnDescription += z.getTurnDescriptionZombie();
				}
			}
			if (s.getExplosiveZombies().size() != 0) {
				for (ExplosiveZombie z : s.getExplosiveZombies()) {
					turnDescription += z.getTurnDescriptionZombie();
				}
			}
		}
		for (Spot s : gameBoard.getGrid()) {
			if (s.isFilled()) {
				if (s.isHasSunflower()) {
					turnDescription += s.getSpotSunflower().getTurnDescriptionSunflower();
				} else if (s.isHasDSunflower()) {
					turnDescription += s.getSpotDSunflower().getTurnDescriptionDSunflower();
				} else if (s.isHasPea()) {
					turnDescription += s.getSpotPeaShooter().getPeaShooterTurnDescription();
				}else if (s.isHasPotatoe()) {
					turnDescription += s.getSpotPotatoe().getTurnDescriptionPotatoe();
				}
			}
		}
		return turnDescription;
	}

	/***
	 * Checks if the game has reached an end point
	 * @return
	 */
	public boolean checkGameOver() {
		return gameBoard.isGameOver();
	}
}
