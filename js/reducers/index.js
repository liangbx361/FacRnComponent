/**
 * 注册Reducer
 */
'use strict';

import {combineReducers} from 'redux';

import recommend from './recommend'

//打包所有的reducer
const rootReducer = combineReducers({
    recommend
})

export default rootReducer;