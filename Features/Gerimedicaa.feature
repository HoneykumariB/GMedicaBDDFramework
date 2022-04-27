Feature: Test Automation Assignment on vangoghmuseum


Scenario: Verify VangoghMuseum collection page
Given Navigated to vangoghmuseum HomePage
When  User swipe right to "Ontdek de collectie"
And   clicked Ontdek de collectie link
Then  User validated the page heading as "Collectie"
And  User validated URL contains "collectie"
And  User validated the page title "Collectie - Van Gogh Museum"



Scenario: VangoghMuseum collectie searched title verification

Given Navigated to vangoghmuseum collectie page
When User searched painting with "Het Gele Huis" title
Then Search result are greater than 700


Scenario Outline: VangoghMuseum search result verification

Given Navigated to vangoghmuseum collectie page
When User searched painting with "Het Gele Huis" title
And User selected first paiting
Then User verified the painting page
And validated F Number <FNummer> value
And validated JH Number <JHNummer> value
And validated Inventoris <Inventarisnummer> value

Examples:
|FNummer|JHNummer|Inventarisnummer|
|"F0464"  |"JH1589"  |"s0032V1962"|