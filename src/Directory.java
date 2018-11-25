import java.lang.reflect.Array;
import java.util.ArrayList;

public class Directory extends Node {
    private Directory parent;
    private ArrayList<Directory> subdirectories;
    private ArrayList<File> files;

    public Directory() {
        this.parent = null;
        this.subdirectories = new ArrayList<Directory>();
        this.files = new ArrayList<File>();
    }

    public Directory findDir(String name){
        for (int i = 0 ; i < subdirectories.size(); i++){
            if (subdirectories.get(i).getName().equals(name)) return subdirectories.get(i);
        }
        return null;
        }
    public File findFile(String name){
        for (int i = 0 ; i < files.size(); i++){
            if (files.get(i).getName().equals(name)) return files.get(i);
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

    public void setSubdirectories(ArrayList<Directory> subdirectories) {
        this.subdirectories = subdirectories;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }
}
