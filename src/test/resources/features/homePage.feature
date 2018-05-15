Feature:Feature:
  As a user
  I want to be able to view the availability
  So that i can book a room in a hotel

  Scenario: verify the hotel booking service is working
    Given I am on "Hotel booking form" page
    When I book with below customer details
      |Fields     |Values               |
      |firstName  |stuart+randomNum     |
      |surName    |Dunn                 |
      |price      |120                  |
      |Deposit    |false                |
      |checkIn    |2018-05-03           |
      |checkOut   |2018-05-02           |
    Then I can see customer details are added to the list

  Scenario: delete particular customer details
    Given I am on "Hotel booking form" page
    And I have customer details to delete the booking
    When I delete the booking
    Then I can see no booking for the customer



