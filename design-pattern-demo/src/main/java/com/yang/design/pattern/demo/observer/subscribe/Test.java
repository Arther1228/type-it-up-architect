package com.yang.design.pattern.demo.observer.subscribe;

/**
 * @author yangliangchuang 2022/4/11 12:06
 */
public class Test {

    public static void main(String[] args) {
        Service service = new MessageService();

        Observice user1 = new VipUser("1", "小李");
        Observice user2 = new VipUser("2", "小王");
        Observice user3 = new VipUser("3", "小张");

        // 每个用户都进行订阅
        service.addSubscribe(user1);
        service.addSubscribe(user2);
        service.addSubscribe(user3);

        service.push("大家好，这是第一条推送");// 推送消息

        service.removeSubscribe(user2);
        service.removeSubscribe(user2);// 移除两次，会提示移除失败。

        service.push("大家好，这条推送没小王");

    }

}
