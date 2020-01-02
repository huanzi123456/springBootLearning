//安装下载地址 https://nodejs.org/en/download/

//Node.js 历史版本下载地址：https://nodejs.org/dist/
//注意：Linux 上安装 Node.js 需要安装 Python 2.6 或 2.7 ，不建议安装 Python 3.0 以上版本。

// Windows 上安装 Node.js
//1、Windows 安装包(.msi)  下一步
//检测PATH环境变量是否配置了Node.js，点击开始=》运行=》输入"cmd" => 输入命令"path"，输出如下结果：

//C:\Users\Administrator>path
//PATH=C:\ProgramData\Oracle\Java\javapath;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;%JAVA_HOME%\bin;C:\Program Files\MySQL\MySQL Server 5.5\bin;D:\soft\Git\cmd;C:\Program Files\TortoiseGit\bin;D:\soft\nodejs\;C:\WINDOWS\System32\OpenSSH\;D:\soft\apache-maven-3.5.2\bin;D:\soft\curl;D:\soft\Redis\;C:\Users\Administrator\AppData\Local\Microsoft\WindowsApps;C:\Users\Administrator\AppData\Roaming\npm;D:\soft\curl;D:\apache-jmeter-4.0\lib\ext\ApacheJMeter_core.jar;D:\apache-jmeter-4.0\lib\jorphan.jar;D:\apache-jmeter-4.0\lib\logkit-2.0.jar;C:\Users\Administrator\AppData\Local\BypassRuntm
// 如果没有设置环境变量: set PATH=C:\Program Files\EasyPHP5.3.0\php;%PATH%  //微软用%% 来标识某个东西是变量，不是字符串

//2.Windows 二进制文件 (.exe)安装
//32位 http://nodejs.org/dist/v0.10.26/node.exe
//64位 http://nodejs.org/dist/v0.10.26/x64/node.exe

//3. linux install nodejs (直接使用已编译好的包)

// # wget https://nodejs.org/dist/v10.9.0/node-v10.9.0-linux-x64.tar.xz    // 下载
//     # tar xf  node-v10.9.0-linux-x64.tar.xz       // 解压
// # cd node-v10.9.0-linux-x64/                  // 进入解压目录
// # ./bin/node -v                               // 执行node命令 查看版本
// v10.9.0

//软连接  https://www.cnblogs.com/wangbaihan/p/9262224.html(参考文档)
//ln -s 源文件 目标文件。
// 我们需要在不同的目录，用到相同的文件时，我们不需要在每一个需要的目录下都放一个必须相同的文件，我们只要在某个固定的目录，放上该文件，然后在其它的 目录下用ln命令链接（link）它就可以，不必重复的占用磁盘空间。

//  解压文件的 bin 目录底下包含了 node、npm 等命令，我们可以使用 ln 命令来设置软连接：
//ln -s /usr/software/nodejs/bin/npm   /usr/local/bin/
// ln -s /usr/software/nodejs/bin/node   /usr/local/bin/


