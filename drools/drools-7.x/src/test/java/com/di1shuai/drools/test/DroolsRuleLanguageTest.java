package com.di1shuai.drools.test;

import com.di1shuai.drools.entity.DroolsRuleLanguage;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shea
 * @date 2021-02-01
 * @description
 */
public class DroolsRuleLanguageTest {

    private static KieServices kieServices;

    private static KieContainer container;

    private static KieSession kieSession;

    @BeforeAll
    public static void init() {
        //设置日期格式
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm");
        // 获取KieService
        kieServices = KieServices.Factory.get();
        // 获取 Container
        container = kieServices.getKieClasspathContainer();
    }

    @BeforeEach
    public void before() {
        // 创建会话
        kieSession = container.newKieSession();
    }

    @AfterEach
    public void after() {
        kieSession.dispose();
    }

    @Test
    public void syntaxTest() {
        kieSession.insert(new DroolsRuleLanguage()
                .setNum(1)
                .setValue("https://di1shuai.com")
                .setMatchStr("https.*")
                .setNumList(List.of(
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                )));
        kieSession.insert(new DroolsRuleLanguage()
                .setNum(0)
                .setValue("http://di1shuai.com")
                .setMatchStr("https.*")
                .setNumList(List.of(
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                )));
        kieSession.fireAllRules();
    }

    @Test
    public void selectRule() {
        kieSession.insert(new DroolsRuleLanguage()
                .setNum(1)
                .setValue("https://di1shuai.com")
                .setMatchStr("https.*")
                .setNumList(List.of(
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                )));
        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("drl_contains"));
    }

    /**
     * 更新数据 规则重新触发
     */
    @Test
    public void update() {
        kieSession.insert(new DroolsRuleLanguage()
                .setUpdateYes(true)
                .setNum(1)
                .setValue("https://di1shuai.com")
                .setMatchStr("https.*")
                .setNumList(List.of(
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                )));
        kieSession.fireAllRules();
    }

    /**
     * 插入数据 规则触发
     */
    @Test
    public void insert() {
        kieSession.insert(new DroolsRuleLanguage()
                .setInsertYes(true)
                .setNum(1)
                .setValue("https://di1shuai.com")
                .setMatchStr("https.*")
                .setNumList(List.of(
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                )));
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("drl_insert"));
    }

    /**
     * 删除工作内存中的数据，并让相关的规则重新匹配
     */
    @Test
    public void retract() {
        kieSession.insert(new DroolsRuleLanguage()
                .setRetractYes(true)
                .setNum(1)
                .setValue("https://di1shuai.com")
                .setMatchStr("https.*")
                .setNumList(List.of(
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                )));
        kieSession.fireAllRules();
    }

    /**
     * 是否开启规则
     */
    @Test
    public void enabled() {
        kieSession.insert(new DroolsRuleLanguage()
                .setEnabledYes(true)
        );
        kieSession.insert(new DroolsRuleLanguage()
                .setEnabledYes(false)
        );
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("drl_enabled"));
    }

    /**
     * noloop
     */
    @Test
    public void noloop() {
        kieSession.insert(new DroolsRuleLanguage()
                .setNoloopYes(true)
        );
        kieSession.fireAllRules();
    }

    /**
     * activation group
     * <p>
     * 一个组内只有能触发一个规则
     */
    @Test
    public void activationGroup() {
        kieSession.insert(new DroolsRuleLanguage()
                .setActivationGroupYes(true)
        );
        kieSession.fireAllRules();
    }

    /**
     * agenda group
     * <p>
     * 可以激活一个组的所有规则
     */
    @Test
    public void agendaGroup() {
        kieSession.insert(new DroolsRuleLanguage()
                .setAgendaGroupYes(true)
        );
        kieSession.getAgenda().getAgendaGroup("agendaGroup2").setFocus();
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("drl_agenda_group"));
    }

    /**
     * auto focus
     * <p>
     * 可以激活一个议程组的所有规则
     * 同一个组，只要有一个设置auto-focus true 整个组都会起作用。
     */
    @Test
    public void autoFocus() {
        kieSession.insert(new DroolsRuleLanguage()
                .setAgendaGroupYes(true)
        );
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("drl_agenda_group"));
    }

    /**
     * timer
     * **方式一**：timer (int: <initial delay> <repeat interval>?)
     * <p>
     * 此种方式遵循java.util.Timer对象的使用方式，第一个参数表示几秒后执行，第二个参数表示每隔几秒执行一次，第二个参数为可选。
     * <p>
     * **方式二**：timer(cron: <cron expression>)
     * <p>
     * 此种方式使用标准的unix cron表达式的使用方式来定义规则执行的时间。
     */
    @Test
    public void timer() throws InterruptedException {
        new Thread(() -> {
            kieSession.fireUntilHalt();
        }).start();
        Thread.sleep(10000);
        kieSession.halt();
    }

    /**
     * 日期生效
     */
    @Test
    public void dateEffective(){
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("drl_dateeffective"));
    }

    /**
     * 失效日期
     */
    @Test
    public void dateExpires(){
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("drl_dateexpires"));
    }

    /**
     * global
     * 包装类 不改变
     * 引用类 改变
     *
     */
    @Test
    public void global(){
        kieSession.setGlobal("list",new ArrayList<String>());
        kieSession.setGlobal("count",Integer.valueOf(0));
        kieSession.setGlobal("drl",new DroolsRuleLanguage());
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("drl_global"));
    }

}
