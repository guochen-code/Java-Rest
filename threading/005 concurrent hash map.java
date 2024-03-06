// this is not thread safe
Map<Character, Integer> occurances = new HashTable<>();
char[] characters = str.toCharArray();
for(char character:characters){
  Integer integer = occurances.get(character);
  if(integer==null){
    occurances.put(character,1);
  } else{
    occurances.put(character,integer+1);
  }
}

//
Map<Character, LongAdder> occurances = new HashTable<>();
String str = "ABCD ABCD";
for(char character:str.toCharArray()){
  LongAdder longAdder = occurances.get(character);
  if(longAdder == null){
    longAdder = new LongAdder();
  }
  longAdder.increment();
  occurance.put(character,longAdder);
}


// 
ConcurrentMap<Character, LongAdder> occurances = new ConcurrentMap<>();

String str = "ABCD ABCD";
for(char character:str.toCharArray()){
  occurances.computeIfAbsent(character, ch-> new LongAdder()).increment();
}
