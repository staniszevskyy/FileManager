import java.util.Scanner;



public class Main {

    public static void printCommands(){
        System.out.println("help --- print this again");
        System.out.println("create_folder <foldername> --- create folder in current directory");
        System.out.println("rename_folder --- rename current directory name");
        System.out.println("create_file <filename> --- create folder in current directory");
        System.out.println("rename_file <filename> <newfilename> --- rename file");
        System.out.println("up --- go up in folder structure");
        System.out.println("sub <name> --- go to subdirectory");
        System.out.println("print --- print out current directory content");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printCommands();
        String cmd = in.next();
        Directory root = new Directory();
        root.setNodeName("root");
        Directory current = root;

        while (!cmd.equals("exit")){

            switch (cmd){
                case "help": {
                    printCommands();
                    break;
                }
                case "create_folder":
                    {
                    String name = in.next();

                    FolderDecorator newFolder = new FolderDecorator(current, name);
                    newFolder.addNode(current);
                    break;
                    }
                case "rename_folder":
                    {
                    String name = in.next();

                    FolderDecorator temp = new FolderDecorator(current, name);
                    temp.setNode(name);
                    break;
                    }

                case "create_file":
                {
                    String name = in.next();

                    FolderDecorator temp = new FolderDecorator(current, name);
                    if(temp.checkFileDuplication()) {
                            File file = new File(name);
                            file.setParent(current);
                            current.findAllFiles().add(file);
                    }
                    break;
                }

                case "rename_file":
                {
                    String name1 = in.next();
                    String name2 = in.next();
                    FolderDecorator temp = new FolderDecorator(current, name2);
                    if (temp.checkFileDuplication()){
                        temp.findFile(name1).setNodeName(name2);
                    }

                }

                case "up": {
                    if (current.getParent() != null)
                        current = current.getParent();
                    break;
                }
                case "sub": {
                    String sub = in.next();
                    if (current.findDir(sub).getName() != null) {
                        current = current.findDir(sub);
                    }
                    break;
                }
                case "print": {
                    FolderDecorator temp = new FolderDecorator(current, current.getName());
                    temp.printContent();
                    break;
                }



            }
            cmd = in.next();
        }

    }
}
