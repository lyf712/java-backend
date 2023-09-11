/*
 *    Copyright 1999-2022  lyf712
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lyf.sample.notify;

import com.lyf.sample.excutors.NotifyExecutors;

/**
 * @author liyunfei
 **/
public abstract class AbstractNotify<U/*通知目标*/,M/*通知内容*/> {

    /**
     * 通知给指定的用户.
     * @param target 通知目标
     * @param msg msg
     * @return 结果
     */
    protected abstract boolean notify(U target, M msg);

    /**
     *
     * @param listener
     */
    void notifyCallBack(NotifyListener listener,U target,M msg){
        NotifyExecutors.submit(new NotifyTask(listener, target, msg));
    }

    private  class NotifyTask implements Runnable{

        private NotifyListener listener;

        private U target;

        private M msg;

        public NotifyTask(NotifyListener listener, U target, M msg) {
            this.listener = listener;
            this.target = target;
            this.msg = msg;
        }

        @Override
        public void run() {
            try {
                boolean rs = AbstractNotify.this.notify(target,msg);
                listener.onSuccess(target,msg,rs);
            }catch (Exception e){
                listener.onException(e,target,msg);
            }

        }
    }
}
