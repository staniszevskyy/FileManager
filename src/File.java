public class File extends Node {
    private String value;
    private Node parent;
    private Check checkTemp;

    public File(String name) {

        checkTemp = new Check(this, name);
        checkTemp.setName();

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
