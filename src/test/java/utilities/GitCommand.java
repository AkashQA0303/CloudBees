package utilities;

import java.io.File;
import java.io.IOException;

public class GitCommand {
	
	public static void runCommand(String command, File dir) throws IOException, InterruptedException {
	    boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
	    
	    ProcessBuilder builder = new ProcessBuilder();
	    if (isWindows) {
	        builder.command("cmd.exe", "/c", command);
	    } else {
	        builder.command("bash", "-c", command);
	    }

	    builder.directory(dir);
	    builder.redirectErrorStream(true);
	    Process process = builder.start();
	    int exitCode = process.waitFor();
	    if (exitCode != 0) {
	        throw new RuntimeException("Command failed: " + command);
	    }
	}
	 
	public static void cloneRepo(String repoUrl, String targetPath) {
        try {
            File targetDir = new File(targetPath);

            // Optional: delete if it exists to avoid conflicts
            if (targetDir.exists()) {
                System.out.println("Cleaning up existing directory: " + targetPath);
                deleteDirectory(targetDir);
            }

            // Make sure parent directory exists
            targetDir.getParentFile().mkdirs();

            String command = "git clone " + repoUrl + " " + targetPath;
            runCommand(command, new File(".")); // Run from current working dir

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	 public static void createFileWithContent(String filePath, String content) throws IOException {
	        java.nio.file.Files.write(new File(filePath).toPath(), content.getBytes());
	    }

	 public static void appendToFile(String filePath, String content) throws IOException {
	        java.nio.file.Files.write(new File(filePath).toPath(), content.getBytes(), java.nio.file.StandardOpenOption.APPEND);
	    }

	 public static void commitAndPush(String message, File repoDir) throws IOException, InterruptedException {
	        runCommand("git add .", repoDir);
	        runCommand("git commit -m \"" + message + "\"", repoDir);
	        runCommand("git push", repoDir);
	    }
	 
	 private static void deleteDirectory(File dir) {
	        File[] allContents = dir.listFiles();
	        if (allContents != null) {
	            for (File file : allContents) {
	                deleteDirectory(file);
	            }
	        }
	        dir.delete();
	    }
	 
}
