Feature: Git Repository Operations

	@git
  Scenario: Clone repo and add a new file with content
    Given user clones the git repository "https://github.com/example/repo.git" to "localRepoPath"
    When user adds a new file "newfile.txt" with content "This is a new file" to the repo
    Then the file "newfile.txt" should exist in the local repo with the given content

  Scenario: Clone repo and append content to an existing file
    Given user clones the git repository "https://github.com/example/repo.git" to "localRepoPath"
    When user appends content "Appended content" to the file "existingfile.txt" in the repo
    Then the file "existingfile.txt" should contain the appended content