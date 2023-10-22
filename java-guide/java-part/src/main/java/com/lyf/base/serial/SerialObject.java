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

package com.lyf.base.serial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/

public class SerialObject implements Serializable {
    private Long id;
    private transient Long idCopy;

    // transient
    //    transient Object[] elementData;
    private ArrayList<String> list;

    private static final long serialVersionUID = 2184959196747496299L;

    public SerialObject(Long id, Long idCopy) {
        this.id = id;
        this.idCopy = idCopy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Long idCopy) {
        this.idCopy = idCopy;
    }


    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "SerialObject{" +
                "id=" + id +
                ", idCopy=" + idCopy +
                ", list=" + list +
                '}';
    }
}
