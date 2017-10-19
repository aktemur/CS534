package singleton;

class FileSystem {
    private static FileSystem instance;
    String currentDirectory;
    
    private FileSystem() {
        System.out.println("FileSystem instantiated.");
        currentDirectory = "/";
    }

    public static FileSystem getInstance() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public void cd(String path) {
        currentDirectory = path;
    }

    public void pwd() {
        System.out.println(currentDirectory);
    }
}

