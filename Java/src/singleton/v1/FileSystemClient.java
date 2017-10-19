package singleton.v1;

public class FileSystemClient {
    public static void main(String[] args) {
        FileSystem fs = FileSystem.getInstance();

        fs.cp("/home/aktemur", "/home/user");
        fs.rm("/home/aktemur");

        FileSystem fs2 = FileSystem.getInstance();
        fs2.cp("/home/user", "/home/aktemur");
        fs2.rm("/home/user");
    }
}
