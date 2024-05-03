public class Fuse {
    private int time;

    public Fuse(int time){
        this.time=time;
    }

    public boolean burn(){
      //  Boolean check=false;
        time--;
        if(time > 0) {

            return true;
        }
        else if(time == 0){
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Fuse{" +
                "Trials=" + time +
                '}';
    }
}

