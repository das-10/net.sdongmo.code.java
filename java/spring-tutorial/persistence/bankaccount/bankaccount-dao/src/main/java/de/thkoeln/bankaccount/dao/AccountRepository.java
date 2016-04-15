package de.thkoeln.bankaccount.dao;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends 
  CrudRepository<Account, Long> {

	public Account findByAccountNumber(int accountNumber);
}
