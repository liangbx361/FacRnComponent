/**
 * 精品推荐Reducer
 */
'use strict';

import * as types from '../constants/ActionTypes';

//初始状态
const initialState = {
    bannerLoading: false,
    banner: [],
    tagLoading: false,
    tag:[],
    recommendLoading: false,
    recommend:[]
}

export default function recommend(state = initialState, action) {
    switch (action.type) {

        case types.FETCH_RECOMMEND_BANNER:
            return Object.assign({}, state, {
                bannerLoading: true,
            })
            break;

        case types.RECEIVE_RECOMMEND_BANNER:
            return Object.assign({}, state, {
                bannerLoading: false,
                banner: action.banner,
            })
            break;

        case types.FETCH_RECOMMEND_TAG:
            return Object.assign({}, state, {
                tagLoading: true,
            })
            break;

        case types.RECEIVE_RECOMMEND_TAG:
            return Object.assign({}, state, {
                tagLoading: false,
                tag: action.tag,
            })
            break;

        case types.FETCH_RECOMMEND:
            //复制属性，返回新的state
            return Object.assign({}, state, {
                recommendLoading: true,
            });

        case types.RECEIVE_RECOMMEND:
            return Object.assign({}, state, {
                recommendLoading: false,
                recommend: action.recommend,
            });

        default:
            return state;
    }
}