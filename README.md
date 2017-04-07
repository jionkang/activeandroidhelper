# activeandroidhelper
### 功能简介
activeandroid本身非常简便，但是仍需要记住一些链式表达式   
ActiveAndroidHelper把activeandroid大部分的增删改查大部分都封装在这个静态类当中，基本数据库的操作只要一行代码即可   
比如：   
      ActiveAndroidHelper.delete(Item.class,"Name = ?","李四");   
       ActiveAndroidHelper.selectMultiItem(Item.class,"UserId ASC",null,null);   
       demo有简单的使用示例
### 使用说明
库配置和activeandroid的配置都要有
 ##### 库配置
 **必须在工程目录下的gradle加入activeandroid的mevan库地址**   

 ```groovy
 repositories {     
    mavenCentral()
    maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
}
```

##### activeandroid配置    

manifest加入
```groovy
<meta-data android:name="AA_DB_NAME" android:value="Pickrand.db" />   
<meta-data android:name="AA_DB_VERSION" android:value="5" />
```
##### ActiveAndroidHelper初始化
application中调用
```java
  ActiveAndroidHelper.init(this);
```


### 其他说明
* 数据库的升级需要脚本，具体见下面activeandroid的git    
* 使用loader需要用activeandroid的ContentProvider，需要table结构体必须复写默认的标识列如下所示(默认标识列是ID)。并且要在manifest加入provider的声明，
```java
@Table(name = "Items", id = BaseColumns._ID)
public class Item extends Model {...}
```
### maven地址
密码就放上面了
```groovy
repositories {
    maven {
        url "http://mvn.ws.netease.com/nexus/content/repositories/releases"
        credentials {
            username 'tangyang'
            password 'ning811205~'
        }
    }
}
 compile 'com.netease.activeandroid:xjtactiveandroid:1.0.+'
```

### 文档
[activeandroid](https://github.com/pardom/ActiveAndroid)

      


