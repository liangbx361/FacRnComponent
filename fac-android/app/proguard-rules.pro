# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Program Files\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
# ProGuard configurations for Bonree-Agent
-keep public class com.bonree.**{*;}
-keep public class bonree.**{*;}
-dontwarn com.bonree.**
-dontwarn bonree.**
# End Bonree-Agent# nameSpace: com.nd.sdp, bizName: uc_component, whose proguard configuration is as follows:
-dontwarn android.support.**
-dontwarn org.apache.**
-dontwarn com.**

-keepattributes **

-keep class * extends java.lang.annotation.Annotation{*;}
-keep class android.support.**{*;}
-keep class com.fasterxml.**{*;}
-keep class org.robolectric.**{*;}
-keep class com.j256.ormlite.**{*;}
-keep class com.nd.android.commons.bus.**{*;}
-keep class org.apache.http.**{*;}
-keep class org.codehaus.mojo.animal_sniffer.**{*;}
-keep class org.hamcrest.**{*;}
-keep class org.robolectric.**{*;}
-keep class com.nd.smartcan.frame.orm.**{*;}
-keep class com.nd.smartcan.datalayer.db.**{*;}
-keep class com.nd.smartcan.datalayer.cache.**{*;}
-keep class com.nd.smartcan.frame.dao.**{*;}
-keep class com.nd.smartcan.content.model.**{*;}
-keep class com.nd.smartcan.accountclient.model.**{*;}
-keep class com.sina.**{*;}
-keep class com.tencent.**{*;}
-keep class com.nd.smartcan.appfactory.nativejs.util.MapScriptable{*;}
-keep class com.nd.smartcan.appfactory.component.ComponentBase{*;}
-keep class * extends com.nd.smartcan.appfactory.component.ComponentBase{*;}
-keep class com.nd.component.Setting.**{*;}
-keep class com.nineoldandroids.**{*;}

-keep public class * implements java.io.Serializable{
public protected private *;
}
-keep class com.nd.sdp.android.module.dataanalytics.**{*;}
-keep class com.umeng.analytics.**{*;}
-keep class com.nd.smartcan.**{*;}
-keep class com.nd.component.**{*;}
-keep class com.nd.sdp.uc.**{*;}
-keep class com.nd.sdp.android.module.maincomPrivateUi.**{*;}
-keep class com.nd.sdp.android.module.ucComponentPrivateUi.**{*;}
-keep class com.nd.sdp.android.module.ucmainja.**{*;}
-keep class com.nd.sdp.android.module.ucmaincomlan.**{*;}
-keep class com.nd.android.okio.**{*;}
-keep class com.nd.android.okhttp.**{*;}
-keep class com.nd.android.smartcan.vorg.**{*;}
-keep class de.mindpipe.android.logging.**{*;}
-keep class com.nd.android.commons.bus.**{*;}
-keep class org.apache.log4j.**{*;}
-keep class com.nd.android.smartcan.**{*;}
-keep class com.nostra13.universalimageloader.**{*;}
-keep class com.nd.sdp.android.module.webview.**{*;}
-keep class com.nd.sdp.android.module.appfactorywebview.**{*;}
-keep class com.nd.sdp.thirdlogin.**{*;}
-keep class com.nd.smartcan.accountclient.**{*;}
-keep class com.nd.android.smartcan.**{*;}



# nameSpace: com.nd.smartcan.appfactory, bizName: main_component, whose proguard configuration is as follows:
-dontwarn android.support.**
-dontwarn org.apache.**
-dontwarn com.**



-keepattributes **

-keep class * extends java.lang.annotation.Annotation{*;}
-keep class android.support.**{*;}
-keep class com.fasterxml.**{*;}
-keep class org.robolectric.**{*;}
-keep class com.j256.ormlite.**{*;}
-keep class com.nd.android.commons.bus.**{*;}
-keep class org.apache.http.**{*;}
-keep class org.codehaus.mojo.animal_sniffer.**{*;}
-keep class org.hamcrest.**{*;}
-keep class org.robolectric.**{*;}
-keep class com.nd.smartcan.frame.orm.**{*;}
-keep class com.nd.smartcan.datalayer.db.**{*;}
-keep class com.nd.smartcan.datalayer.cache.**{*;}
-keep class com.nd.smartcan.frame.dao.**{*;}
-keep class com.nd.smartcan.content.model.**{*;}
-keep class com.nd.smartcan.accountclient.model.**{*;}
-keep class com.sina.**{*;}
-keep class com.tencent.**{*;}
-keep class com.nd.smartcan.appfactory.nativejs.util.MapScriptable{*;}
-keep class com.nd.smartcan.appfactory.component.ComponentBase{*;}
-keep class * extends com.nd.smartcan.appfactory.component.ComponentBase{*;}
-keep class com.nd.component.Setting.**{*;}
-keep class com.nineoldandroids.**{*;}

