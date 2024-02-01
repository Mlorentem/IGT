package com.igt.coding.bets;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Bet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	
	private float betAmount;
	
	private float jackpotAmount, winningPercentage;
	private boolean jackpotWon;
	
	
	public Bet(float betAmount, float jackpotAmount, boolean jackpotWon, float winningPercentage ) {
		super();
		this.betAmount = betAmount;
		this.jackpotAmount = jackpotAmount;
	}
	
	public Bet() {
		super();
	}

	public float getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(float betAmount) {
		this.betAmount = betAmount;
	}
	public boolean isJackpotWon() {
		return jackpotWon;
	}
	public void setJackpotWon(boolean jackpotWon) {
		this.jackpotWon = jackpotWon;
	}
	public float getWinningPercentage () {
		return winningPercentage ;
	}
	public void setWinningPercentage (float winningPercentage ) {
		this.winningPercentage  = winningPercentage ;
	}

	public float getJackpotAmount() {
		return jackpotAmount;
	}

	public void setJackpotAmount(float jackpotAmount) {
		this.jackpotAmount = jackpotAmount;
	}
	
	@Override
	public String toString() {
		return "Bet [id=" + id + ", betAmount=" + betAmount + ", jackpotAmount=" + jackpotAmount + ", jackpotWon="
				+ jackpotWon + ", winningPercentage=" + winningPercentage + "]";
	}

}
