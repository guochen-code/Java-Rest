(1) ArrayList vs LinkedList
ArrayList and Vector is Array (insertion and deletion are costly while accessing a value is fast)
LinkedList is LinkedList (vice versa)

(2) ArrayList vs Vector
- Vector is thread safer - synchronized methods

List<String> words = List.of("A","B","C");
wrods.add("D") ---> error, it is immutable ---> but List can store different data types: List mix = List.of("Hello",'A',1,1.0);
mix.get(1) instance of Character ---> true
mix.indexOf("Hello") ---> 0

List<Integer>numbers = List.of(101,102,103);
List<Integer> numbersAl = new ArrayList<>(numbers);

numbersAl.indexOf(101) ---> 0
numbersAl.remove(101) ---> error index out of bounds
numbersAl.remove(Integer.valueOf(101)) ---> true

add(element), add(index,element), addAll(list),set(index,element),remove(index),remove(element)

for (int i=0; i<words.size();i++)
for (String word:words)
Iterator wordsIterator = words.iterator();
while (wordsIterator.hasNext()){
  System.out.println(wordsIterator.next());
}
*************************************************************************************************************************************************************************************

Collections.sort(numbersAl);
// this is working because integer object has implemented comparable object
// for sort your own class, you need to implements **Comparable** interface and override the method, for example:
@Override
public int compareTo(Student that) {
  return Integer.compare(that.id, this.id); //Student class has an attribute id
}
Collection.sort(studentAl); // will sort according to id // ascending order by default

Collection.sort(studentAl, new DescendingStudentComparator()); // need to create a class

class DescendingStudentComparator implements Comparator<Student> {
  @Override
  public int compare(Student student1, Student student2){
    return Integer.compare(student1.getId(), student2.getId());
  }
}

**************************************************************************************************** think this.id is current.id and that.id is next.id
sort by descending:
@Override
public int compareTo(Student that) {
    return Integer.compare(that.id , this.id);
}
And this for ascending:
@Override
public int compareTo(Student that) {
    return Integer.compare(this.id , that.id);
****************************************************************************************************
//if i want descending order, the equation is that.id-this.id
//this.id=1 and that.id=5, but the equation changes to that.id-this.id = 5-1=4>0, so if >0, need to change the order, swap 1 and 5 position, the list becomes [5,1]

studentsAl.sort(new DescendingStudentComparator()); // instead of using Collection.sort(), we can use this internal sort() method 

