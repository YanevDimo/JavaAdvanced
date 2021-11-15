package P07Google;

public class Children {
    // name,birthday
    private  String name;
    private  String birthday;

    public Children(String name,String birthday){
        this.name = name;
        this.birthday = birthday;
    }
    @Override
    public  String toString(){
        return name + " "+ birthday;
    }

}
