public class Pair<A, B>{
    private A first;
    private B second;

    public Pair(A first,B second){
        this.first=first;
        this.second=second;
    }
    public A getKey(){
        return first;
    }
    public B getValue(){
        return second;
    }
}
