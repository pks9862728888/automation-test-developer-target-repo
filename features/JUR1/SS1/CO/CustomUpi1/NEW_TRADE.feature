Feature: E2E Test works

  Background:
    Given Test meta-data folder=/JUR1/SS1/CO/CustomUpi1/ and test-resources folder=/SS1/CO/CustomUpi1/ where baseFolder=/src/test/resources/

  Scenario Outline: <Test Name>

    Given Inputs are loaded from meta-data file
    And Trade is set to be published to DEST1
    When Trade inputs are processed / published
    Then Verify whether trade is reportable to jurisdiction JUR1
    Examples:
      | Test Name               |
      | JUR1_SS1_CUSTOM_UPI_NEW |