-keep public class * implements java.io.Serializable{
public protected private *;
}
-keep class com.nd.sdp.android.module.dataanalytics.**{*;}
-keep class com.umeng.analytics.**{*;}
-keep class com.nd.smartcan.**{*;}
-keep class com.nd.component.**{*;}
-keep class com.nd.sdp.uc.**{*;}
-keep class com.nd.sdp.android.module.maincomPrivateUi.**{*;}
-keep class com.nd.sdp.android.module.ucComponentPrivateUi.**{*;}
-keep class com.nd.sdp.android.module.ucmainja.**{*;}
-keep class com.nd.sdp.android.module.ucmaincomlan.**{*;}
-keep class com.nd.android.okio.**{*;}
-keep class com.nd.android.okhttp.**{*;}
-keep class com.nd.android.smartcan.vorg.**{*;}
-keep class de.mindpipe.android.logging.**{*;}
-keep class com.nd.android.commons.bus.**{*;}
-keep class org.apache.log4j.**{*;}
-keep class com.nd.android.smartcan.**{*;}
-keep class com.nostra13.universalimageloader.**{*;}
-keep class com.nd.sdp.android.module.webview.**{*;}
-keep class com.nd.sdp.android.module.appfactorywebview.**{*;}
-keep class com.nd.sdp.thirdlogin.**{*;}
-keep class com.nd.smartcan.accountclient.**{*;}
-keep class com.nd.android.smartcan.**{*;}
-keep class org.xmlpull.v1.**{*;}

-keep public class com.bonree.**{*;}
-keep public class bonree.**{*;}
-dontwarn com.bonree.**
-dontwarn bonree.**

-keep public class rx.**{
   *;
}
-dontwarn rx.**
-dontwarn okio.**
-keep class com.annotation.**{*;}
-keep class com.nd.android.sdp.common.photopicker.**{*;}
-keep class com.nd.component.utils.**{*;}
-keep class com.nd.component.utils.JsCacheDaoInterface.**{*;}
-keep class com.nd.component.utils.JsRestDaoInterface.**{*;}
-keep class com.nd.component.utils.MACContentJsInterface.**{*;}
-keep class com.nd.component.utils.CsJsInterface.**{*;}

-dontwarn org.**
-keep class org.**{*;}
-keep public class com.nostra13.universalimageloader.**{*;}
-keep public class com.nd.smartcan.selfimageloader.**{*;}

-dontwarn net.sf.cglib.**                                                                          
-dontwarn javassist.tools.rmi.**  
# nameSpace: com.nd.social, bizName: im, whose proguard configuration is as follows:
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:/adt-bundle-windows-x86_64-20131030/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-keep public class com.nd.module_im.appFactoryComponent.IMComponent{
    *;
}

-keep public class com.nd.module_im.im.bean.QuickReply{
    *;
}

-keep public class com.nd.module_im.im.widget.lift.PetalInfo{
    *;
}


-keep public class com.nd.module_im.im.activity.WebViewActivity$*{
    *;
}

-keep public class nd.sdp.android.im.contact.friend.model.ResultGetBlackList{
    *;
}

-keep public class nd.sdp.android.im.contact.group.ResultGetGroupMemberList{
    *;
}

-keep public class nd.sdp.android.im.contact.group.ResultSearchGroupList{
    *;
}

-keep public class com.nd.module_im.im.bean.Privilege{
    *;
}

-keep public class nd.sdp.android.im.contact.group.server_model.SGroupSyncTime{
    *;
}

-keep public class nd.sdp.android.im.contact.group.server_model.SRelatedGroup{
    *;
}

-keep public class nd.sdp.android.im.contact.group.server_model.SRelatedGroupList{
    *;
}

-keep public class com.nd.module_im.qrcode.ResultGetApps{
    *;
}

