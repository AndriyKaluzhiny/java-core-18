package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Map<K, V> {
	MyEntry<K, V>[] myEntry;
	int capacity;

	@SuppressWarnings("unchecked")
	public Map(int capacity) {
		this.capacity = capacity;
		myEntry = new MyEntry[capacity];
	}

	public void put(K newKey, V value) {
		for (int i = 0; i < myEntry.length; i++) {
			if (myEntry[i] == null) {
				MyEntry<K, V> entry = new MyEntry<K, V>(null, null);

				entry.setKey(newKey);
				entry.setValue(value);

				myEntry[i] = entry;
				break;
			}
		}
	}

	public void removeByKey(K key) {
		for (int i = 0; i < myEntry.length; i++) {
			if (myEntry[i] != null && myEntry[i].getKey().equals(key)) {
				myEntry[i] = null;
			}
		}

	}

	public void removeByValue(V value) {
		for (int i = 0; i < myEntry.length; i++) {
			if (myEntry[i] != null && myEntry[i].getValue().equals(value)) {
				myEntry[i] = null;
			}
		}

	}

	public void showSetOfKeys() {
		Set<K> keysSet = new HashSet<>();
		for (MyEntry<K, V> e : myEntry) {
			if (e != null) {
				MyEntry<K, V> next = new MyEntry<K, V>(null, null);

				next.setKey(e.key);
				next.setValue(e.value);
				keysSet.add(next.getKey());

			}
		}
		System.out.println(keysSet);
	}

	public void showListOfValues() {
		List<V> list = new ArrayList<>();

		for (MyEntry<K, V> e : myEntry) {
			if (e != null) {
				MyEntry<K, V> next = new MyEntry<K, V>(null, null);

				next.setKey(e.key);
				next.setValue(e.value);
				list.add(next.getValue());

			}
		}
		System.out.println(list);
	}

	public void show() {
		for (MyEntry<K, V> entry : myEntry) {
			System.out.println("element ---> " + entry);
		}
	}

	@Override
	public String toString() {
		return "Map [myEntry=" + Arrays.toString(myEntry) + ", capacity=" + capacity + "]";
	}

	
}