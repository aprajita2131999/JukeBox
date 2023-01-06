package customexceptions;

public class songsNotFoundException extends Exception{
    public songsNotFoundException(String str){
        System.out.println(str);
    }
}
