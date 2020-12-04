Feature: Home Insurance Enquiry form

  Scenario Outline: Home Insurance About you section
    Given the user is on the policy enquiry page
    When the user's personal information such as "<Title>" "<FirstName>" "<LastName>" "<MaritalStatus>" "<Smoking>" is entered
    Then details should get saved successfully

    Examples:
      | Title | FirstName | LastName  | MaritalStatus | Smoking |
      | mr    | Dinesh    | Mariathas | married       | No      |


  Scenario Outline: Home Insurance Statement About you section
    Given the user is on the policy enquiry page
    When the user select statement option as "<AgreeOrDisagree>" "<businessPurpose>" "<bankrupt>" "<CourtJudgement>" "<renewalRefused>" "<HomeIncCancelled>" "<convicted>"
    Then details should get saved successfully

    Examples:
      | AgreeOrDisagree | businessPurpose | bankrupt   | CourtJudgement | renewalRefused | HomeIncCancelled | convicted |
      | I agree1        | I agree         | I disagree | I agree 1      | I agree        | I agree          | I agree   |


    # Type of property can be house,flat_apartment,bungalow,other
  Scenario Outline: Home Insurance Statement About your property
    Given the user is on the policy enquiry page
    When the user enter the property information as "<address>" "<typeOfProperty>"
    Then details should get saved successfully

    Examples:
      | address   | typeOfProperty |
      | Greenford | house       |
      | Greenford | flat_apartment |
      | Greenford | bungalow       |
      | Greenford | other          |

# GoCompareQuotes line is commented in the script in order to avoid too many qoute generation
  Scenario: Home Insurance Enquiry Form validation
    Given the user is on the policy enquiry page
    When the user enter the personal information, property information,Insurance history, Cover details
    And the user select the go compare quotes
    Then quote details should be retrieved successfully