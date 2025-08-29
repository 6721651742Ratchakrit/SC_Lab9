/**
 * TODO: ทำให้คลาสนี้เป็น Generic <K, V> ที่สามารถเก็บอ็อบเจกต์ได้ 2 ชนิด
 */
public class Pair<K,V> {
    private final K key ;
    private final V value ;

    // TODO: สร้าง Constructor ที่รับ key และ value
    public Pair(K key,V value){
        this.key = key;
        this.value = value;
    }
    
    // TODO: สร้าง Getters สำหรับ key และ value
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    
}