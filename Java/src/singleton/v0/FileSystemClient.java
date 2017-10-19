package singleton.v0;

public class FileSystemClient {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        fs.cp("/home/aktemur", "/home/user");
        fs.rm("/home/aktemur");

        FileSystem fs2 = new FileSystem();
        fs2.cp("/home/user", "/home/aktemur");
        fs2.rm("/home/user");
    }
}
