# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#引入依赖包rt.jar（jdk路径）
#参考：https://www.jianshu.com/p/b471db6a01af
#-libraryjars /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/jre/lib/rt.jar
#忽略警告
-ignorewarnings
#保证是独立的jar,没有任何项目引用,如果不写就会认为我们所有的代码是无用的,从而把所有的代码压缩掉,导出一个空的jar
-dontshrink
#保护泛型,注解,反射,异常
#-keepattributes Signature,*Annotation*,EnclosingMethod,Exceptions
-dontwarn

-keep class com.patrik.logsdk.log.LogMonster{public *;}
-keep class com.patrik.logsdk.log.LogUtils{public *;}
-keep class com.patrik.logsdk.log.crashcatch.CatcherExceptionTrace{public *;}
-keep interface com.patrik.logsdk.log.crashcatch.OnCatcherExceptionTraceListener{public *;}
#参考：https://blog.51cto.com/2632450/1582863
-keep class com.patrik.logsdk.log.**$* {
    public <methods>;
}

