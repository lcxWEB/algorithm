package com.example.demo.nowcoder.offer;


import com.example.demo.assistant.TreeNode;

/**
 * Created by lichunxia on 2020-01-31 20:16
 */
public class SerAndDesOfTree {

    private int index = -1;

    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#!");
            return sb.toString();
        }
        sb.append(root.val).append("!");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strr = str.split("!");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

}
