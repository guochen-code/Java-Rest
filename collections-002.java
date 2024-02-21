(1) set
(2) hash set
(3) linked hash set
(4) tree set
**************************************************************************************************************************************************************************************

Set<Sting> set = Set.of("AA","BA","CA"); // immutable

Set<String> hashset = new HashSet<>(set); // mutable

Set<Integer> numbers = new HashSet<>();
numbers.add(123);
numbers.add(12);
numbers.add(1);
// order is not guaranteed

Set<Integer> numbers = new LinkedHashSet<>(); // order is remained as how you insert // insertion order yes while sorted order no

Set<Integer> numbers = new TreeSet<>(); // order is not as how you insert, but it is in sorted ascedning order // insertion order no while sorted order yes

// application
List<Character> characters = List.of('A','Z','A','B','Z','F');
// if want unique character in sorted order
Set<Character> treeSet = new TreeSet<>(characters);
// if want keep insertion order
Set<Character> linkedHashSet = new LinkedHashSet<>(characters);
// don't care about sorted order and insertion order
Set<Character> hashSet = new HashSet<>(characters);
********************************************************************************************************************************************************************** treeSet in depth
class TreeSet implements Set, NavigableSet {} // NavigableSet

TreeSet<Integer> numbers = new TreeSet<>(Set.of(65,54,34,12,99));
numbers.floor(40) --> 34
numbers.floor(34) --> 34
numbers.lower(34) --> 12
numbers.ceiling(34) -->34
numbers.higher(34) --> 54
numbers.subSet(20,80) --> [34,54,65]
numbers.subSet(34,54) --> [34]
numbers.subSet(34,,true,65,true) --> [34,54,65]
numbers.subSet(34,,false,65,false) --> [54]
numbers.headSet(50) --> [12,34]
numbers.tailSet(50) --> [54,65,99]

#######################################################################################################################################################################
********************************************************************************************************************************************************************** Queue
// arranged in order of processing - A to-do list for example.
// queue interface extends Collection. so, it supports all Collection Methods.
class PriorityQueue implements Queue{} // sorted- natural order

Queue<String> queue = new PriorityQueue<>();

queue.poll() --> null
queue.offer("AA");
queue.addAll("BB","CC"); // in sorted order because of pripority by default
queue.poll() --> "AA" // "AA" removed from queue

Queue<String> queue = new PriorityQueue<>();
queue.addAll(List.of("Zebra","Monkey","Cat"));
queue.poll() --> "Cat" // following natural default order
queue.poll() --> "Monkey"
queue.poll() --> "Zebra"
queue.poll() --> null

// customize poll order
class StringLengthComparator implements Comparator<String>{
@Override
public int compare(String value1, String value2){
  return Integer.compare(value1.Length(),value2.length());
}
}
Queue<String> queue = new PriorityQueue<>(new StringLengthComparator());
queue.addAll(List.of("Zebra","Monkey","Cat"));
queue.poll() --> "Cat" // following string length order - "ascedning"
queue.poll() --> "Zebra"
queue.poll() --> "Monkey"
queue.poll() --> null

#######################################################################################################################################################################
********************************************************************************************************************************************************************** Map - key value pairs
// part of Collections framework but not implementing Collection interface
// key value pairs

class HashMap implements Map{
  //unsorted, unordered
  // key's hashcode() is used
}

class Hashtable implements Map{
  // synchronized - thread safe - version of hashmap
  // unsorted, unordered
  // key's hashcode() is used
  // hashmap allows a key with null value. hashtable does not
}

class LinkedHashMap implements Map{
  // insertion order is maintained
  // unsorted
  // slower insertion and deletion
  // faster iteration
}

class TreeMap implements Map, NavigableMap{
// sorted order is maintained
// implements NavigableMap
}

Map<String,Integer> map = Map.of("A",3,"B",5,"Z",10);
Map.put("R",1) --> error out, immutable
map --> {Z=10, A=3, B=5}
map.get("Z") --> 10
map.get("C") --> null
map.size()
map.isEmpty()
map.containsKey("A") --> true
map.containsValue(3) --> true
map.keySet() --> [Z,A,B] // complete set of keys
map.values() --> [10,3,5] // complete set of keys

Map<String,Integer> hashmap = new HashMap<>(map);
hashmap.put("F",5) // return null but it is added // can also use this to change value

// application

