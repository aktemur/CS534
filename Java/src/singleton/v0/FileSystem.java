package singleton.v0;

class FileSystem {
    String rootDirectory;
    
    public FileSystem() {
        System.out.println("FileSystem instantiated.");
        rootDirectory = "/";
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

