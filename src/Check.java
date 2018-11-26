public class Check extends Node {
    private Node created;
    private String name;

    public Check(Node created, String name) {
        this.created = created;
        this.setNodeName(name);
        this.name = name;
    }

    public Boolean checkName(){

        return getName().matches( "\\w+\\.?\\w+");
    }

    public void setName(){
        if (checkName()){
            created.setNodeName(name);
        }
        else{
            System.out.println("Nazwa " + name+" niepoprawna. Uzywaj tylko malych i wielkich liter, podkreslnika.");
        }
    }


}
