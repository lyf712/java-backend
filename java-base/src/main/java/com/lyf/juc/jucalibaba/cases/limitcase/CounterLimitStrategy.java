package com.lyf.juc.jucalibaba.cases.limitcase;

/**
 * 设置 rate/s
 * 在1s中超过rate请求数则返回 限流，否则
 * 存在恶意在临界突发请求的问题
 * @author liyunfei
 */
public class CounterLimitStrategy implements LimitStrategy{
    
    private long counter = 0;
    private long start;
    private long rate;
    private long last=-1;
    
    public void setRate(long rate) {
        this.rate = rate;
    }
    
    // 限流只针对请求，无需关注何种用户，不是针对某个用户进行限流-
    // -可思考针对某个用户进行限流的设计
    @Override
    public synchronized String request() { // 保证请求的原子性
        return requestBasic();
    }
    
    // 当请求到限流数量是去检查时间
    String requestBasic(){
                counter++;
                if(counter==1){
                    start = System.currentTimeMillis();
                }else if(counter==rate){
                    long end = System.currentTimeMillis();
                    counter=0;// 归零
                    if(end-start<1000L){//
                        return "limit";
                    }else{
                        return "success";
                    }
                }
                return "success";
    }
    
    // 当请求一个数，则进行计算
    String requestAdvance(){
        long cur = System.currentTimeMillis();
        //counter++;
        if(last==-1){// 第一次请求
            last = cur;
            return "success";
        }
        // 一个请求所花的时间
        if(1000L/(cur-last) >= rate){
            last = cur;
            return "limit";
        }
        last = cur;
        return "success";
    }
}
