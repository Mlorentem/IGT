package com.igt.coding.bets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@RestController
public class BetController {
	@Autowired
	BetService betService;
	
	
	@GetMapping(value = "/jackpot-draw")
	public String jackpotWon(@RequestParam 
	@NotBlank
	@Pattern(regexp = "\\d+")
	@Min(value = 1)
	@Max(value = 5000)
	@Valid String betAmount) {
		//HardCoded jackpot value just to make the formula easier to calculate
		float jackpot = 2500;
		String resultMessage = "";
		Bet bet = new Bet();
		
//		try {
			int betValue = Integer.parseInt(betAmount);
//			if(betValue < 1 || betValue > 5000) throw new IllegalArgumentException("Bet must be positive and in range from 1 to 5000");

			bet.setBetAmount(betValue);
			bet.setWinningPercentage(betService.calculateOdds(betValue, jackpot));
			bet.setJackpotWon(betService.checkWin(bet.getWinningPercentage()));
			bet.setJackpotAmount(jackpot);
			betService.saveBet(bet);
			if(bet.isJackpotWon()) {
				resultMessage = "You've won the jackpot! + ODDS:" + bet.getWinningPercentage() + "%";
			}else {
				resultMessage = "You didn't win, better luck next time + ODDS: " + bet.getWinningPercentage() + "%";
			}
//		} catch (NumberFormatException e) {
//			resultMessage = "There are characters in the bet input";
//		} catch (IllegalArgumentException e) {
//			resultMessage = e.getMessage();	
//		}
		return resultMessage;
	}
	
	@GetMapping(value = "/bets")
	public List<Bet> retrieveAllBets(){
		return betService.retrieveAllBets();
	}
}
