package com.yang.datastructure.demo.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangliangchuang 2022/6/8 16:17
 */
public class ListToMapList {

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

        //初始化
        for (NodeVO node : list) {
            node.getMap().put(node.getId(), new StringBuffer());
        }

        List<NodeVO> result = initTree(list);
        System.out.println(JSON.toJSONString(result));
    }

    public static List<NodeVO> initTree(List<NodeVO> nodeVOList) {

        for (NodeVO nodeLevel1 : nodeVOList) {
            for (NodeVO nodeLevel2 : nodeVOList) {
                if (nodeLevel2.getPid().equals(nodeLevel1.getId())) {
                    StringBuffer childIds = (StringBuffer) nodeLevel1.getMap().get(nodeLevel1.getId());
                    childIds.append("," + nodeLevel2.getId());
                    nodeLevel1.getMap().put(nodeLevel1.getId(), childIds);
                }
            }
        }
        return nodeVOList;
    }
}



