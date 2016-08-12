package com.nd.sdp.ele.rct.exam.data.depend;

import javax.inject.Singleton;

import dagger.Component;

/**
 * ProEleDataComponent
 *
 * @author yangz
 * @version 2015/9/14
 */
@Singleton
@Component(modules = {EleCourseDataModule.class})
public interface ProEleDataComponent extends EleCourseDataManagerComponent {
}
