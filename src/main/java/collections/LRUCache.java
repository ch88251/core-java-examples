package collections;

import java.util.Map;
import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

  private final int maxCapacity;

  public LRUCache(int maxCapacity) {
    super(16, 0.75f, true);
    this.maxCapacity = maxCapacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > maxCapacity;
  }

}
