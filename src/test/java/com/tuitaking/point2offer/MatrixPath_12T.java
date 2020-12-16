package com.tuitaking.point2offer;

import org.junit.Assert;
import org.junit.Test;

public class MatrixPath_12T {
    @Test
    public void test(){
        MatrixPath_12 matrixPath_12=new MatrixPath_12();
        char[][]chars=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][]chars1=new char[][]{{'a','b'},{'c','d'}};
        char[][]chars3=new char[][]{{'a','a'}};
        char[][]chars4=new char[][]{{'a'},{'a'}};
        char[][]chars5=new char[][]{{'a'}};
        char[][]chars6=new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        char[][]chars7=new char[][]{{'A','B','C','E'},
                                     {'S','F','E','S'},
                                     {'A','D','E','E'}};
        char[][]chars2=new char[][]{};
        String word = "ABCCED";
        String word1="abcd";
        String word2="aa";
        String word3="a";
        String word4="AAB";
        String word7="ABCESEEEFS";
        Assert.assertTrue(matrixPath_12.exist(chars,word));
        Assert.assertTrue(!matrixPath_12.exist(chars1,word1));
        Assert.assertTrue(!matrixPath_12.exist(chars2,word1));
        Assert.assertTrue(matrixPath_12.exist(chars3,word2));
        Assert.assertTrue(matrixPath_12.exist(chars4,word2));
        Assert.assertTrue(matrixPath_12.exist(chars5,word3));
        Assert.assertTrue(matrixPath_12.exist(chars6,word4));
        Assert.assertTrue(matrixPath_12.exist(chars7,word7));
    }
}
