package by.vorobey.plugin.tasks;

import java.util.ArrayList;

public class Release {

    private static final ArrayList<String> branches = initialisationBranch();

    public static ArrayList<String> initialisationBranch(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Master");
        list.add("Hotfix");
        list.add("Release");
        list.add("Feature");
        list.add("Develop");
        return list;
    }

    public static String getBranches(int index){
        return branches.get(index);
    }

}
