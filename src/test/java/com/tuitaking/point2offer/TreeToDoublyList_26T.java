package com.tuitaking.point2offer;

import com.tuitaking.tree.TreeUtils;
import org.junit.Test;

public class TreeToDoublyList_26T {
    @Test
    public void test(){
        TreeToDoublyList_26 treeToDoublyList_26=new TreeToDoublyList_26();
        treeToDoublyList_26.treeToDoublyList(TreeUtils.generateArrayToTree(new Integer[]{4,2,5,1,3}));
    }
}
