Feature: Owner Adding
  As a Developer
  I want to add Owner trough API
  So that It can be available to applications

    Background:
      Given The Endpoint "http://localhost:8080/api/v1/propietarios" is available for owners

      @owner-adding
      Scenario: Add Owner
        When A Owner request is sent with values "Andrea", "Luna", "Jr. Manzanales 420", "andrea420", "andrea@gmail.com", "12436587"
        Then A Response with Status 200 is received for the owner