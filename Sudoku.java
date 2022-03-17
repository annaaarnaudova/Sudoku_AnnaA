import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Sudoku 
{
    private int [][] sudoku;
    private int BOARD_SIZE = 9;

    public Sudoku(int sudoku[][]) 
    {
        this.sudoku = sudoku;
    }
    
    public Sudoku()
    {
        sudoku = null;
    }

    public boolean canXGoInRow(int row, int num)
    {
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            if(sudoku[row][i] == num)
            {
                return  false;
            }
        }
        return true;
    }

    public boolean canXGoInCol(int col, int num)
    {
        for(int i = 0; i < BOARD_SIZE; i++)
        {
            if(sudoku[i][col] == num)
            {
                return  false;
            }
        }
        return true;
    }

    public boolean canXGoInBox(int row, int col, int num)
    {
        int boxRow = row - row % 3;
        int boxColumn = col - col % 3;

        for (int r = boxRow; r < boxRow + 3; r++) 
        {
            for (int c = boxColumn; c < boxColumn + 3; c++) 
            {
                if (sudoku[r][c] == num) 
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canXGoHere(int row, int col, int num)
    {
        return(canXGoInRow(row, num) && canXGoInCol(col, num) && canXGoInBox(row, col, num));
    }

    public void solve() 
    {
        if (!backtrackSolve()) 
        {
            System.out.println("This sudoku can't be solved.");
        }
        else
        {
            System.out.println("This is the solved board:");
        }

        for (int i = 0; i < BOARD_SIZE; i++) 
        {
            for (int j = 0; j < BOARD_SIZE; j++) 
            {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean backtrackSolve() 
    {
        int r = 0; 
        int c = 0;
        boolean isEmptyCell = false;

        for (int row = 0; row < BOARD_SIZE; row++) 
        {
            for (int col = 0; col < BOARD_SIZE; col++)
            {
                if(!isEmptyCell)
                {
                    if (sudoku[row][col] == 0) 
                    {
                        isEmptyCell = true;
                        r = row;
                        c = col;
                    }
                }
            }
        }

        if (!isEmptyCell) 
        {
            return true;
        }

        for (int sudokuNum = 1; sudokuNum <= 9; sudokuNum++) 
        {
            if (canXGoHere(r, c, sudokuNum)) 
            {
                sudoku[r][c] = sudokuNum;
                if (backtrackSolve()) 
                {
                    return true;
                }
                sudoku[r][c] = 0;
            }
        }
        return false;
    }

    public void displayBoard(int [][] sudoku)
    {
        for(int row = 0; row < BOARD_SIZE; row++)
        {
            for(int col = 0; col < BOARD_SIZE; col++)
            {
                if(sudoku[row][col] == 0)
                {
                    System.out.print(" |");
                }
                else
                {
                    System.out.print(sudoku[row][col] + "|");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public void createUserArray()
    {
        //         int [][] userInputtedArray = new int [][]{
        //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        //             };
        for(int r = 0; r < BOARD_SIZE; r++)
        {
            for(int c = 0; c < BOARD_SIZE; c++)
            {
                Scanner in = new Scanner(System.in);
                //boolean done = false;
                //printMenu();
                int choice = in.nextInt();
                in.nextLine();

                sudoku[r][c] = choice;
            }
        }
        //sudoku = userInputtedArray;
    }

    /**
     * Prints out the menu of options for the user.
     */
    public void printMenu()
    {
        System.out.println("\n\nEnter option: ");
        System.out.println("\t 1 - Solve an Easy Sudoku \n" +
            "\t 2 - Solve a Medium Sudoku \n" +
            "\t 3 - Solve a Hard Sudoku \n" +
            "\t 4 - Solve an Extreme Sudoku " +
            "\t 5 - Solve the Hardest Sudoku " +
            "\t 6 - Bye!");
    }

    /**
     * Interacts with user and calls the appropriate method
     * 
     * @return true if the interaction is over; otherwise,
     *         false.
     */
    public boolean interactWithUser( )
    {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        printMenu();
        int choice = in.nextInt();
        in.nextLine();
        if (choice ==  1)
        { 

        }
        else if (choice == 2)
        {

        }
        else if (choice == 3)
        {

        }
        else if(choice == 4)
        {

        }
        else if(choice == 5)
        {

        }
        else if (choice == 6)
        {
            done = true;
        }
        return done;
    }

    public int[][] getBoard(int levelOfDifficulty)
    {
        Sudoku hardestBoardArray = new Sudoku(new int[][]{
                    { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                    { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                    { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                    { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                    { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                    { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                    { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                    { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
                });
        ArrayList <Sudoku> easyBoardArray = new ArrayList <Sudoku> ();
        //Sudoku [] easyBoard Array = new Sudoku        
        Sudoku easyBoardArrays = new Sudoku(new int [][]{
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
                });
        Sudoku easyBoardOne = new Sudoku(new int [][] {
                    { 7, 2, 0, 0, 1, 0, 0, 9, 6},
                    { 0, 0, 0, 0, 5, 0, 0, 0, 0},
                    { 0, 5, 9, 0, 0, 6, 0, 1, 4},
                    { 9, 0, 7, 5, 0, 0, 0, 2, 8},
                    { 3, 0, 1, 0, 2, 4, 9, 0, 5},
                    { 0, 0, 0, 0, 0, 1, 0, 0, 0},
                    { 6, 0, 0, 0, 9, 7, 2, 4, 0},
                    { 0, 0, 3, 0, 0, 5, 0, 8, 1},
                    { 0, 0, 8, 0, 3, 2, 0, 5, 9}});
        easyBoardArray.add(easyBoardOne);

        Sudoku easyBoardTwo = new Sudoku(new int [][] {
                    { 2, 6, 0, 1, 0, 0, 4, 0, 5},
                    { 0, 4, 0, 0, 9, 0, 3, 0, 0},
                    { 0, 5, 9, 3, 0, 2, 7, 0, 0},
                    { 3, 0, 6, 5, 2, 4, 0, 0, 0},
                    { 3, 0, 1, 0, 2, 4, 9, 0, 5},
                    { 0, 0, 0, 0, 0, 1, 0, 0, 0},
                    { 6, 0, 0, 0, 9, 7, 2, 4, 0},
                    { 0, 0, 3, 0, 0, 5, 0, 8, 1},
                    { 0, 0, 8, 0, 3, 2, 0, 5, 9}});
        easyBoardArray.add(easyBoardTwo);

        int randomChosenArray = (int)(Math.random()*10);
        return sudoku;
    }

    //public static void main(String args[]) 
    public void tester()
    {
        //         new Sudoku(new int[][] {
        //             { 6, 0, 7, 0, 8, 0, 4, 2, 1 },
        //             { 2, 0, 0, 4, 0, 0, 8, 0, 6 },
        //             { 0, 0, 0, 3, 0, 0, 7, 0, 0 },
        //             { 8, 0, 0, 2, 1, 0, 5, 0, 7 },
        //             { 0, 5, 0, 6, 0, 8, 1, 0, 2 },
        //             { 0, 0, 9, 7, 4, 0, 0, 0, 3 },
        //             { 0, 0, 0, 8, 2, 0, 3, 1, 0 },
        //             { 0, 0, 8, 0, 5, 7, 2, 0, 0 },
        //             { 0, 4, 0, 0, 0, 6, 0, 0, 8 }
        //         }).solve();

        Sudoku sud = new Sudoku(new int[][]{
                    { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                    { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                    { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                    { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                    { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                    { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                    { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                    { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
                });

        Sudoku sudz = new Sudoku(new int[][]{
                    { 5, 0, 8, 0, 3, 0, 0, 2, 0 },
                    { 6, 0, 3, 1, 0, 9, 0, 0, 0 },
                    { 0, 7, 0, 0, 9, 0, 2, 0, 1 },
                    { 0, 5, 0, 0, 0, 7, 0, 1, 0 },
                    { 8, 0, 9, 0, 1, 5, 7, 0, 0 },
                    { 0, 0, 0, 1, 0, 8, 0, 3, 0 },
                    { 0, 8, 1, 0, 4, 0, 0, 6, 7 },
                    { 0, 0, 8, 5, 2, 0, 0, 1, 0 },
                    { 2, 9, 0, 0, 7, 0, 4, 0, 0 } 
                });

        //sudoku = sud;

        //System.out.println("This is the original board:");
        //sud.displayBoard();

        Sudoku suds = new Sudoku(new int[][]{
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
                });

        Sudoku sudd = new Sudoku(new int[][]{
                    { 0, 2, 0, 4, 0, 7, 0, 0, 3 },
                    { 1, 0, 0, 6, 8, 0, 0, 0, 0 },
                    { 7, 4, 0, 0, 0, 0, 8, 0, 0 },
                    { 3, 0, 8, 0, 0, 0, 0, 1, 2 },
                    { 5, 0, 0, 7, 0, 0, 6, 0, 8 },
                    { 2, 6, 0, 0, 0, 0, 3, 0, 0 },
                    { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 8, 0, 6, 0, 0, 0 },
                    { 0, 0, 0, 3, 0, 4, 5, 0, 0 } 
                });

        Sudoku suddd = new Sudoku(new int[][]{
                    { 0, 0, 6, 0, 0, 1, 8, 0, 0 },
                    { 1, 0, 0, 0, 9, 0, 5, 0, 0 },
                    { 7, 8, 0, 0, 6, 0, 0, 0, 0 },
                    { 9, 5, 4, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 1, 0, 0, 0, 2, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 9, 5, 4 },
                    { 0, 0, 0, 0, 4, 0, 0, 1, 9 },
                    { 0, 0, 5, 0, 7, 0, 0, 0, 8 },
                    { 0, 0, 2, 8, 0, 0, 6, 0, 0 } 
                });  
                
        createUserArray();
        solve();
    }
}