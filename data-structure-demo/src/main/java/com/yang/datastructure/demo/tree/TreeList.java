package com.yang.datastructure.demo.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangliangchuang 2022/6/8 16:17
 */
public class TreeList {

    public static void main(String[] args) {
        NodeVO NodeVO1 = new NodeVO("1", "山东省", "0");
        NodeVO NodeVO2 = new NodeVO("2", "青岛市", "1");
        NodeVO NodeVO3 = new NodeVO("3", "市北区", "2");
        NodeVO NodeVO4 = new NodeVO("4", "济南市", "1");
        NodeVO NodeVO5 = new NodeVO("5", "浙江省", "0");
        NodeVO NodeVO6 = new NodeVO("6", "杭州市", "5");
        NodeVO NodeVO7 = new NodeVO("7", "西湖区", "6");

        List<NodeVO> list = new ArrayList<>();
        list.add(NodeVO1);
        list.add(NodeVO2);
        list.add(NodeVO3);
        list.add(NodeVO4);
        list.add(NodeVO5);
        list.add(NodeVO6);
        list.add(NodeVO7);

        // 默认父节点id为0
        List<NodeVO> nodeVOList = streamToTree(list, "1");
        System.out.println(JSON.toJSONString(nodeVOList));
    }

    public static List<NodeVO> streamToTree(List<NodeVO> treeList, String parentId) {
        List<NodeVO> list = treeList.stream()
                // 过滤父节点
                .filter(parent -> parent.getPid().equals(parentId))
                // 把父节点children递归赋值成为子节点
                .map(child -> {
                    child.setChildren(streamToTree(treeList, child.getId()));
                    return child;
                }).collect(Collectors.toList());
        return list;
    }


}



