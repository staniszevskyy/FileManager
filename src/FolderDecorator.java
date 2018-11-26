import java.util.ArrayList;

public class FolderDecorator extends Directory {

    private String tempName;
    private Check checkTemp;



    public FolderDecorator(Directory find, String name){
        setNodeName(find.getName());

        subdirectories=find.subdirectories;
        files=find.files;
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

    public Boolean checkDirDuplication(){
        if (checkTemp.checkName()) {
            for (Directory dir : subdirectories){
                if (dir.getName().equals(tempName)) return false;
            }
            return true;
        }
        return false;
    }

    public Boolean checkFileDuplication(){
        if (checkTemp.checkName()) {
            for (File file : files){
                if (file.getName().equals(tempName)) return false;
            }
            return true;
        }
        return false;
    }



    public void printContent(){

        System.out.print("\""+getName() +"\" dir contains: " );

        for (Directory d : subdirectories){
            System.out.print(d.getName() + "   ");
        }


        for (File file : files){
            System.out.print(file.getName() + "   ");
        }
        }
}


