package com.igt.coding.bets;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BetService {
	
	@Autowired
	private BetRepository betRepository;
	
	//Logic for bet winning percentage
	public float calculateOdds(float betAmount, double jackpot) {
		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.FLOOR);
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(dfs);
		
		if(jackpot < betAmount) {
			return 99f;
		}else {
			return Float.parseFloat(df.format(betAmount * 100 / jackpot));
		}
	}
	
	public boolean checkWin(double winningOdds) {
		Random randomProb = new Random();
		float realOdds = 0.01f + randomProb.nextFloat() * (100 - 0.1f);
		if(realOdds <= winningOdds) {
			return true;
		}
		return false;
	}
	
	public ResponseEntity<Bet> saveBet(Bet bet){
		betRepository.save(bet);
		return new ResponseEntity<>(bet, HttpStatus.CREATED);
	}
	
	public List<Bet> retrieveAllBets(){
		return betRepository.findAll();
	}
}
