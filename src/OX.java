public class OX {
    String table[][] =  {
            {" ","0","1","2"},
            {"0","-","-","-"},
            {"1","-","-","-"},
            {"2","-","-","-"}
    };
    private String currentplayer;
    private int turnCount;
    private int scoreX;
    private int scoreO;
    private int scoreDraw;

    public OX() {
        currentplayer = "X";
        turnCount = 0;
        scoreX = 0;
        scoreO = 0;
        scoreDraw = 0;
    }
    public String getTableString() {
        String result = "";
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                result = result + table[i][j];
            }
            result = result+"\n";
        }
        return result;
    }
    public String getCurrentPlayer() {
        return currentplayer;
    }
    public void switchPlayer() {
        if( currentplayer.equals("X")) {
            currentplayer = "O";
        }
        else {
            currentplayer = "X";
        }
    }

    public boolean put(int col, int row) {
        try {
            if(!table[row+1][col+1].equals("-")) {
                return false;
            }
            table[row+1][col+1] = currentplayer;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
        turnCount++;
        if(checkWin(col,row)) {
            if(currentplayer.equals("X")) {
                scoreX++;
            }
            else if(currentplayer.equals("O")) {
                scoreO++;
            }
        }
        if(isDraw()) {
            scoreDraw++;
        }
        return true;
    }

    public String get(int col, int row) {
        if(col > 2 || col < 0 || row > 2 || row < 0)
            return null;
        return table[row+1][col+1];
    }

    public boolean checkWin(int col, int row) {
       /*Check Col Win*/
        boolean colWin = true;
        for(int i=0;i<3;i++) {
            if(!table[i+1][col+1].equals(currentplayer)) {
                colWin = false;
            }
        }
        if(colWin) {
            return true;
        }

        /*Check Row Win*/
        boolean rowWin = true;
        for(int i=0;i<3;i++) {
            if(!table[row+1][i+1].equals(currentplayer)) {
                rowWin = false;
            }
        }
        if(rowWin) {
            return true;
        }

        boolean esWin = true;
        for(int i=0;i<3;i++) {
            if(!table[i+1][i+1].equals(currentplayer)) {
                esWin = false;
            }
        }
        if(esWin) {
            return true;
        }

        boolean ssWin = true;
        for(int i=0;i<3;i++) {
            if(!table[i+1][3-i].equals(currentplayer)) {
                ssWin = false;
            }
        }
        if(ssWin) {
            return true;
        }
        return false;
    }

    public void reset() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                table[i+1][j+1] = "-";
            }
        }
        currentplayer = "X";
    }

    public int getTurnCount() {
        return turnCount;
    }
    public boolean isDraw() {
        if(turnCount < 9)
            return false;
        return true;
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public int getScoreDraw() {
        return scoreDraw;
    }
}
