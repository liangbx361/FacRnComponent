/**
 * 用于显示广告的Banner
 * FIXME 需要解决循环滚动
 * FIXME 定时任务循环
 * FIXME 外部传入Style
 */

'use strict'

import React, {Component, PropTypes} from 'react';
import {View, Image, Text} from 'react-native';
import {IndicatorViewPager, PagerDotIndicator} from 'rn-viewpager';

export default class BannerComponent extends Component {

    propTypes:{
        //页数
        pageNum: PropTypes.number.isRequired,
        //数据
        dataList: PropTypes.array.isRequired,
        //滑动事件
        onPageScroll: PropTypes.func
    }

    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            pageNum: this.props.pageNum,
            dataList: this.props.dataList
        };
    }

    render() {
        return (
            <View style={{flex:1}}>
                <IndicatorViewPager
                    style={{height:200}}
                    indicator={this._renderIndicator()}
                >
                    {this._renderPages()}
                </IndicatorViewPager>
            </View>
        )
    }

    _renderIndicator() {
        return (
            <PagerDotIndicator
                pageCount={this.state.pageNum}
                style={{bottom: 16}}
                dotStyle={{backgroundColor: '#FFFFFF88'}}
            />
        )
    }

    _renderPages() {
        var pages = [];

        for(var i=0; i<this.state.dataList.length; i++) {
            let dataItem = this.state.dataList[i];
            pages.push(
                <View key={i} style={{flex: 1}}>
                    <Image style={{flex: 1}} source={{uri: dataItem.url}}/>
                </View>
            )
        }

        return pages;
    }
}