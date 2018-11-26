import java.util.ArrayList;

public class FolderDecorator extends Directory {

    private String tempName;
    private Check checkTemp;



    public FolderDecorator(Directory find, String name){
        setNodeName(find.getName());
        setSubdirectories(find.findAllDirs());
        setFiles(find.findAllFiles());
        setParent(find.getParent());
        checkTemp = new Check(find, name);
        tempName = name;

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
        if (checkTemp.checkName()) {
            for (Node node : tempList){
                if (node.getName().equals(tempName)) return false;
            }
            return true;
        }
        return false;
    }

    public Boolean checkDirDuplication(){
        ArrayList<Node> tempList = findAllDirs();
        return checkDuplication(tempList);

    }

    public Boolean checkFileDuplication(){
        ArrayList<Node> tempList = findAllFiles();
        return checkDuplication(tempList);
    }



    public void printContent(){
        ArrayList<Directory> dirList = findAllDirs();
        ArrayList<File> fileList = findAllFiles();
        System.out.print("\""+getName() +"\" dir contains: " );

        for (Directory d : dirList){
            System.out.print(d.getName() + "   ");
        }


        for (File file : fileList){
            System.out.print(file.getName() + "   ");
        }
        }
}


