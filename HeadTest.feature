Feature:
  As a movie viewer
  i want to check the page
  and i made some requirements

  Scenario: logo
    Given I am on Home
    Then check logo

    Scenario: checking nav elements
      Given I am on Home
      Then check nav elements

      Scenario: getting nav elements
        Given I am on Home
        Then getting navlinks

  Scenario: getting account
    Given I am on Home
    Then checking account