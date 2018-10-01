package xiaoxiaole;

public class Element {
    public boolean flag = false;
    
    public char element;

    public Element() {
                 this.element = random();
    }
    
    public char random() {
      double a = Math.random() * 4;
      if(a >= 3 && a < 4) {
                               return (char) 9679;
                 }
                 else if(a >= 2 && a < 3) {
                               return (char) 9650;
                 }
                 else if (a >=1 && a<2) {
                   return (char) 9632;
                 }
                 return (char) 9633;
   }
    public Element(char element) {
      this.element = element;
    }
    public char commander(int a) {
      if (a >= 5) {
            return '@';
}
else if(a >= 4 && a < 5) {
             return '#';
}
else if(a >= 3 && a < 4) {
             return '$';
}
else if(a >= 2 && a < 3) {
             return '%';
}
else if (a >=1 && a<2) {
      return '&';
}
return '!';
    }
}
