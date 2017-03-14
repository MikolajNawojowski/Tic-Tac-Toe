/**
  * Created by mikolaj on 14.03.17.
  */
import java.util.Scanner
var mark = "O"
var movementsNumber = 0;

class Board {
  var board = Array("", "", "", "", "", "", "", "", "")
  var whosTurn = false

  def changePlayer(): Unit = {
    whosTurn = !whosTurn
  }

  def isStillPlay(): Boolean = {
    if ((board (0) == board(1) && board (1) == board(2) && board(0) != "") ||
    (board (3) == board(4) && board (4) == board(5) && board(3) != "") ||
    (board (6) == board(7) && board (7) == board(8) && board(6) != "") ||
    (board (0) == board(3) && board (3) == board(6) && board(0) != "") ||
    (board (2) == board(5) && board (5) == board(8) && board(2) != "") ||
    (board (0) == board(4) && board (4) == board(8) && board(0) != "") ||
    (board (2) == board(4) && board (4) == board(6) && board(2) != "") ||
    (board (1) == board(4) && board (4) == board(7) && board(1) != ""))
    {
        return false
    } else {return true}
  }

  def show() {
    var n = 0
    for (i <- 0 until board.size) {
      n = n + 1
      if (i % 3 == 0) {
        print("\n")
      }
      print(" " + board(i))
    }
  }

  def move(place: Int) {
    while (board(place) == "") {
      board(place) = mark
      movementsNumber += 1
      if (whosTurn) {
        mark = "O"
      } else {
        mark = "X"
      }
    }
  }

  def checkIfBoardFull(): Boolean = {
    if(movementsNumber >= 9) {
      return true
    } else {
      return false
    }
  }
  def win() = {
    print("\n")
    print("Graczu " + mark + "! Przegrałeś!!! :(")
  }
}


val nowy = new Board()
while(nowy.isStillPlay()) {
  if(nowy.checkIfBoardFull) {
    print("\n")
    print("Remis!")
    sys.exit()
  }
    print("\n")
  println("Podaj swoj ruch "+mark+": ")
  val input = new Scanner(System.in)
  val place = input.nextInt()
  if(place >= 0 && place <= 8) {
    nowy.move(place)
    nowy.changePlayer()
    nowy.show()
  } else {
    println("Podales zla liczbe, sprobuj jeszcze raz")
  }
}
nowy.win()