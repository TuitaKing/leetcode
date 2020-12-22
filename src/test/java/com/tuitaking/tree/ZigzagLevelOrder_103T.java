package com.tuitaking.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ZigzagLevelOrder_103T {
    @Test
    public void test(){
        ZigzagLevelOrder_103 zigzagLevelOrder_103=new ZigzagLevelOrder_103();
        List<List<Integer>> res=zigzagLevelOrder_103.zigzagLevelOrder(TreeUtils.generateArrayToTree(new Integer[]{3,9,20,null,null,15,7}));
        Assert.assertNotNull(res);
    }
}
