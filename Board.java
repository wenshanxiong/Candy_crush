package xiaoxiaole;

public class Board {
      public Element[][] currentBoard = new Element[8][8];
      public int score = 0;
      public Board() {
            this.constructor();
      }
      public void constructor() {
            for (int i = 0; i < 8; i++) {
                 for (int j = 0; j < 8; j++) {
                       this.currentBoard[i][j] = new Element(' ');
                 }
            }
            for (int i = 0; i < 8; i++) {
                 for (int j = 0; j < 8; j++) {
                       this.currentBoard[i][j] = new Element();
                       while(this.isBigEnough(i, j) == true) {
                             this.currentBoard[i][j] = new Element();
                       }
                 }
            }
      }
      public void screenClear() {
            for (int i = 0; i < 8; i++) {
                 for (int j = 0; j < 8; j++) {
                       this.clearAll(i, j);
                 }
            }
      }
      public void clearAll(int i, int j) {
            if (this.isBigEnough(i, j)) {
                 //clear
                 int count = 0;
                 count += this.findAllSameSymbols(i, j, this.currentBoard[i][j].element);
                 for (int i1 = 0; i1 < 8; i1++) {
                       for (int j1 = 0; j1 < 8; j1++) {
                       if (this.currentBoard[i1][j1].flag == true) {
                             this.currentBoard[i1][j1].element = ' ';
                       }
                       }
                 }
                 this.score += java.lang.Math.pow(2, count);
                 //fall
            }
      }
      public boolean isBigEnough (int i, int j) {
            if (this.currentBoard[i][j].element != ' ') {
                 int count1 = 0, count2 = 0;
                 for (int i1 = i; i1 < i + 3; i1++) {
                       if (i1 < 8 && i1 >= 0) {
                             if (this.currentBoard[i1][j].element == this.currentBoard[i][j].element) {
                                  count1++;
                             } else {
                                  break;
                             }
                       }
                 }
                 for (int i1 = i - 1; i1 > i - 3; i1--) {
                       if (i1 < 8 && i1 >= 0) {
                             if (this.currentBoard[i1][j].element == this.currentBoard[i][j].element) {
                                  count1++;
                             } else {
                                  break;
                             }
                       }
                 }
                 for (int j1 = j; j1 < j + 3; j1++) {
                       if (j1 < 8 && j1 >= 0) {
                             if (this.currentBoard[i][j1].element == this.currentBoard[i][j].element) {
                                  count2++;
                             } else {
                                  break;
                             }
                       }
                 }
                 for (int j1 = j - 1; j1 > j - 3; j1--) {
                       if (j1 < 8 && j1 >= 0) {
                             if (this.currentBoard[i][j1].element == this.currentBoard[i][j].element) {
                                  count2++;
                             } else {
                                  break;
                             }
                       }
                 }
                 return count1 > 2 || count2 > 2;
            }
            return false;
      }
      public int findAllSameSymbols(int i, int j, char symbol) {
            if (this.currentBoard[i][j].element == symbol && this.currentBoard[i][j].flag == false) {
                 this.currentBoard[i][j].flag = true;
                 if (i == 0) {
                       if (j == 0) {
                             return 1 + this.findAllSameSymbols(i, j + 1, symbol) + this.findAllSameSymbols(i + 1, j, symbol);
                       }
                       if (j == 7) {
                             return 1 + this.findAllSameSymbols(i, j - 1, symbol) + this.findAllSameSymbols(i + 1, j, symbol);
                       }
                       return 1 + this.findAllSameSymbols(i, j + 1, symbol) + this.findAllSameSymbols(i + 1, j, symbol) + this.findAllSameSymbols(i, j - 1, symbol);
                  }
                 if (j == 0) {
                       if (i == 7) {
                             return 1 + this.findAllSameSymbols(i, j + 1, symbol) + this.findAllSameSymbols(i - 1, j, symbol);
                       }
                       return 1 + this.findAllSameSymbols(i, j + 1, symbol) + this.findAllSameSymbols(i + 1, j, symbol) + this.findAllSameSymbols(i - 1, j, symbol);
                 }
                 if (i == 7) {
                       if (j == 7) {
                             return 1 + this.findAllSameSymbols(i, j - 1, symbol) + this.findAllSameSymbols(i - 1, j, symbol);
                       }
                       return 1 + this.findAllSameSymbols(i - 1, j, symbol) + this.findAllSameSymbols(i, j - 1, symbol) + this.findAllSameSymbols(i, j + 1, symbol);
                 }
                 if (j == 7) {
                       return 1 + this.findAllSameSymbols(i - 1, j, symbol) + this.findAllSameSymbols(i, j - 1, symbol) + this.findAllSameSymbols(i + 1, j, symbol);
                 }
                 return 1 + this.findAllSameSymbols(i, j + 1, symbol) + this.findAllSameSymbols(i + 1, j, symbol) + this.findAllSameSymbols(i, j - 1, symbol) + this.findAllSameSymbols(i - 1, j, symbol);
            }
            return 0;
      }
      public void fall() {
            for (int j = 0; j < 8; j++) {
                 for (int i = 7; i > 0; i--) {
                       if (this.currentBoard[i][j].element == ' ') {
                             for (int i1 = i; i1 > 0; i1--) {
                                  swap(i1, j, i1 - 1, j);
                             }
                       }
                       if (this.currentBoard[i][j].element == ' ') {
                             for (int i1 = i; i1 > 0; i1--) {
                                  swap(i1, j, i1 - 1, j);
                             }
                       }
                       if (this.currentBoard[i][j].element == ' ') {
                             for (int i1 = i; i1 > 0; i1--) {
                                  swap(i1, j, i1 - 1, j);
                             }
                       }
                       if (this.currentBoard[i][j].element == ' ') {
                             for (int i1 = i; i1 > 0; i1--) {
                                  swap(i1, j, i1 - 1, j);
                             }
                       }
                       if (this.currentBoard[i][j].element == ' ') {
                             for (int i1 = i; i1 > 0; i1--) {
                                  swap(i1, j, i1 - 1, j);
                             }
                       }
                       if (this.currentBoard[i][j].element == ' ') {
                             for (int i1 = i; i1 > 0; i1--) {
                                  swap(i1, j, i1 - 1, j);
                             }
                       }
                       if (this.currentBoard[i][j].element == ' ') {
                             for (int i1 = i; i1 > 0; i1--) {
                                  swap(i1, j, i1 - 1, j);
                             }
                       }
                       if (this.currentBoard[i][j].element == ' ') {
                             for (int i1 = i; i1 > 0; i1--) {
                                  swap(i1, j, i1 - 1, j);
                             }
                       }
                       
                 }
            }
      }
      public void swap(int i1, int j1, int i2, int j2) {
            char temp = this.currentBoard[i1][j1].element;
            this.currentBoard[i1][j1].element = this.currentBoard[i2][j2].element;
            this.currentBoard[i2][j2].element = temp;
            boolean tempBoolean = this.currentBoard[i1][j1].flag;
            this.currentBoard[i1][j1].flag = this.currentBoard[i2][j2].flag;
            this.currentBoard[i2][j2].flag = tempBoolean;
      }
      public void swap1(int i1, int j1, int i2, int j2) {
            if (i1 < 0 || i1 >= 8
                       ||i2 < 0 || i2 >= 8
                       ||j1 < 0 || j1 >= 8
                       ||j1 < 0 || j1 >= 8) {
                 System.out.println("Your coordinate should be within the range!");
                 return;
            } else if (!((i1 == i2 && Math.abs(j1 - j2) == 1) || (j1 == j2 && Math.abs(i1 - i2) == 1))) {
                 System.out.println("You can only swap two adjacent symbols!");
                 return;
            } else if (this.currentBoard[i1][j1].element == ' '
                       || this.currentBoard[i2][j2].element == ' ') {
                             System.out.println("Cannot swap blank!");
                             return;
                       } 
             else {
            char temp = this.currentBoard[i1][j1].element;
            this.currentBoard[i1][j1].element = this.currentBoard[i2][j2].element;
            this.currentBoard[i2][j2].element = temp;
            boolean tempBoolean = this.currentBoard[i1][j1].flag;
            this.currentBoard[i1][j1].flag = this.currentBoard[i2][j2].flag;
            this.currentBoard[i2][j2].flag = tempBoolean;
            }
      }
      public boolean screenIsClearable() {
            for (int i = 0; i < 8; i++) {
                 for (int j = 0; j < 8; j++) {
                       if (this.currentBoard[i][j].element != ' ' && this.isBigEnough(i, j)) {
                             return true;
                       }
                 }
            }
            return false;
      }
}

