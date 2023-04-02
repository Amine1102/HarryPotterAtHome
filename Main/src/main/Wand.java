package main;

public class Wand {

    private String core;
    private int size;

    public Wand(String core, int size){
        this.core = core;
        this.size = size;
    }

    //GETTER SETTER
    public String getCore(){
        return core;
    }

    public void setCore(String core, int size) {
        this.size = size;
        this.core = core;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
