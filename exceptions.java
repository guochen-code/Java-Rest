// try with resources, like context manager, it is auto closable, don't need to explicitly execute scanner.close() anymore.
// it can still be followed by catch and finally if you want.
// if error out, it will be automatically closed.
try(Scanner scanner = new Scanner(System.in){
  ////////
}

//
try {
  // code
} catch (IOException | SQLException ex) {
  ex.printStackTrace();
}

Unchecked exceptions in Java include RuntimeException and its sub-classes. 
Unlike checked exceptions, unchecked exceptions are not mandatory to be explicitly handled or declared by the programmer.

The interface that a resource must implement to be compatible with the try-with-resources statement is AutoCloseable. 
The AutoCloseable interface provides a single method, close(), 
which is invoked automatically by the try-with-resources statement to release or close the resource when it is no longer needed.

