'use Strict';

import * as types from '../constants/ActionTypes'
import {
    GET_RECOMMEND_BANNER,
    GET_RECOMMEND_TAG,
    GET_RECOMMENDS
} from  '../constants/Api'

import {request} from '../utils/Request'

export function fetchCache() {
    return dispatch => {
        //分发命令，表示要获取精品推荐数据
        dispatch(fetchRecommend());
        //获取缓存数据
    }
}

export function fetchNetwork() {
    console.log("fetchNetwork");
    return dispatch => {
        //未执行到?
        console.log("fetchNetwork --> dispatch");
        //dispatch(fetchRecommend())
        ////发起网络请求，获取精品推荐数据
        //return request(GET_RECOMMENDS, 'GET', "")
        //    .then((recommend) => {
        //        dispatch(reciveRecommend(recommend))
        //    })
        //    .catch(() => {
        //        //FIXME 出错，需要显示错误信息
        //        dispatch(reciveRecommend([]))
        //    });
    };
}

function fetchRecommend() {
    return {
        type: types.FETCH_RECOMMEND,
    }
}

function reciveRecommend(recommend) {
    return {
        type: types.RECEIVE_RECOMMEND,
        recommend: recommend
    }
}