package Modell;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class LoadMembers {


    private static final String MEMBERS_URL = "2.ser";
    public static List<Member> ALLMEMBERS = new ArrayList<>();


    public static void initMembers() throws IOException, ClassNotFoundException {


        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(MEMBERS_URL));
            Member member = (Member) in.readObject();

            while (member != null){
                ALLMEMBERS.add(member);
                member = (Member) in.readObject();
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }

}
