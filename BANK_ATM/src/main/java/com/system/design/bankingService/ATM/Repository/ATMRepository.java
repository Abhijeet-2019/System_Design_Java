package com.system.design.bankingService.ATM.Repository;

import com.system.design.bankingService.ATM.domain.ATM;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ATMRepository  extends JpaRepository<ATM, Integer> {

}
