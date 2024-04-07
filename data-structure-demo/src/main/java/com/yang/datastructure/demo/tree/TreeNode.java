package com.yang.datastructure.demo.tree;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @package: com.tree
 * @class: TreeNode1
 * @date: 2018/3/27
 * @author: jcroad(caoyajing @ yunmel.com)
 * java list 转树 tree 的三种写法
 * https://blog.csdn.net/jcroad/article/details/79735790
 * @since 1.0
 */
@Data
public class TreeNode {

    private Integer id;
    private Integer pid;
    private String name;
    private List<TreeNode> children;

    TreeNode(Integer id, Integer pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    /***
     * 这里并不是真正的树，而是多个类似父子关系的树的集合
     * @param args
     */

    public static void main(String[] args) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(new TreeNode(1, 0, "1"));
        list.add(new TreeNode(2, 0, "2"));
        list.add(new TreeNode(3, 2, "3"));
        list.add(new TreeNode(4, 3, "4"));
        list.add(new TreeNode(5, 4, "5"));
        list.add(new TreeNode(6, 5, "6"));

        List<TreeNode> treeList = new ArrayList<>();
        List<TreeNode> treeList1 = new ArrayList<>();
        List<TreeNode> treeList2 = new ArrayList<>();

        //方法一、
        treeList = listGetStree(list);
        //方法二、
        treeList1 = listToTree(list);
        //方法三、
        treeList2 = toTree(list);

        System.out.println(JSON.toJSONString(treeList));
        System.out.println(JSON.toJSONString(treeList1));
        System.out.println(JSON.toJSONString(treeList2));

        getChildrenIds(treeList);
    }

    /**
     * 方法一、
     * @param list
     * @return
     */
    private static List<TreeNode> listGetStree(List<TreeNode> list) {
        List<TreeNode> treeList = new ArrayList<>();
        for (TreeNode tree : list) {
            //找到根
            if (tree.getPid() == 0) {
                treeList.add(tree);
            }
            //找到子,备注：除了根节点,其他的节点会首尾相连
            for (TreeNode treeNode : list) {
                if (treeNode.getPid().equals(tree.getId())) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(new ArrayList<>());
                    }
                    tree.getChildren().add(treeNode);
                }
            }
        }
        return treeList;
    }

    /**
     * 方法二、
     *
     * @param list
     * @return
     */
    public static List<TreeNode> listToTree(List<TreeNode> list) {
        //用递归找子。
        List<TreeNode> treeList = new ArrayList<>();
        for (TreeNode tree : list) {
            if (tree.getPid() == 0) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    private static TreeNode findChildren(TreeNode tree, List<TreeNode> list) {
        for (TreeNode node : list) {
            if (node.getPid().equals(tree.getId())) {
                if (tree.getChildren() == null) {
                    tree.setChildren(new ArrayList<>());
                }
                tree.getChildren().add(findChildren(node, list));
            }
        }
        return tree;
    }

    /**
     * 方法三
     *
     * @param list
     * @return
     */
    private static List<TreeNode> toTree(List<TreeNode> list) {
        List<TreeNode> treeList = new ArrayList<>();
        for (TreeNode tree : list) {
            if (tree.getPid() == 0) {
                treeList.add(tree);
            }
        }
        for (TreeNode tree : list) {
            toTreeChildren(treeList, tree);
        }
        return treeList;
    }

    private static void toTreeChildren(List<TreeNode> treeList, TreeNode tree) {
        for (TreeNode node : treeList) {
            if (tree.getPid().equals(node.getId())) {
                if (node.getChildren() == null) {
                    node.setChildren(new ArrayList<>());
                }
                node.getChildren().add(tree);
            }
            if (node.getChildren() != null) {
                toTreeChildren(node.getChildren(), tree);
            }
        }
    }

    /**
     * 获取节点的所有子节点的ID组成的字符串
     *
     * @param treeList
     */
    private static void getChildrenIds(List<TreeNode> treeList) {
        TreeNode treeNode = treeList.get(1);
        String ids = "";
        while (treeNode.getChildren() != null){
            ids = treeNode.getChildren().stream().map(TreeNode::getName).collect(Collectors.joining(","));
        }
        System.out.println(ids);
    }

}
