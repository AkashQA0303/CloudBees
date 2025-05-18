package stepDefinitions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.GitCommand;

public class gitSteps {
	
	private final String localRepo = System.getProperty("user.dir") + "\\eclipse-workspace\\tempRepo";


	@Given("user clones the Git repo from {string}")
	public void user_clones_the_git_repo_from(String repo) throws Exception {
		GitCommand.cloneRepo(repo, localRepo);
	}
	
	@When("user creates a new file named {string} with content {string}")
	public void user_creates_a_new_file_named_with_content(String fileName, String content) throws Exception {
		 GitCommand.createFileWithContent(localRepo + "/" + fileName, content);
	}
	
	
	@Then("user commits and push the changes with message {string}")
	public void user_commits_and_push_the_changes_with_message(String message) throws Exception {
		GitCommand.commitAndPush(message, new File(localRepo));
	}
	
	@When("user update existing file {string} with content {string}")
	public void user_update_existing_file_with_content(String fileName, String content) {
		try {
	        // Update the path to your cloned repo (match with cloneRepo's target path)
	        File file = new File(localRepo + "/"+ fileName);

	        if (!file.exists()) {
	            throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
	        }

	        try (FileWriter fw = new FileWriter(file, true)) {
	            fw.write(System.lineSeparator() + content);
	        }

	        System.out.println("Appended content to file: " + file.getAbsolutePath());

	    } catch (Exception e) {
	        throw new RuntimeException("Failed to update file: " + e.getMessage(), e);
	    }
	}
	


}
