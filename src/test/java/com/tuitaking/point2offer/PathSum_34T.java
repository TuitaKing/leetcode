package com.tuitaking.point2offer;

import com.tuitaking.tree.TreeNode;
import com.tuitaking.tree.TreeUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PathSum_34T {
    @Test
    public void test(){
        TreeNode node= TreeUtils.generateArrayToTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        PathSum_34 pathSum_34=new PathSum_34();
        List<List<Integer>> res=pathSum_34.pathSum(node,22);
        Assert.assertNotNull(res);
    }
}
