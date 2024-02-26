Files.list(Paths.get(".")).forEach(System.out::println);

Path currentDirectory = Paths.get(".");
Files.walk(currentDirectory,1).ForEach(System.out:println); // 1 == 1 level down

Predicate<> super Path> predicate = path -> String.valueof(path).contains(".java");
Files.walk(currentDirectory,1).filter(predicate).ForEach(System.out:println);

BiPredicate<Path,BasicFileAttributes> matcher = (path,attributes) -> String.valueOf(path).contains(".java");
Files.find(currentDirectory,4,matcher).ForEach(System.out::println);

BiPredicate<Path,BasicFileAttributes> directoryMatcher = (path,attributes) -> attributes.isDirectory();



Path pathFileToRead = Path.get("./.,,,");
List<String> lines = Files.readAllLines(pathFileToRead); 
Files.lines(pathFileToRead).forEach(System.out::println); // generator

Files.lines(pathFileToRead)
  .map(String::toLowerCase)
  .filter(str -> str.contains("a"))
  .forEach(System.out::println); // generator


Files.write(pathFileToWrite, list);


