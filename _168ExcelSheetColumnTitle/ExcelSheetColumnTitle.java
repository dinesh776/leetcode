package Github._168ExcelSheetColumnTitle;

//168. Excel Sheet Column Title
//https://leetcode.com/problems/excel-sheet-column-title/description/

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int c=702;
        System.out.println(convertToTitle(c));
    }
    static String convertToTitle(int columnNumber) {
        String[] map={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        StringBuilder s=new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int mod = columnNumber % 26;
            s.append(map[mod]);
            columnNumber /= 26;
        }

        return s.reverse().toString();
    }
}