-keepattributes Exceptions,InnerClasses
-keep public class android.support.v4.widget.**{
    *;
}

-keepattributes Exceptions,InnerClasses
-keep public class rx.**{
   *;
}

-keep public class com.nd.android.sdp.im.common.lib.imagechooser.**{
   *;
}

-keep public class com.nd.android.sdp.im.common.emotion.library.**{
   *;
}

-keep public class com.nd.android.sdp.dm.**{
   *;
}

-keep public class com.nd.module_im.common.helper.aop.**{
   *;
}

-keep class org.apache.commons.lang3.**{*;}

-keep public class com.google.gson

-keep public class com.nd.media.amr.Amr2WavDecoder{
    *;
}
-keep class com.iflytek.**{*;}

-keep public class org.** {*;}

-keepattributes *Annotation*

-keepattributes SourceFile,LineNumberTable

-dontwarn com.nd.android.sdp.dm.**
-dontwarn com.nd.android.sdp.im.common.emotion.library.**
-dontwarn com.nd.android.sdp.im.common.lib.imagechooser.**
-dontwarn nd.sdp.android.im.**
-dontwarn android.support.**
-dontwarn com.nd.module_im.**
-dontwarn rx.**
-dontwarn org.jdom.**
-dontwarn org.internal.util.unsafe.**
-dontwarn uk.co.senab.photoview.**
-dontwarn org.**

-keep public class com.nd.module_im.qrcode.ResultGetApps{
    *;
}

-keepclassmembers public class ** {
   public <init>(...);
}
# nameSpace: com.nd.social, bizName: appsetting, whose proguard configuration is as follows:
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:/adt-bundle-windows-x86_64-20131030/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-keepattributes Exceptions,InnerClasses
-keep public class android.support.v4.widget.**{
    *;
}

-keep public class com.nd.ui.**{
   *;
}


-dontwarn com.nd.ui.**
-dontwarn android.support.**

-dontwarn **
# nameSpace: com.nd.social, bizName: me, whose proguard configuration is as follows:
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

# Optimization is turned off by default. Dex does not like code run
# through the ProGuard optimize and preverify steps (and performs some
# of these optimizations on its own).
-dontoptimize
-dontpreverify
# Note that if you want to enable optimization, you cannot just
# include optimization flags in your own project configuration file;
# instead you will need to point to the
# "proguard-android-optimize.txt" file instead of this one from your
# project.properties file.

-keepattributes *Annotation*
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService

# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
-keepclasseswithmembernames class * {
    native <methods>;
}

# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator CREATOR;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}


-keepattributes **

-keep class com.nd.android.pagesdk.bean.**{
    *;
}

-keepattributes Exceptions,InnerClasses
-keep public class com.nd.smartcan.**{
    *;
}

-keepattributes Exceptions,InnerClasses
-keep public class android.support.v4.widget.**{
    *;
}

-keepattributes Exceptions,InnerClasses
-keep public class com.j256.ormlite.**{
    *;
}

-keepattributes Exceptions,InnerClasses
-keep public class com.fasterxml.jackson.**{
    *;
}

-keepattributes Exceptions,InnerClasses
-keep public class com.nostra13.universalimageloader.**{
    *;
}

-keepattributes Exceptions,InnerClasses
-keep public class rx.**{
   *;
}

# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.
-dontwarn android.support.**

-dontwarn rx.**
-dontwarn com.j256.ormlite.**
-dontwarn com.fasterxml.jackson.**
-dontwarn org.apache.log4j.**
-dontwarn com.nd.android.sdp.im.common.**
-dontwarn com.nd.android.okio.**
-dontwarn com.nostra13.universalimageloader.**

-dontwarn com.nd.android.pagesdk.**
-dontwarn com.nd.android.meui.**
-dontwarn org.apache.**
-dontwarn android.util.FloatMath
# nameSpace: com.nd.social, bizName: greenhandguide, whose proguard configuration is as follows:
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:/adt-bundle-windows-x86_64-20131030/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


-keepattributes Exceptions,InnerClasses
-keep public class android.support.v4.widget.**{
    *;
}

-keep public class com.nd.ui.**{
   *;
}

-keep public class com.nd.guide.**{
   *;
}


-dontwarn com.nd.ui.**
-dontwarn com.nd.guide.**
-dontwarn android.support.**

