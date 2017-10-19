package singleton;

public class FileSystemClient {
    public static void main(String[] args) {
        FileSystem fs = FileSystem.getInstance();

        fs.pwd();
        fs.cd("/home/aktemur");
        fs.pwd();

        FileSystem fs2 = FileSystem.getInstance();
        fs2.pwd();
        fs2.cd("/usr/lib");

        fs.pwd();
    }
}
