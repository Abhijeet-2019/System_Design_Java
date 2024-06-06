package com.system.design.bankingService.ATM.Repository;

import com.system.design.bankingService.ATM.domain.ATM;
import jakarta.ws.rs.QueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ATMRepository extends JpaRepository<ATM, Integer> {
    @Query("select atm from ATM atm where atm.atm_Id= :atm_Id ")
    public ATM findbyAtm_Id(@Param("atm_Id") int atm_Id);

}
