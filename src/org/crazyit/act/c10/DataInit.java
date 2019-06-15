package org.crazyit.act.c10;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;

public class DataInit {

    public static void main(String[] args) throws Exception {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        IdentityService identityService = engine.getIdentityService();
        // 添加用户组
        Group employeeGroup = saveGroup(identityService, "employeeGroup", "员工组", "Staff");
        Group hrGroup = saveGroup(identityService, "hrGroup", "人力资源组", "Staff");
        Group financeGroup = saveGroup(identityService, "financeGroup", "财务组", "Staff");
        Group managerGroup = saveGroup(identityService, "managerGroup", "经理组", "Staff");
        Group directorGroup = saveGroup(identityService, "directorGroup", "总监组", "Manager");
        Group bossGroup = saveGroup(identityService, "bossGroup", "老板组", "Manager");

        String pwd = MD5.encrypt_MD5("123456");
        System.out.println(pwd);
        // 添加用户
        User employeeA = identityService.newUser("employeeA");  // 员工a
        employeeA.setLastName("霍淇滨（员工）");
        employeeA.setPassword(pwd);
        employeeA.setEmail("huoqibin1996@163.com");
        identityService.saveUser(employeeA);
        identityService.setUserInfo(employeeA.getId(), "age", "22");    //年龄信息
        identityService.setUserInfo(employeeA.getId(),"position", "软件开发工程师");

        User employeeB = identityService.newUser("employeeB");  // 员工b
        employeeB.setLastName("刘木子（员工）");
        employeeB.setPassword(pwd);
        employeeB.setEmail("18205196528@163.com");
        identityService.saveUser(employeeB);
        identityService.setUserInfo(employeeB.getId(), "age", "19");    //年龄信息
        identityService.setUserInfo(employeeB.getId(),"position", "软件测试工程师");

        User hrA = identityService.newUser("hrA");  // 人事a
        hrA.setLastName("蒋萍（人事）");
        hrA.setPassword(pwd);
        hrA.setEmail("1259047336@qq.com");
        identityService.saveUser(hrA);
        identityService.setUserInfo(hrA.getId(), "age", "24");    //年龄信息
        identityService.setUserInfo(hrA.getId(),"position", "招聘主管");    //用户邮箱

        User hrB = identityService.newUser("hrB");  // 人事b
        hrB.setLastName("冯绍峰（人事）");
        hrB.setPassword(pwd);
        hrB.setEmail("17327878386@163.com");
        identityService.saveUser(hrB);
        identityService.setUserInfo(hrB.getId(), "age", "25");    //年龄信息
        identityService.setUserInfo(hrB.getId(),"position", "绩效考核主管");    //用户邮箱

        User financeA = identityService.newUser("financeA"); // 财务a
        financeA.setLastName("仇家辉（财务）");
        financeA.setPassword(pwd);
        financeA.setEmail("chenbingjie1111@163.com");
        identityService.saveUser(financeA);
        identityService.setUserInfo(financeA.getId(), "age", "26");    //年龄信息
        identityService.setUserInfo(financeA.getId(),"position", "出纳");    //用户邮箱

        User financeB = identityService.newUser("financeB"); // 财务b
        financeB.setLastName("魏星宇（财务）");
        financeB.setPassword(pwd);
        financeB.setEmail("luozhuangye1997@163.com");
        identityService.saveUser(financeB);
        identityService.setUserInfo(financeB.getId(), "age", "27");    //年龄信息
        identityService.setUserInfo(financeB.getId(),"position", "会计师");    //用户邮箱

        User managerA = identityService.newUser("managerA");  // 经理a
        managerA.setLastName("程浩森（经理）");
        managerA.setPassword(pwd);
        managerA.setEmail("weixingyu1223@163.com");
        identityService.saveUser(managerA);
        identityService.setUserInfo(managerA.getId(), "age", "33");    //年龄信息
        identityService.setUserInfo(managerA.getId(),"position", "部门经理");    //用户邮箱

        User managerB = identityService.newUser("managerB"); // 经理b
        managerB.setLastName("苏天昊（经理）");
        managerB.setPassword(pwd);
        managerB.setEmail("qiujiahui1997@163.com");
        identityService.saveUser(managerB);
        identityService.setUserInfo(managerB.getId(), "age", "33");    //年龄信息
        identityService.setUserInfo(managerB.getId(),"position", "部门经理");    //用户邮箱

        User directorA = identityService.newUser("directorA"); // 总监a
        directorA.setLastName("赵鹏飞（总监）");
        directorA.setPassword(pwd);
        directorA.setEmail("zhangmengqiao@163.com");
        identityService.saveUser(directorA);
        identityService.setUserInfo(directorA.getId(), "age", "32");    //年龄信息
        identityService.setUserInfo(directorA.getId(),"position", "技术总监");    //用户邮箱

        User directorB = identityService.newUser("directorB"); // 总监b
        directorB.setLastName("李俊奇（总监）");
        directorB.setPassword(pwd);
        directorB.setEmail("hushangyang@163.com");
        identityService.saveUser(directorB);
        identityService.setUserInfo(directorB.getId(), "age", "40");    //年龄信息
        identityService.setUserInfo(directorB.getId(),"position", "技术总监");    //用户邮箱

        User bossA =identityService.newUser("bossA");// 老板a
        bossA.setLastName("马云（老板）");
        bossA.setPassword(pwd);
        bossA.setEmail("17365483992@163.com");
        identityService.saveUser(bossA);
        identityService.setUserInfo(bossA.getId(), "age", "45");    //年龄信息
        identityService.setUserInfo(bossA.getId(),"position", "老板");    //用户邮箱

        // 将用户绑定到用户组
        saveRelationship(identityService, employeeA, employeeGroup);
        saveRelationship(identityService, employeeB, employeeGroup);
        saveRelationship(identityService, hrA, hrGroup);
        saveRelationship(identityService, hrB, hrGroup);
        saveRelationship(identityService, financeA, financeGroup);
        saveRelationship(identityService, financeB, financeGroup);
        saveRelationship(identityService, managerA, managerGroup);
        saveRelationship(identityService, managerB, managerGroup);
        saveRelationship(identityService, directorA, directorGroup);
        saveRelationship(identityService, directorB, directorGroup);
        saveRelationship(identityService, bossA, bossGroup);

        System.out.println("用户/用户组数据初始化成功！");
    }

    /**
     * 保存用户组信息
     * @param identityService
     * @param id 用户组id
     * @param name 用户组名称
     * @return 用户组
     */
    static Group saveGroup(IdentityService identityService, String id, String name, String type) {
        Group group = identityService.newGroup(id);
        group.setName(name);
        group.setType(type);
        identityService.saveGroup(group);
        return group;
    }

    /**
     * 保存用户和用户组关系
     * @param identityService  保存用户数据的IdentityService对象
     * @param user  用户
     * @param group 用户组
     */
    static void saveRelationship(IdentityService identityService, User user, Group group) {
        identityService.createMembership(user.getId(), group.getId());
    }
}

