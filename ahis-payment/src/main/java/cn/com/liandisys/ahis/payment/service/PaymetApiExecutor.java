package cn.com.liandisys.ahis.payment.service;

public interface PaymetApiExecutor {

    // TODO:抽象
    void beforeExecute();
    void execute();
    void afterExecute();
    
}
