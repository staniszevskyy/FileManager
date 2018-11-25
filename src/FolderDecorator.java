import java.util.ArrayList;

public class FolderDecorator extends Directory {

    private String tempName;
    private Check checkTemp;

    public FolderDecorator(String name) {
        super();
        this.tempName = name;
        Node node = new Node();
//        node.setNodeName(name);

        checkTemp = new Check(node, name);
    }



    public FolderDecorator(Directory find, String name){
        setNodeName(find.getName());
//        checkTemp = new Check(new Node());
        setSubdirectories(find.findAllDirs());
        setFiles(find.findAllFiles());
        setParent(find.getParent());
        checkTemp = new Check(find, name);
        tempName = name;
//        setNodeName(find.getName());
//        setSubdirectories(find.getParent().findAllDirs());
//        setFiles(find.getParent().findAllFiles());
//        setParent(find.getParent());
//        checkTemp = new Check(find, name);
    }





    @Override
    public void addNode(Directory cur) {
        if (checkDirDuplication()){

            Directory newDir = new Directory();
            newDir.setNodeName(tempName);
            newDir.setParent(cur);

          cur.findAllDirs().add(newDir);

        }

    }

    public void setNode(String name){
        if (checkDirDuplication()){
            checkTemp.setName();
        }
    }

    public Boolean checkDuplication(ArrayList<Node> tempList){
        if (checkTemp.checkName()) { // jesli nazwa poprawna
            for (int i = 0 ; i<tempList.size() ; i++){ // iteruj po zawartosci folderu
                if (tempList.get(i).getName().equals(tempName)) return false; // porownaj nazwy
            }
            return true;
        }
        return false;
    }

    public Boolean checkDirDuplication(){
        ArrayList<Node> tempList = findAllDirs();
        return checkDuplication(tempList);
//        if (checkTemp.checkName()) { // jesli nazwa poprawna
//            for (int i = 0 ; i<tempList.size() ; i++){ // iteruj po zawartosci folderu
//                if (tempList.get(i).getName().equals(tempName)) return false; // porownaj nazwy
//            }
//            return true;
//        }
//        return false;
    }

    public Boolean checkFileDuplication(){
        ArrayList<Node> tempList = findAllFiles();
        return checkDuplication(tempList);
    }

    public String getTempName() {
        return tempName;
    }

    public void printContent(){
        ArrayList<Directory> dirList = findAllDirs();
        ArrayList<File> fileList = findAllFiles();
        System.out.print("\""+getName() +"\" dir contains: " );
        for (int i = 0 ; i<dirList.size() ; i++){
            System.out.print(dirList.get(i).getName() + "   ");
        }

        for (int i = 0 ; i<fileList.size() ; i++){
            System.out.print(fileList.get(i).getName() + "   ");
        }
        }
}


