# System_Design_Java
This is a Micro Service Project that is created to design an ATM that can be used by a customer to 
  1. Withdraw Cash
  2. Deposit Cash
  3. Print Mini-Statement.

This application has three Micro-services 
  1. ATM API Gateway
  2. Customer ATM : This service is used to:
     add Customer in a bank
    1.Deposit money using ATM
    2. Withdraw cash
			check if card is valid or not.
			check if cash available in ATM.
			check withdraw amount is valid.
			Withdraw cash
			Update Customer account.
		3. Check balance
			check if card is valid or not.
			print cash available with Customer.
			
		4. print mini statement.
			check if card is valid or not.
		5. Change pin
			check if card is valid or not.
			update Pin
    
 3. BANK ATM : This service is used
     Send money asked by Customer service
     Check if money is available.
     Generate Daily Reports
    

