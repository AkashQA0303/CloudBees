Feature: Git Repository Operations

	@git
  Scenario: Clone repo and add a new file with content
    Given user clones the Git repo from "https://github.com/AkashQA0303/CloudBees.git"
    When user creates a new file named "sample.txt" with content "This is a new file"
    Then user commits and push the changes with message "Added sample.txt file Final"
   
  @git 
  Scenario: Clone repo and append content to an existing file
    Given user clones the Git repo from "https://github.com/AkashQA0303/CloudBees.git"
    When user update existing file "sample.txt" with content "Update file"
    Then user commits and push the changes with message "Updated sample.txt file Final"