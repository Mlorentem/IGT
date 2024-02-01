package com.igt.coding.bets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//public interface PricesRepository extends JpaRepository<Prices, Long>{
@Repository
public interface BetRepository extends JpaRepository<Bet, Long>{
	
}
