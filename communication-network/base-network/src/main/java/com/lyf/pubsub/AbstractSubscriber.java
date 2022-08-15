package com.lyf.pubsub;

/**
 * @author liyunfei
 */
public abstract class AbstractSubscriber<T extends Event> {
      abstract void onEvent(T event);
      
}
