'use strict';

import EleAppKey from './modules/AppKeyModule'
import SdpAppFactory from './modules/AppFactoryModule'

var debugEnv = {
    baseUrl: "http://elearning-gateway.dev.web.nd",
};

var testEnv = {
    baseUrl: "http://elearning-gateway.debug.web.nd",
};

var preFormalEnv = {
    baseUrl: "http://elearning-gateway.beta.web.sdp.101.com",
};

var releaseEnv = {
    baseUrl: "http://elearning-gateway.edu.web.sdp.101.com",
};

var awsEnv = {
    baseUrl: "http://elearning-gateway.aws.101.com",
};

var dyejiaEnv = {
    baseUrl: "http://gateapi.e.dyejia.cn/gateapi",
};

async function initEnv() {
    let env = releaseEnv;
    let envType = await SdpAppFactory.getEnvType();
    console.log("EnvType", envType);
    switch (envType) {
        //debug
        case 1:
            env = debugEnv;
            break;

        //test
        case 2:
            env = testEnv;
            break;

        //pre formal
        case 5:
            env = preFormalEnv;
            break;

        //release
        case 4:
        case 8:
            env = releaseEnv;
            break
    }

    env.projectId = await EleAppKey.getKey();
    console.log("projectId", env.projectId);
    return env;
}

export const ENV = initEnv();