import java.util.ArrayList;

public class Directory extends Node {
    private Node parent;
    private ArrayList<Node> subdirectories;

    public Node findNode(){
        //todo
        return new Node();
    }

    public ArrayList findAll(){
        return subdirectories;
    }

    public void addNode(){
        //todo
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
