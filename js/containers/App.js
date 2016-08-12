/**
 * 通过容器进行连接
 */
'use strict';

//import React, {Component} from 'react';
//import {View, Text} from 'react-native'
//
//class App extends Component {
//    render() {
//        return (
//            <View>
//                <Text>App Compontent</Text>
//            </View>
//        )
//    }
//}
//
//export default App;

import React, {Component} from 'react';
import { connect } from 'react-redux'
import Recommend from '../pages/Recommend'
import * as RecommendActions from '../actions/recommend'

class App extends Component {
    render() {
        return (
            <Recommend {...this.props} />
        );
    }
}

function mapStateToProps(state) {
    return {

        recommend: state.recommend
    }
}

export default connect(mapStateToProps)(App)