-dontwarn **
# nameSpace: com.nd.sdp.component.testwebview, bizName: checkwebview, whose proguard configuration is as follows:
-dontwarn android.support.**
-dontwarn org.apache.**
-dontwarn com.**



-keepattributes **

-keep class * extends java.lang.annotation.Annotation{*;}
-keep class android.support.**{*;}
-keep class com.fasterxml.**{*;}
-keep class org.robolectric.**{*;}
-keep class com.j256.ormlite.**{*;}
-keep class com.nd.android.commons.bus.**{*;}
-keep class org.apache.http.**{*;}
-keep class org.codehaus.mojo.animal_sniffer.**{*;}
-keep class org.hamcrest.**{*;}
-keep class org.robolectric.**{*;}
-keep class com.nd.smartcan.frame.orm.**{*;}
-keep class com.nd.smartcan.datalayer.db.**{*;}
-keep class com.nd.smartcan.datalayer.cache.**{*;}
-keep class com.nd.smartcan.frame.dao.**{*;}
-keep class com.nd.smartcan.content.model.**{*;}
-keep class com.nd.smartcan.accountclient.model.**{*;}
-keep class com.sina.**{*;}
-keep class com.tencent.**{*;}
-keep class com.nd.smartcan.appfactory.nativejs.util.MapScriptable{*;}
-keep class com.nd.smartcan.appfactory.component.ComponentBase{*;}
-keep class * extends com.nd.smartcan.appfactory.component.ComponentBase{*;}
-keep class com.nd.component.Setting.**{*;}
-keep class com.nineoldandroids.**{*;}

-keep public class * implements java.io.Serializable{
public protected private *;
}
-keep class com.nd.sdp.android.module.dataanalytics.**{*;}
-keep class com.umeng.analytics.**{*;}
-keep class com.nd.smartcan.**{*;}
-keep class com.nd.component.**{*;}
-keep class com.nd.sdp.uc.**{*;}
-keep class com.nd.sdp.android.module.maincomPrivateUi.**{*;}
-keep class com.nd.sdp.android.module.ucComponentPrivateUi.**{*;}
-keep class com.nd.sdp.android.module.ucmainja.**{*;}
-keep class com.nd.sdp.android.module.ucmaincomlan.**{*;}
-keep class com.nd.android.okio.**{*;}
-keep class com.nd.android.okhttp.**{*;}
-keep class com.nd.android.smartcan.vorg.**{*;}
-keep class de.mindpipe.android.logging.**{*;}
-keep class com.nd.android.commons.bus.**{*;}
-keep class org.apache.log4j.**{*;}
-keep class com.nd.android.smartcan.**{*;}
-keep class com.nostra13.universalimageloader.**{*;}
-keep class com.nd.sdp.android.module.webview.**{*;}
-keep class com.nd.sdp.android.module.appfactorywebview.**{*;}
-keep class com.nd.sdp.thirdlogin.**{*;}
-keep class com.nd.smartcan.accountclient.**{*;}
-keep class com.nd.android.smartcan.**{*;}
-keep class org.xmlpull.v1.**{*;}

-keep public class com.bonree.**{*;}
-keep public class bonree.**{*;}
-dontwarn com.bonree.**
-dontwarn bonree.**

-keep public class rx.**{
   *;
}
-dontwarn rx.**
-dontwarn okio.**
-keep class com.annotation.**{*;}
-keep class com.nd.android.sdp.common.photopicker.**{*;}
-keep class com.nd.component.utils.**{*;}
-keep class com.nd.component.utils.JsCacheDaoInterface.**{*;}
-keep class com.nd.component.utils.JsRestDaoInterface.**{*;}
-keep class com.nd.component.utils.MACContentJsInterface.**{*;}
-keep class com.nd.component.utils.CsJsInterface.**{*;}
-keep class com.nd.component.utils.CsJsInterface.**{*;}

-dontwarn org.**
-keep class org.**{*;}
-keep public class com.nostra13.universalimageloader.**{*;}
-keep public class com.nd.smartcan.selfimageloader.**{*;}

-keep class com.nd.sdp.android.testwebview.wrappertest.**{*;}
-keep class com.nd.sdp.android.testwebview.**{*;}
-keep class com.nd.android.skin.**{*;}
-keep class net.sqlcipher.**{*;}
-keep class com.nd.sdp.android.common.downloader.jswrapper.**{*;}
-keep class com.nd.sdp.android.testwebview.**{*;}

