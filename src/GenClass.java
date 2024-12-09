public class GenClass <T>{

    T item;
    public GenClass(T item){
        this.item=item;
    }

    public T getItem(){
        return item;
    }

    @Override
    public String toString() {
        return  item.getClass().toString();

    }
}
