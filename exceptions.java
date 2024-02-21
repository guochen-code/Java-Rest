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

