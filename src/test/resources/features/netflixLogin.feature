Feature: As a user I want to Login into Netflix site To manage and use my account

  @Test
  Scenario: Login with invalid credentials
    Given I am in the LoginPage
    When I enter invalid credentials 
    Then I get the massage: Contraseña incorrecta
   
   @Test 
   Scenario: Login without credentials
   	Given I am in the LoginPage
   	When I dont enter credentials
   	Then I get the massage: Ingresa un email o un número de teléfono válido
   
	
  