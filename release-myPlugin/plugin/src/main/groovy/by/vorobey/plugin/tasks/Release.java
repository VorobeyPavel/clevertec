package by.vorobey.plugin.tasks;

import java.util.ArrayList;

public class Release {

    private static final ArrayList<String> branches = initialisationBranch();

    public static ArrayList<String> initialisationBranch(){
        ArrayList<String> list = new ArrayList<>();
        list.add("master");
        list.add("hotfix");
        list.add("release");
        list.add("feature");
        list.add("develop");
        return list;
    }

    public static String getBranches(int index){
        return branches.get(index);
    }

}
