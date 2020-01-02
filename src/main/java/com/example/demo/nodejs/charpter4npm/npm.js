//包管理工具npm  能够解决NodeJS代码部署上的很多问题

//允许用户从NPM服务器下载别人编写的第三方包到本地使用。
// 允许用户从NPM服务器下载并安装别人编写的命令行程序到本地使用。
// 允许用户将自己编写的包或命令行程序上传到NPM服务器供别人使用。

// 通过输入“ npm -v”来测试是否成功安装(没试出来)
//npm 升级

//npm命令安装模块  npm install <模块名称>
// npm install express
// var express = require（'express'）;

// 模块局部安装与全局安装
// npm install express ＃本地安装＃本地安装
// npm install express -g ＃ 全局安装- 摹    ＃全局安装

//package.json  定义包属性

// 卸载模块
// 查看模块 npm ls
// 更新模块 npm
// 搜索模块

//创建模块  package.json文件是必不可少的。我们可以使用NPM生成package.json文件，生成的文件包含了基本的结果。
// npm init    (指导你完成package.json文件的创建)
// 该实用程序将指导您创建package.json文件。该实用程序将指导您完成创建程序包。json文件。
// 它仅涵盖最常见的项目，并尝试猜测合理的默认值。它仅涵盖最常见的项目，并尝试猜测合理的默认值。
//有关这些字段的权威性文档，请参见`npm help json`。---> cmd npm模块(npm/node_modules)下

// 随时按^ C退出。                         随时按^ C退出。
// 名称：（node_modules）runoob＃模块名： （（node_modules ）runoob     ＃模块名
// 版本：（1.0.0） ：                     （1.0 。0 ）
// description：Node.js测试模块（www.runoob.com）＃描述：节点。JS 测试模块（WWW 。runoob 。的COM ）＃描述
// 入口点：（index.js） ：（索引。JS ）
// 测试命令：进行测试：进行测试
// git仓库：https://github.com/runoob/runoob.git
// 关键字： ：
// 作者： ：
// 执照：（ISC） ：（ISC ）
// 即将写入……/ node_modules / package.json：

// npm adduser   注册用户
// 用户名：mcmohd
// 密码:
// 电子邮件：（此为公开）mcmohd@gmail.com

// 发布模块
// npm publish

// npm包的版本号
// 使用NPM下载和发布代码时都会接触到版本号。NPM使用语义版本号来管理代码，这里简单介绍一下。
// 语义版本号分为XYZ三位，分别代表主版本号，次版本号和补丁版本号。当代码更改时，版本号按以下原则更新。
// x.y.z // 0.0.0
// 如果只是修复bug，需要更新Z位。
// 如果是补充了功能，但是向下兼容，需要更新Y位。
// 如果有大变动，向下不兼容，需要更新X位。

//npm 更多命令  https://www.npmjs.com/package/doc
// npm help

// npm install . -g  在本地安装当前命令行程序，可用于发布前的本地测试。
// npm cache clear 清空NPM本地缓存
// npm update <package>
// npm update <package> -g
// npm unpublish <package>@<version>

// 使用cnpm
// npm install -g cnpm --registry = https：//registry.npm.taobao.org
// cnpm install [名称]
// 更多信息可以查阅：http : //npm.taobao.org/。






