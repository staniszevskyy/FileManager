import java.util.ArrayList;

public class Directory extends Node {
    private Directory parent;
    protected ArrayList<Directory> subdirectories;
    protected ArrayList<File> files;

    public Directory() {
        this.parent = null;
        this.subdirectories = new ArrayList<Directory>();
        this.files = new ArrayList<File>();
    }

    public Directory findDir(String name){


        for (Directory dir : subdirectories){
            if (dir.getName().equals(name)) return dir;
        }

        return null;
        }
    public File findFile(String name){
        for (File file : files){
            if (file.getName().equals(name)) return file;
        }
        return null;
    }

    public ArrayList findAllDirs(){
        return subdirectories;
    }
    public ArrayList findAllFiles() { return files;}
    public void addNode(Directory cur){

    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }


}
