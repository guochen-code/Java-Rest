String monthName = switch (monthNumber){
  case 1 -> {System.out.println("Jan"); // you can add complex logic here;
    yield "Jan";
            }
  case 2 -> "Feb";
  case 3 -> "Mar";
  case 4 -> "Apr";
  default -> "invalid month";
}

// unlike normal switch, switch expression does not have fallthrough
