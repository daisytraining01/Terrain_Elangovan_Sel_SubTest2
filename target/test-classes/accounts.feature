
@Transferfunds
Feature: To Transfer funds between the accounts  

  @pgma
  Scenario: Fund Transfer
    Given Login in to the application
    And click on the transfer    
    And select the between accounts
    And Fill the between accounts form and click on transfer
    Then Validate with the savings account balance from the amount you have entered    

@pgmd
	Scenario: Add the recipient
	And Wait for the page to load
	And click the transfer
  And click on Add/Edit Recipient
  And Enter the details in the Recipient form
	
  @pgmc
  Scenario Outline: Execution of Multiple records
  	And Wait for the page to load 
  	And click on the transfer
  	And click on Add/Edit Recipient
    Given Enter five records to add recipient in the Recipient information
    |Name|Email|Phone|Account Number|Description|
    |Ram |ram@gmail.com|99876543222|09876543234|Record 1|  

    