package ua.lviv.lgs;

import java.util.Objects;

public class MyEntry<K, V> {
	K key;
	V value;
	MyEntry<K, V> next;

	public MyEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, next, value);
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyEntry [key=" + key + ", value=" + value + "]";
	}
}
