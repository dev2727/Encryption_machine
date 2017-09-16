package sample;


public class TextCrypte {
    static String textCrypte = "";

    public static int indiqPositionX(char lettre){
        for (int i=0;i<TextOriginal.tabChar.length;i++){
            if (lettre == TextOriginal.tabChar[i]){
                return i;
            }
        }return -50000;

    }

    public static int indiqPositionY(int a,int b,int X){
        return (a*X+b)%26;
    }

    public static String concatinTextResult(int a,int b){
        String OrgText = Controller.textOrgfield;

        for(int i=0;i<OrgText.length();i++) {
            if (OrgText.charAt(i) == ' ') {
                i++;
                textCrypte = textCrypte + ' ';
            } else {
                int positionX = indiqPositionX(OrgText.charAt(i));
                int positionY = indiqPositionY(a, b, positionX);
                textCrypte = textCrypte + TextOriginal.tabChar[positionY];
            }
        }
        return textCrypte;
    }
}
