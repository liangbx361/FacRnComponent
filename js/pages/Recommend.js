/**
 * 精品推荐页面
 * 组成部分：
 * 1. banner (先实现)
 * 2. tag
 * 3. recommend
 */
'use Strict';

import React, {Component, PropTypes} from 'react';
import {View, ScrollView, Image, StyleSheet} from 'react-native';
import BannerComponent from '../components/BannerComponent'

import {fetchNetwork} from '../actions/recommend'

//for test
import {request} from '../utils/Request'

/**
 * banner ViewModel
 * banner: [
 *  id:
 *  url:
 * ]
 *
 *
 */

const propTypes = {
    dispatch: PropTypes.func.isRequired,
    recommend: PropTypes.object.isRequired,
}

export default class Recommend extends Component {

    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
        };
    }

    componentWillMount() {

    }

    render() {
        return (
            <ScrollView horizontal={false}>

            </ScrollView>
        );
    }

    componentDidMount() {
        //执行Action
        //console.log("执行Action");
        //const { dispatch } = this.props;
        //dispatch(fetchNetwork);

        this._testRequest();
    }

    _renderBanner() {
        return (
            <BannerComponent
                pageNum={this.state.bannerData.length}
                dataList={this.state.bannerData}
            />
        );
    }

    _renderTag() {

    }

    _renderRecommend() {

    }

    _onRefresh() {

    }

    _testRequest() {
        request("/v1/58/banners", "GET", "app_id=114")
            .then((responseData) => {
                console.log("banners", responseData);
            })
            .catch((error) => {
                console.log("error", error);
            })
    }
}

const styles = StyleSheet.create({
    banner: {
        height: 200,
    },

    tag: {
        height: 200,
    }
});