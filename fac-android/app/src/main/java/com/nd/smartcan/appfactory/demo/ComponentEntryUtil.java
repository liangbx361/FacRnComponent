package com.nd.smartcan.appfactory.demo;
	
	import com.nd.smartcan.appfactory.component.ComponentEntry;
import com.nd.smartcan.appfactory.component.HandlerEventInfo;
import com.nd.smartcan.appfactory.component.TabEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
	
	public final class ComponentEntryUtil {
	
	public static HashMap<String, List<ComponentEntry>> componentEntryMap = new HashMap<String, List<ComponentEntry>>();
	private static volatile ComponentEntryUtil mManager;
	public static HashMap<String, List<TabEntry>> tabItemsEntryMap = new HashMap<String, List<TabEntry>>();
	public static HashMap<String, List<TabEntry>> tabOptionsEntryMap = new HashMap<String, List<TabEntry>>();
	
	public static ComponentEntryUtil instance() {
	if (mManager == null) {
	synchronized (ComponentEntryUtil.class) {
	if (mManager == null) {
	mManager = new ComponentEntryUtil();
	}
	}
	}
	return mManager;
	}
	
	public List<ComponentEntry> getComponentEntryList(String language) {
	if (language!=null && language.trim().length()>0) {
	return componentEntryMap.get(language);
	}
	return null;
	}
	
	public List<TabEntry> getTabItemsEntryList(String language) {
	if (language!=null && language.trim().length()>0) {
	return tabItemsEntryMap.get(language);
	}
	return null;
	}
	
	public List<TabEntry> getTabOptionsEntryList(String language) {
	if (language!=null && language.trim().length()>0) {
	return tabOptionsEntryMap.get(language);
	}
	return null;
	}
	
	public ComponentEntryUtil() {
	List<ComponentEntry> componentEntryList = null;
	ComponentEntry componentEntry = null;
	HashMap<String, Object> propMap = null;
	List<HandlerEventInfo> handlerEventList = null;
	HandlerEventInfo info = null;
	List<TabEntry> tabEntryList = null;
	TabEntry tabEntry = null;
	componentEntryList = new ArrayList<ComponentEntry>();
	// get property for namespace: com.nd.sdp, name:uc_component
	propMap = new HashMap<String, Object>();
	propMap.put("open_choose_identity","");
	propMap.put("v_org","");
	propMap.put("org_node_id","");
	propMap.put("uc_app_group_id","group.com.nd.new99u");
	propMap.put("org","nd");
	propMap.put("open_guest_mode","false");
	
	// get handler event for namespace: com.nd.sdp, name:uc_component
	handlerEventList = new ArrayList<HandlerEventInfo>();
	
	componentEntry = new ComponentEntry("com.nd.sdp","uc_component","com.nd.sdp.uc.UcComponent",handlerEventList,propMap);
	componentEntryList.add(componentEntry);
	
	// get property for namespace: com.nd.smartcan.appfactory, name:main_component
	//定义业务组件的属性
	propMap = new HashMap<String, Object>();
	propMap.put("set_status_bar_color","false");
	propMap.put("tabbar_background_image_ios","images/1459402824004.png");
	propMap.put("tabbar_item_selected_text_color","fdff3eff");
	propMap.put("bugly_appid_ios","900017114");
	propMap.put("is_show_tab","true");
	propMap.put("tabbar_background_color","");
	propMap.put("tabbar_background_image_android","");
	propMap.put("sharedUserId","");
	propMap.put("AppId","");
	propMap.put("window_soft_input_mode","");
	propMap.put("allow_check_update","true");
	propMap.put("is_open_self_tab","");
	propMap.put("tabbar_item_text_color","ffffffff");
	
	// get handler event for namespace: com.nd.smartcan.appfactory, name:main_component
	handlerEventList = new ArrayList<HandlerEventInfo>();
	//参数的含义分别是 命名空间 名称 集成ComponentBase的类路径 事件要注册和持有的事件，属性map
	componentEntry = new ComponentEntry("com.nd.smartcan.appfactory","main_component","com.nd.component.MainComponent",handlerEventList,propMap);
	//添加要注入的组件
	componentEntryList.add(componentEntry);
	
	// get property for namespace: com.nd.social, name:im
	propMap = new HashMap<String, Object>();
	propMap.put("im_bug_feedback_name","BUG反馈");
	propMap.put("im_show_org_root_users","true");
	propMap.put("im_message_voice_remind","false");
	propMap.put("im_aide_visable","true");
	propMap.put("im_placeOrder_enable","true");
	propMap.put("im_search_orgtree","true");
	propMap.put("im_show_contact_tab","true");
	propMap.put("im_friend_display_follow","true");
	propMap.put("im_message_vibrate_remind","false");
	propMap.put("im_nav_menu_sort","friend,group,official,aide,qrcode,feedback");
	propMap.put("im_orgtree_visable","true");
	propMap.put("im_bug_feedback_uid","10003342");
	propMap.put("im_sendflower_enable","true");
	propMap.put("im_chatlist_top_btn_visible","false");
	propMap.put("im_org_increment_enable","true");
	propMap.put("im_close_friend","false");
	propMap.put("im_file_base_path","99U");
	propMap.put("im_org_code_visable","true");
	propMap.put("im_address_nav_sort","friend,group,org,official");
	
	// get handler event for namespace: com.nd.social, name:im
	handlerEventList = new ArrayList<HandlerEventInfo>();
	info = new HandlerEventInfo();
	info.setmWantReristerEventName("im_click_portrait");
	info.setHandlerEventDealWithMethod("me_goToHomePage");
	info.setWantReristerId("com.nd.social.me");
	info.setIsSyncRegister(true);
	handlerEventList.add(info);
	info = new HandlerEventInfo();
	info.setmWantReristerEventName("im_click_placeOrder");
	info.setHandlerEventDealWithMethod("goFastPlaceOrder");
	info.setWantReristerId("com.nd.social.ERP");
	info.setIsSyncRegister(true);
	handlerEventList.add(info);
	
	componentEntry = new ComponentEntry("com.nd.social","im","com.nd.module_im.appFactoryComponent.IMComponent",handlerEventList,propMap);
	componentEntryList.add(componentEntry);
	
	// get property for namespace: com.nd.social, name:appsetting
	propMap = new HashMap<String, Object>();
	propMap.put("showCommonSetting","true");
	propMap.put("showHomePage","false");
	propMap.put("showAccountSecurity","false");
	propMap.put("showMoreApp","false");
	propMap.put("showUploadLog","true");
	{
	ArrayList<HashMap<String, Object>> arraylistGroup0 = new ArrayList<HashMap<String, Object>>();
	
	propMap.put("appsetting",arraylistGroup0);
	}
	
	propMap.put("showChangePassword","false");
	propMap.put("showTabConfig","");
	propMap.put("aboutUsPageUrl","");
	propMap.put("aboutUsText","");
	propMap.put("showLanguage","true");
	propMap.put("smartCleanCacheTriggerValue","100");
	
	// get handler event for namespace: com.nd.social, name:appsetting
	handlerEventList = new ArrayList<HandlerEventInfo>();
	
	componentEntry = new ComponentEntry("com.nd.social","appsetting","com.nd.guide.SettingComponent",handlerEventList,propMap);
	componentEntryList.add(componentEntry);
	
	// get property for namespace: com.nd.social, name:me
	propMap = new HashMap<String, Object>();
	propMap.put("modify_nickname_url","");
	propMap.put("me_page_header_url","http://mypage.social.web.sdp.101.com/v0.1/pages/page_headers/");
	
	// get handler event for namespace: com.nd.social, name:me
	handlerEventList = new ArrayList<HandlerEventInfo>();
	info = new HandlerEventInfo();
	info.setmWantReristerEventName("me_onClickPersonAvatar");
	info.setHandlerEventDealWithMethod("changeAvatar");
	info.setWantReristerId("com.nd.sdp.uc_component");
	info.setIsSyncRegister(true);
	handlerEventList.add(info);
	
	componentEntry = new ComponentEntry("com.nd.social","me","com.nd.android.meui.component.MeComponent",handlerEventList,propMap);
	componentEntryList.add(componentEntry);
	
	// get property for namespace: com.nd.social, name:greenhandguide
	propMap = new HashMap<String, Object>();
	propMap.put("GuideImage9","");
	propMap.put("ToolGuideButtonHide","true");
	propMap.put("GuideImage7","");
	propMap.put("GuideImage8","");
	propMap.put("FinishGuidePage","cmp://com.nd.sdp.uc_component/login");
	propMap.put("GuideImage1","images/1464163391968.png");
	propMap.put("GuideImage2","images/1464163397956.png");
	propMap.put("ToolGuideButtonImage","");
	propMap.put("GuideButtonShowAllPage","false");
	propMap.put("GuideImage5","images/1465875404775.png");
	propMap.put("IsUpdateShowGuide","false");
	propMap.put("GuideImage6","images/1465875409172.png");
	propMap.put("GuideImage3","images/1464163403695.png");
	propMap.put("FinishGuideButtonImage","images/1456725598812.png");
	propMap.put("GuideImage4","images/1464163408164.png");
	propMap.put("LaunchImage","");
	propMap.put("GuideImage10","");
	propMap.put("ToolGuideButtonPage","");
	propMap.put("guideUrl","");
	
	// get handler event for namespace: com.nd.social, name:greenhandguide
	handlerEventList = new ArrayList<HandlerEventInfo>();
	
	componentEntry = new ComponentEntry("com.nd.social","greenhandguide","com.nd.guide.GuideComponent",handlerEventList,propMap);
	componentEntryList.add(componentEntry);
	
	// get property for namespace: com.nd.sdp.component.testwebview, name:checkwebview
	propMap = new HashMap<String, Object>();
	propMap.put("goToHttp_sina","http://www.sina.com.cn?left_button=back");
	propMap.put("goToHttp_baidu","http://www.baidu.com?left_button=back");
	
	// get handler event for namespace: com.nd.sdp.component.testwebview, name:checkwebview
	handlerEventList = new ArrayList<HandlerEventInfo>();
	
	componentEntry = new ComponentEntry("com.nd.sdp.component.testwebview","checkwebview","com.nd.sdp.android.testwebview.TestComponent",handlerEventList,propMap);
	componentEntryList.add(componentEntry);
	
	
	 componentEntryMap.put("zh-CN", componentEntryList);
	
	}
	}