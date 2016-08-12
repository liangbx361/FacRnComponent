由于自动生成mainList 是使用build Tool  22.0.1
 buildToolsVersion "22.0.1"
 
 如果有更新这个版本 要同步更新  etc里面的内容，改成对应版本的。
 
 
 本地要编译过 请把 build_bak.gradle 内容拷贝到 build.gradle
 
 同时在类 ClassDelegate   
 
 beforeCreate
  if (!MainComponentUtils.isAPKNotBeChange(mContext)) 
  
   if (false&&!MainComponentUtils.isAPKNotBeChange(mContext)) 