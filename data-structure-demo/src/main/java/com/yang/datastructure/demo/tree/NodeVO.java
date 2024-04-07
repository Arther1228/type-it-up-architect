package com.yang.datastructure.demo.tree;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangzhenjun
 * @date 2022/2/28 10:28
 */
@Data
public class NodeVO {
    private String id;
    private String name;
    private String pid;
    private List<NodeVO> children;
    private final Map<String, Object> map = new HashMap<>();

    public NodeVO(String id, String name, String pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
    }
}