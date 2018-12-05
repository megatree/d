/**
 * Created by wangzhe.bj on 2018-12-05.
 */
package index.设计模式.策略模式;

/**
 * 定义：
 * 定义一组算法，将每个算法都封装起来，并且使他们之间都可以互换
 *
 * 构成：
 * 1. Context 封装角色 封装可能的变化，屏蔽上层对具体算法的访问
 * 2. 抽象策略角色  定义每个算法必有的方法属性
 * 3. 具体策略角色  实现具体算法
 *
 * 区别：
 * 与代理模式，Context不用实现抽象接口的方法
 *
 * 缺点：
 * 1. 会暴露具体策略
 * 2. 导致扩展类激增
 *
 */