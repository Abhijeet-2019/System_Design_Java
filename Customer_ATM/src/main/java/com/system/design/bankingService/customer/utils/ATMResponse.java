package com.system.design.bankingService.customer.utils;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Data
public class ATMResponse  {

    public String responseMsg;
    public Object data;
    public String transactionStatus;

}
