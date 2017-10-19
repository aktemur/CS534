package singleton.v1;

class FileSystem {
    private static FileSystem instance;

    String rootDirectory;
    
    private FileSystem() {
        System.out.println("FileSystem instantiated.");
        rootDirectory = "/";
    }

    public static FileSystem getInstance() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public void cp(String path1, String path2) {
        System.out.println("Copied " + path1 + " -> " + path2);
    }

    public void rm(String path) {
        System.out.println("Removed " + path);
    }

    public String getRoot() {
        return rootDirectory;
    }
}

