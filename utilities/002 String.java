"".isBlank();
" L R ".strip().replace(" ","@");
" L R ".stripLeading();
" L R ".stripTrailing();
"line1\nLine2\nLine3\n".lines().forEach(System.out::println);
"UPPER".transform(s->s.substring(2)); --> "PER";
"My name is %s. My age is %d.".formatted("Chen", 25);

String str = null;
System.out.println(str.isBlank()); --> NullPointerException;

