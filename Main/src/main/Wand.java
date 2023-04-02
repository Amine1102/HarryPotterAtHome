package main;

public class Wand {

    private Core core;
    private int size;

    public Wand(Core core, int size){
        this.core = core;
        this.size = size;
    }

    //GETTER SETTER
    public Core getCore(){
        return core;
    }

    public void setCore(Core core, int size) {
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
