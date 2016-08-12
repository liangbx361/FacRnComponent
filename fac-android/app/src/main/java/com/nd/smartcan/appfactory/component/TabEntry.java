/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */
package com.nd.smartcan.appfactory.component;

import java.util.Map;


/**
 * 对应tab.json中属性.
 */
public class TabEntry {

    public String text;

    public String image;

    public String image_selected;

    public String page;

    private String stick;

    private Map<String, String> param;

    public TabEntry(String text, String image, String image_selected, String page, Map<String, String> param, String stick) {
        this.text = text;
        this.image = image;
        this.image_selected = image_selected;
        this.page = page;
        this.param = param;
        this.stick = stick;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_selected() {
        return image_selected;
    }

    public void setImage_selected(String image_selected) {
        this.image_selected = image_selected;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getStick() {
        return stick;
    }

    public void setStick(String stick) {
        this.stick = stick;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }

}
